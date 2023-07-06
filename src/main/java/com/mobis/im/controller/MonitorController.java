package com.mobis.im.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mobis.im.common.LoginSessionUtils;
import com.mobis.im.common.Page;
import com.mobis.im.common.validaitonUtils;
import com.mobis.im.service.AdminUserAuthService;
import com.mobis.im.service.ImUserViewService;
import com.mobis.im.vo.AdminUserAuthVO;
import com.mobis.im.vo.ImUserViewVO;

/**
 *  시스템 별 동기화 현황 모니터링 페이지 
 *  
 * Auth: hahyejinny
 * Date : 2023. 06.26
 * */
@Controller
@RequestMapping("/monitor")
public class MonitorController {

	@Autowired
	public AdminUserAuthService adminUserAuthService;
	
	@Autowired
	public ImUserViewService imUserViewService;
	
	// 모니터링 페이지 호출
	@RequestMapping(value = "/sysList", method = RequestMethod.GET)
	public String initMonitor(HttpServletRequest request, Model model) {
		System.out.println("sysList");
		try {
			AdminUserAuthVO paramVO = new AdminUserAuthVO();
			List<AdminUserAuthVO> authList = new ArrayList();
			
			String login_user_id = (String) request.getSession().getAttribute("login_user_id");

			/*
			 * if(!LoginSessionUtils.checkSession(request)) { return "login"; }
			 */
			// 담당 시스템 목록 조회 (select box)
			paramVO.setUser_id(login_user_id);
			authList = adminUserAuthService.getAdminUserAuthList(paramVO);
			
			request.setAttribute("sysList", authList);
			request.setAttribute("userList", "");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/monitor/sysList";
	}
	
	// 목록조회
	@RequestMapping(value = "/provList", method = RequestMethod.POST)
	public String  provList(@RequestParam(defaultValue="1") int currentPage, HttpServletRequest request, HttpServletResponse response, Model model) {
		Map<String, Object> result = new HashMap<>();
		List<ImUserViewVO> userList = new ArrayList<ImUserViewVO>();
		List<AdminUserAuthVO> authList = new ArrayList();
		AdminUserAuthVO paramVO = new AdminUserAuthVO();

		try {
			
			// if(!LoginSessionUtils.checkSession(request)) { return "login"; }
						 
			System.out.println("provList");
			String login_user_id = (String) request.getSession().getAttribute("login_user_id");
			String user_id =  validaitonUtils.getParameterStr(request.getParameter("user_id"));
			String name =  validaitonUtils.getParameterStr(request.getParameter("user_nm"));
			String sys_code =  validaitonUtils.getParameterStr(request.getParameter("sys_code"));
			String dept_nm =  validaitonUtils.getParameterStr(request.getParameter("dept_nm"));
			String start_dt =  validaitonUtils.getParameterStr(request.getParameter("search_start_dt"));
			String end_dt =  validaitonUtils.getParameterStr(request.getParameter("search_end_dt"));
			int total_cnt = 0;
			

			paramVO.setUser_id(login_user_id);
			authList = adminUserAuthService.getAdminUserAuthList(paramVO);
			System.out.println("login_user_id="+login_user_id);
		/*
			 * String sys_code = (String) param.get("sys_code"); String search_user_id =
			 * (String) param.get("user_id"); String user_nm = (String)param.get("user_nm");
			 * String dept_nm = (String)param.get("dept_nm"); String start_dt =(String)
			 * param.get("start_dt"); String end_dt = (String)param.get("end_dt");
			 */
			System.out.println("end_dt="+end_dt);
			System.out.println("sys_code="+sys_code);
			
			if(!sys_code.equals("")) { 
				userList = imUserViewService.getImUserViewList(sys_code, currentPage, 100, user_id, name, dept_nm, start_dt, end_dt); 
				total_cnt = imUserViewService.getImUserViewTotalCntForPaging(sys_code,user_id, name,  dept_nm, start_dt,  end_dt);
			 }
			System.out.println("authList="+authList);
			System.out.println("total_cnt="+total_cnt);
			System.out.println("currentPage="+currentPage);

		//	model.addAttribute("list", new Page(total, currentPage, 50, 5, userList));
			
			model.addAttribute("sys_code", sys_code); // selected system name 
			model.addAttribute("sysList", authList); // select list 

			model.addAttribute("user_id", user_id); 
			model.addAttribute("user_nm", name); 
			model.addAttribute("dept_nm", dept_nm); 

			
			model.addAttribute("currentPage", currentPage); 
			model.addAttribute("maxPage", total_cnt/100);
			model.addAttribute("totalCnt", total_cnt);
			model.addAttribute("userList", userList); // result 
			
/*			model.addAttribute("login_user_id", login_user_id); 
			model.addAttribute("user_nm", session.getSE); 

			
			session.setAttribute("user_nm", mobisImUserVO.getName());
			session.setAttribute("branch_nm", mobisImUserVO.getBranch_nm());
			session.setAttribute("dept_nm", mobisImUserVO.getDept_nm());*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//result.put("userList", userList);
		
		return "/monitor/sysList";
	
			
	}
	
	
}