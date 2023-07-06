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
 * validaitonUtils
 * 
 * Auth: hahyejinny
 * Date: 2023. 06. 29
 * */
public class validaitonUtils {

	public static String getParameterStr(String str, String replace) throws Exception{
		
		if(null == str || str.isEmpty()) {
			return replace;
		}
		return str;
	}
	
	public static String getParameterStr(String str) throws Exception{
		
		if(null == str || str.isEmpty()) {
			return "";
		}
		return str;
	}
	


}