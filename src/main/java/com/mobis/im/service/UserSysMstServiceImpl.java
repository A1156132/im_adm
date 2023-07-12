package com.mobis.im.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobis.im.common.AES256Utils;
import com.mobis.im.dao.UserSysMstDAO;

@Service("userSysMstService")
public class UserSysMstServiceImpl implements UserSysMstService {

	@Autowired
	UserSysMstDAO userSysMstDAO;

	@Override
	public List<Map<String, String>> getUserAuthListByUserId(String userId) throws Exception {
		List<Map<String, String>> authList = userSysMstDAO.getUserAuthListByUserId(userId);
		
		if(authList.size() != 0 && authList != null) {
			Map<String, List<String>> authManager = getAllAuthManager();
			for(int i = 0; i < authList.size(); i++) {
				String sysCode = authList.get(i).get("sys_code");
				if(authManager.containsKey(sysCode)) {
					String sysManager = authManager.get(sysCode).toString();
					authList.get(i).put("sys_manager", sysManager.substring(1, sysManager.length()-1));
				}
			}
		}
		return authList;
	}

	@Override
	public Map<String, List<String>> getAllAuthManager() throws Exception {	
		List<Map<String, String>> authInfoList = userSysMstDAO.getAllAuthManager();
		// <시스템, 담당자리스트>
		Map<String, List<String>> authManager = new HashMap<String, List<String>>(); 
		
		for(int i = 0; i < authInfoList.size(); i++) {
			Map<String, String> authInfo = authInfoList.get(i);
			
			String sysCode = authInfo.get("sys_code");
			
			if(!authManager.containsKey(sysCode)) {
				if(authInfo.containsKey("name") && authInfo.containsKey("email")) {
					List<String> list = new ArrayList<String>();
					list.add(authInfo.get("name")+"("+AES256Utils.AES_Decode(authInfo.get("email"))+")");
					authManager.put(sysCode, list);
				}
			} else {
				if(authInfo.containsKey("name") && authInfo.containsKey("email")) {
					authManager.get(sysCode).add(authInfo.get("name")+"("+AES256Utils.AES_Decode(authInfo.get("email"))+")");
					authManager.put(sysCode,  authManager.get(sysCode));
				}
			}
		}
		
		return authManager; 
	}
}