package com.mobis.im.common;

import java.util.Hashtable;


import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;


public class LDAPUtil {

	/*
	 * LDAP 인증 return: user_id
	 */
	public static String getLDAPCheck(String user_id) {

		// AD LDAP ADMIN 정보
		String ADMIN_ID = "service_im@mobis.co.kr";
		String ADMIN_PWD = "M0b!sim#12";
		String LDAP_IP = "LDAP://10.10.156.128"; // pjldap.mobis.co.kr(10.10.156.128)
		// String user_id = request.getParameter("pram") == null ? "" : request.getParameter("pram");
		try {
			user_id = AES256Utils.AES_Decode(user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String searchBase = "OU=Employee,DC=mobis,DC=co,DC=kr";

		Hashtable<String, String> admin_env = new Hashtable<String, String>();

		admin_env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		admin_env.put(Context.PROVIDER_URL, LDAP_IP);
		admin_env.put(Context.SECURITY_AUTHENTICATION, "simple");
		admin_env.put(Context.SECURITY_PRINCIPAL, ADMIN_ID);
		admin_env.put(Context.SECURITY_CREDENTIALS, ADMIN_PWD);

		try {
			// ADMIN 연결
			LdapContext ctx = new InitialLdapContext(admin_env, null);

			SearchControls ctls = new SearchControls();
			ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			ctls.setReturningAttributes(new String[] { "samAccountName" });
			
			String searchFilter = String.format("(&(objectClass=user)(sAMAccountName=%s))", user_id);
			
			NamingEnumeration<SearchResult> answer = ctx.search(searchBase, searchFilter, ctls);			
			while (answer.hasMoreElements()) {
				SearchResult sr = (SearchResult) answer.next();
				// Attributes attrs = sr.getAttributes();
				// user_id = attrs.get("samAccountName").toString();
				// 휴직자이거나 퇴직자인경우
				if (sr.getName().indexOf("LEAVE") > -1 || sr.getName().indexOf("Recycle Bin") > -1) {
					System.out.println("[CustomAuthFilter] not accessible. = " + sr.getName());
					user_id = "";
				}
			}

		} catch (NamingException e) {
			String msg = e.getMessage();

			if (msg.indexOf("data 525") > 0) {
				System.out.println("사용자를 찾을 수 없음.");
			} else if (msg.indexOf("data 773") > 0) {
				System.out.println("사용자는 암호를 재설정해야합니다.");
			} else if (msg.indexOf("data 52e") > 0) {
				System.out.println("ID와 비밀번호가 일치하지 않습니다.확인 후 다시 시도해 주십시오.");
			} else if (msg.indexOf("data 533") > 0) {
				System.out.println("입력한 ID는 비활성화 상태 입니다.");
			} else if (msg.indexOf("data 532") > 0) {
				System.out.println("암호가 만료되었습니다.");
			} else if (msg.indexOf("data 701") > 0) {
				System.out.println("AD에서 계정이 만료됨");
			} else {
				System.out.println("정상!");
			}

			e.printStackTrace();
		} catch (Exception nex) {
			System.out.println("Active Directory Connetion: FAILED");
			nex.printStackTrace();
		}

		return user_id;
	}
}