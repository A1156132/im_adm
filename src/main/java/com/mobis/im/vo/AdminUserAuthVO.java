package com.mobis.im.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 테이블명 : Admin_User_Auth
 * 
 * Auth : hahyejinny
 * Date : 2023.06.27
 * */
public class AdminUserAuthVO {

	private String ip; // 허용IP
	private String use_yn; // 사용유무 Y,N 
	private String create_dt; // 생성일 yyyyMMdd
	private String update_dt; // 변경일 yyyyMMdd
	private String create_id; // 생성 사번 
	private String update_id; // 변경 사번
	private String sys_code; // 시스템코드
	private String user_id; // 사번
	private String sys_name; // 시스템명
	
	// 담당자 추가 정보 - name, email
	private String name;
	private String email;
	
	public AdminUserAuthVO() {}

	public AdminUserAuthVO(String sys_code, String user_id, String ip, String use_yn,String create_dt,
			String update_dt, String create_id, String update_id, String sys_name) {
		
		this.sys_code = sys_code;
		this.user_id = user_id;
		this.ip = ip;
		this.use_yn = use_yn;
		this.create_dt = create_dt;
		this.update_dt = update_dt;
		this.create_id = create_id;
		this.update_id = update_id;
		this.sys_name = sys_name;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getCreate_dt() {
		return create_dt;
	}

	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}

	public String getUpdate_dt() {
		return update_dt;
	}

	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}

	public String getCreate_id() {
		return create_id;
	}

	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}

	public String getUpdate_id() {
		return update_id;
	}

	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}

	public String getSys_code() {
		return sys_code;
	}

	public void setSys_code(String sys_code) {
		this.sys_code = sys_code;
	}

	public String getUser_id() {
		return this.user_id;
	}
	
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
		
	public String getSys_name() {
		return this.sys_name;
	}
	
	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}