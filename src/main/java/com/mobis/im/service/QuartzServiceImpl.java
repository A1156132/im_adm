package com.mobis.im.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mobis.im.common.ReadFile;
import com.mobis.im.dao.UserMailDAO;
import com.mobis.im.vo.UserSysMailHistoryVO;

@Service("quartzService")
public class QuartzServiceImpl implements QuartzService {

	@Autowired
	UserMailDAO userMailDAO;

	@Autowired
	UserSysMstService userSysMstService;

	@Override
	//@Scheduled(cron="0/30 * * * * ?") // 30초
	@Scheduled(cron="0 0/1 * * * ?") // 1분
	public void getSendList() throws Exception {
		List<UserSysMailHistoryVO> sendList = userMailDAO.getSendList();
		
		if(sendList != null && sendList.size() > 0) {
			for(int n = 0; n < sendList.size(); n++) {
				System.out.println("메일발송 프로시저 호출");
				/*
				 * #{to_email}, #{user_id}, #{subject}, #{text}
				 */
								
				UserSysMailHistoryVO user = sendList.get(n);
				Map<String, String> sendInfo = new HashMap<String, String>();
				sendInfo.put("user_id", user.getUser_id());
				sendInfo.put("to_email", "a1156132@mobis-partners.com");
				sendInfo.put("subject", "IM 메일 발송 테스트");
				
				StringBuffer sb = ReadFile.readFile();
				int offset = sb.indexOf("<tbody>")+7;
				// 시스템 권한 행추가
				List<Map<String, String>> authList = userSysMstService.getUserAuthListByUserId(user.getUser_id());
				// sys_code | sys_name | sys_manager | prov_dt | flag | sync_dt |
				StringBuffer rows = new StringBuffer();
				for(int i = 0; i < authList.size(); i++) {
					Map<String, String> auth = authList.get(i);
					String flag = (auth.get("flag")!=null && !auth.get("flag").equals(""))?"O":"X";
					rows.append("<tr>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+auth.get("sys_code")+"</td>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+auth.get("sys_name")+"</td>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+auth.get("sys_manager")+"</td>");
					rows.append("<td style=\"border: 1px solid; border-color:#dee2e6; padding: 5px 12px; text-align: left;\">"+auth.get("prov_dt")+"</td>");
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
