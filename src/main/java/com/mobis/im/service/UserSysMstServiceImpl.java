package com.mobis.im.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobis.im.common.AES256Utils;
import com.mobis.im.dao.UserSysMstDAO;
import com.mobis.im.vo.AdminUserAuthVO;

@Service("userSysMstService")
public class UserSysMstServiceImpl implements UserSysMstService {

	@Autowired
	UserSysMstDAO userSysMstDAO;

	@Override
	public List<Map<String, String>> getUserAuthListByUserId(String userId) throws Exception {
		// 사용자의 보유 시스템 권한 조회
		List<Map<String, String>> authList = userSysMstDAO.getUserAuthListByUserId(userId);
		// 시스템 별 담당자 정보 조회
		Map<String, Map<String, String>> authManagerList = getAllAuthManager();
		
		if(authList.size() != 0 && authList != null) {
			for(int i = 0; i < authList.size(); i++) {
				String sysCode = authList.get(i).get("sys_code");
				if(authManagerList.containsKey(sysCode)) {
					authList.get(i).put("sys_name",authManagerList.get(sysCode).get("sysName"));
					authList.get(i).put("sys_manager",authManagerList.get(sysCode).get("sysManager"));
				} else {
					authList.get(i).put("sys_name","");
					authList.get(i).put("sys_manager","");
				}
			}
		}
		return authList;
	}

	@Override
	public Map<String, Map<String, String>> getAllAuthManager() throws Exception {	
		List<AdminUserAuthVO> authInfoList = userSysMstDAO.getAllAuthManager();
		
		// <시스템코드, <시스템명, 담당자>>
		Map<String, Map<String, String>> managerList = new HashMap<String, Map<String, String>>(); 
		
		for(int i = 0; i < authInfoList.size(); i++) {
			AdminUserAuthVO authInfo = authInfoList.get(i);
			String sysCode = authInfo.getSys_code();
			String managerInfo = "";
			if(authInfo.getName()!=null && authInfo.getEmail() != null) {
				managerInfo = authInfo.getName()+"("+(authInfo.getEmail()!=null?AES256Utils.AES_Decode(authInfo.getEmail()):"")+")";
			}
			
			// managerList에 이미 존재하는 경우
			if(managerList.containsKey(sysCode)) {
				StringBuilder sb = new StringBuilder();
				if(managerList.get(sysCode).containsKey("sysManager")) {
					sb.append(managerList.get(sysCode).get("sysManager"));
					sb.append(", "+managerInfo);
					managerList.get(sysCode).put("sysManager", sb.toString());
				}
			} else {
				// managerList에 담당자가 없는 경우
				Map<String, String> map = new HashMap<String, String>();
				map.put("sysName", authInfo.getSys_name());
				map.put("sysManager", managerInfo);
				managerList.put(sysCode, map);
			}
		}
		
		return managerList;
	}
}