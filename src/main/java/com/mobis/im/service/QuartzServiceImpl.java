package com.mobis.im.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mobis.im.dao.UserMailDAO;
import com.mobis.im.vo.UserSysMailHistoryVO;

@Service("quartzService")
public class QuartzServiceImpl implements QuartzService {

	@Autowired
	UserMailDAO userMailDAO;

	@Override
	//@Scheduled(cron="0/30 * * * * ?") // 30초
	@Scheduled(cron="0 0/1 * * * ?") // 1분
	public void getSendList() throws Exception {
		List<UserSysMailHistoryVO> sendList = userMailDAO.getSendList();
		
		if(sendList != null && sendList.size() > 0) {
			for(int i = 0; i < sendList.size(); i++) {
				System.out.println("메일발송 프로시저 호출");
				/*
				 * #{to_email}, #{user_id}, #{subject}, #{text}
				 */
				
				
				UserSysMailHistoryVO user = sendList.get(i);
				Map<String, String> sendInfo = new HashMap<String, String>();
				sendInfo.put("user_id", user.getUser_id());
//				sendInfo.put("to_email", user.getTo_email());
				sendInfo.put("to_email", "a1156132@mobis-partners.com");
				sendInfo.put("subject", "IM 메일 발송 테스트");
				
				// 메일 내용
				StringBuffer sb = new StringBuffer();
				sb.append("<html><body>");
		 		sb.append("<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>");
		 		sb.append("<h1>"+"사용자"+"<h1><br>");
		 		sb.append(user.getUser_id()+"<br><br>");
				sb.append("</body></html>");
				
//				sendInfo.put("text", sb.toString());
				sendInfo.put("text", "테스트");
				System.out.println(user.getUser_id()+": "+user.getTo_email());
				// 메일 발송 프로시저 호출
				String result = userMailDAO.procSendSysListMail(sendInfo);
			}
		}
	}
}
