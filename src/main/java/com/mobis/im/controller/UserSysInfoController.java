package com.mobis.im.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import com.mobis.im.service.UserSysMstService;
/**
 * 협력사 계정 권한 조회 화면
 * 
 * Auth : junga
 * Date : 2023.06.27
 */
@Controller
@RequestMapping("/user")
public class UserSysInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSysInfoController.class); 

	@Autowired
	UserSysMstService userSysService;
	
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public ModelAndView userAuth(@RequestParam String pram) throws Exception {
		System.out.println("User Auth Controller");
		String userId = pram;
		ModelAndView mav = new ModelAndView();
		List<Map<String, String>> authList = userSysService.getUserAuthListByUserId(userId);
		mav.addObject("authList", authList);
		mav.addObject("managerInfo",userSysService.getAllAuthManager());
		mav.setViewName("/user/auth");
		return mav;
	}
}