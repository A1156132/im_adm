package com.mobis.im.common;

import java.util.Hashtable;


import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.mobis.im.service.AdminUserAuthService;
import com.mobis.im.vo.AdminUserAuthVO;
import com.mobis.im.vo.MobisImUserVO;

/**
 * Session
 * 
 * Auth: hahyejinny
 * Date: 2023. 06. 28
 * */
public class LoginSessionUtils {

	
	// 세션 삭제
	public static String deleteSession(HttpServletRequest request) throws Exception{
		
		HttpSession session = request.getSession(); 
		session.invalidate();
		return null;
	}
	
	// 세션체크
	public static boolean checkSession(HttpServletRequest request) throws Exception{
		
		boolean result = false;
		boolean isValidSession = request.isRequestedSessionIdValid();
		HttpSession session = request.getSession();

		if(session != null && !isValidSession) {
			result = true;
		}
		
		return result;
	}
	
	
}