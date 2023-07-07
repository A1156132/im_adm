package com.mobis.im.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mobis.im.common.IPUtils;
import com.mobis.im.common.validaitonUtils;
import com.mobis.im.service.AdminUserAuthService;
import com.mobis.im.vo.AdminUserAuthVO;
import com.mobis.im.vo.MobisImUserVO;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

/**
 * 로그인화면
 * 
 * Auth : hahyejinny
 * Date : 2023. 06. 27
 * */
@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class); 
	
	@Autowired
	public AdminUserAuthService adminUserAuthService;
	
	
	// 초기 화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		return "login";
	}

	
	@RequestMapping(value = "/loginChk", method = RequestMethod.POST)
	public String loginChk(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception{
		
		// 테스트 컨트롤러
		Map<String, Object> result = new HashMap<>();
		String login_user_id =   validaitonUtils.getParameterStr(request.getParameter("login_user_id"));

		String paramUserIP = IPUtils.getClientIp(request);
		AdminUserAuthVO adminUserAuthVO = new AdminUserAuthVO();
		MobisImUserVO mobisImUserVO = new MobisImUserVO();
		boolean ipChk =  false;
		String returnURL = "redirect:/login";
		try{
			
			if(!paramUserIP.equals("") && !login_user_id.equals("")) {
				
				adminUserAuthVO.setUser_id(login_user_id);

				// 입력한 사번으로 use=Y인것 1개만 조회
				adminUserAuthVO = adminUserAuthService.getIPCheck(adminUserAuthVO);
			//	LOGGER.debug("loginChk Access :: adminUserAuthVO is "+adminUserAuthVO.getIp()+", ip is "+paramUserIP);
				System.out.println("loginChk Access :: adminUserAuthVO is "+adminUserAuthVO.getIp()+", ip is "+login_user_id);

				if(adminUserAuthVO != null && paramUserIP.equals(adminUserAuthVO.getIp())) {
					ipChk = true;
					
					// 세션처리
					HttpSession session = request.getSession();
					int sessionTime = 60*60; // 세션 유지 시간 (초단위) 1시간
					session.setMaxInactiveInterval(sessionTime);
				
					mobisImUserVO.setUser_id(login_user_id);
					
					// 사용자 정보 조회
					// mobisImUserVO = userService.getUserInfo(mobisImUserVO);
					
					session.setAttribute("sessionID", session.getId());
					session.setAttribute("login_user_id", login_user_id);
					/*
					 * session.setAttribute("user_nm", mobisImUserVO.getName());
					 * session.setAttribute("branch_nm", mobisImUserVO.getBranch_nm());
					 * session.setAttribute("dept_nm", mobisImUserVO.getDept_nm());
					 */
					
					returnURL = "redirect:/monitor/sysList";
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			LOGGER.error("loginChk error :: ", e);
		}
  
        
		return returnURL;
	}

}