package com.mobis.im.vo;

/**
 * 테이블명 : User_Sys_Mst_Sync, User_Sys_Mst_Ex 
 * 
 * Auth : junga
 * Date : 2023.06.27
 * */
public class UserSysMstVO {
	String branch_cd;		// 법인코드
	String user_id;		// 사번
	String sys_code;		// 시스템코드
	String status;			// 재직상태
	String update_dt;	// 변경일
	String create_dt;		// 생성일
	String prov_dt;		// 프로비전일
	String sync_ip;		// 싱크IP
	String desc;			// 싱크설명
	String flag;				// 싱크 flag
	String sync_dt;		// 싱크 일자
	
	public UserSysMstVO() {}
	
	public UserSysMstVO(String branch_cd, String user_id, String sys_code, String status, String update_dt,
			String create_dt, String prov_dt, String sync_ip, String desc, String flag, String sync_dt) {
		super();
		this.branch_cd = branch_cd;
		this.user_id = user_id;
		this.sys_code = sys_code;
		this.status = status;
		this.update_dt = update_dt;
		this.create_dt = create_dt;
		this.prov_dt = prov_dt;
		this.sync_ip = sync_ip;
		this.desc = desc;
		this.flag = flag;
		this.sync_dt = sync_dt;
	}
	
	public String getBranch_cd() {
		return branch_cd;
	}
	public void setBranch_cd(String branch_cd) {
		this.branch_cd = branch_cd;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getSys_code() {
		return sys_code;
	}
	public void setSys_code(String sys_code) {
		this.sys_code = sys_code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUpdate_dt() {
		return update_dt;
	}
	public void setUpdate_dt(String update_dt) {
		this.update_dt = update_dt;
	}
	public String getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}
	public String getProv_dt() {
		return prov_dt;
	}
	public void setProv_dt(String prov_dt) {
		this.prov_dt = prov_dt;
	}
	public String getSync_ip() {
		return sync_ip;
	}
	public void setSync_ip(String sync_ip) {
		this.sync_ip = sync_ip;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getSync_dt() {
		return sync_dt;
	}
	public void setSync_dt(String sync_dt) {
		this.sync_dt = sync_dt;
	}
	@Override
	public String toString() {
		return "UserSysMstVO [branch_cd=" + branch_cd + ", user_id=" + user_id + ", sys_code=" + sys_code + ", status="
				+ status + ", update_dt=" + update_dt + ", create_dt=" + create_dt + ", prov_dt=" + prov_dt
				+ ", sync_ip=" + sync_ip + ", desc=" + desc + ", flag=" + flag + ", sync_dt=" + sync_dt + "]";
	}
	
}