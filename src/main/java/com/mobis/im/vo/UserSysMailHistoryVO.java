package com.mobis.im.vo;

public class UserSysMailHistoryVO {
	private int idx;
	private String user_id;
	private String from_email;
	private String to_email;
	private String send_dt;
	private String flag;
	private String create_dt;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFrom_email() {
		return from_email;
	}
	public void setFrom_email(String from_email) {
		this.from_email = from_email;
	}
	public String getTo_email() {
		return to_email;
	}
	public void setTo_eamil(String to_email) {
		this.to_email = to_email;
	}
	public String getSend_dt() {
		return send_dt;
	}
	public void setSend_dt(String send_dt) {
		this.send_dt = send_dt;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}	
}
