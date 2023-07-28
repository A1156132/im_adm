package com.mobis.im.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mobis.im.common.ReadFile;
import com.mobis.im.dao.UserMailDAO;
import com.mobis.im.service.UserSysMstService;
import com.mobis.im.vo.UserSysMailHistoryVO;

@Component("sysMailComponent")
public class SysMailScheduling {

	@Autowired
	UserMailDAO userMailDAO;

	@Autowired
	UserSysMstService userSysMstService;
	
	public void sendSysMail() throws Exception {
		List<UserSysMailHistoryVO> sendList = userMailDAO.getSendList();
		
		if(sendList != null && sendList.size() > 0) {
			for(int n = 0; n < sendList.size(); n++) {
				UserSysMailHistoryVO user = sendList.get(n);
				Map<String, String> sendInfo = new HashMap<String, String>();
				
				// 테스트 - 하드코딩 영역 수정 필요(user_id, to_email)
				user.setUser_id("DT095926");
				sendInfo.put("user_id", user.getUser_id());
				sendInfo.put("to_email", "a1156132@mobis-partners.com");
				sendInfo.put("subject", "[HYUNDAI MOBIS] "+user.getUser_id()+" 계정 안내 (Account Guide)");
				
				
				StringBuffer sb = ReadFile.readFile();
				
				// ID 매핑
				while(sb.indexOf("@ID")!=-1) {
					int idIdx = sb.indexOf("@ID");
					sb.replace(idIdx, idIdx+3, user.getUser_id());
				}
				// mail, teams 사용유무 매핑
				
				int offset = sb.indexOf("<tbody>")+7;
				// 시스템 권한 행추가
				List<Map<String, String>> authList = userSysMstService.getUserAuthListByUserId(user.getUser_id());
				// sys_code | sys_name | sys_manager | prov_dt | flag | sync_dt |
				StringBuffer rows = new StringBuffer();
				for(int i = 0; i < authList.size(); i++) {
					Map<String, String> auth = authList.get(i);
					String flag = (auth.get("flag")!=null && !auth.get("flag").equals(""))?"O":"X";
					String prov_dt = auth.get("prov_dt");
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
					Date date = format.parse(prov_dt);
					SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					prov_dt = newFormat.format(date);
					rows.append("<tr>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+auth.get("sys_code")+"</td>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+auth.get("sys_name")+"</td>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+auth.get("sys_manager")+"</td>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+prov_dt+"</td>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+flag+"</td>");
					rows.append("</tr>");
				}
				sb.insert(offset, rows);
				sendInfo.put("text", sb.toString());
				System.out.println(user.getUser_id()+": "+user.getTo_email());
				// 메일 발송 프로시저 호출
				String result = userMailDAO.procSendSysListMail(sendInfo);
			}
		}
	}

}
