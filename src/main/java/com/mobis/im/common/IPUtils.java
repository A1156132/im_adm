package com.mobis.im.common;

import javax.servlet.http.HttpServletRequest;
/**
 * IP관련 유틸
 * 
 * Auth : hahyejinny
 * Date : 2023. 06. 27
 * */
public class IPUtils {

	public static String getClientIp(HttpServletRequest request) {
		   
	    String ip = request.getHeader("X-Forwarded-For");

	    if (ip == null) {
	        ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null) {
	        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null) {
	        ip = request.getRemoteAddr();
	    }
	    
	    return ip;
	}
}