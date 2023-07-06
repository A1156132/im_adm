package com.mobis.im.vo;


/**
 * 뷰명 : #시스템명#_im_user
 * 
 * "*" 별표는 본사만 사용하는 컬럼
 * Auth : hahyejinny
 * Date : 2023.06.29
 * */
public class ImUserViewVO {
	private String branch_cd; // 법인코드
	private String branch_nm; // 법인명
	private String user_type ; // 계정유형 HR, GHR, THR, VD, EX, GEX
	private String val_chk; // 유효성 체크 
	private String user_id; //사번
	private String name; // 사용자명
	private String dept_cd; // 부서코드
	private String dept_nm; // 부서명
	private String dept_2nd_cd; //제2겸직 부서코드*
	private String dept_2nd_nm; //제2겸직 부서명 *
	private String dept_3rd_cd; //제3겸직 부서코드*
	private String dept_3rd_nm; //제3겸직 부서명* (본사만 사용)
	private String part_mgr_id; // 파트장 사번*
	private String dept_mgr_id; // 부서장 사번*
	private String sil_mgr_id; // 실장 사번*
	private String div_mgr_id; //부문장사번*
	private String expat_yn; // 주재원여부
	private String domian; // 근무지
	private String name_kr; // 이름(한글)
	private String name_en; // 이름(영문)
	private String name_zh; // 이름(중문)
	private String short_nm; //이름약어
	private String position_cd; // 직위코드
	private String position_nm; // 직위명
	private String position_out_cd; // 직위코드(외부)*
	private String position_out_nm; // 직위명(외부)*
	private String duty_cd; // 직책코드
	private String duty_nm; // 직책명
	private String ctech; // 국가핵심기술취급자 *
	private String emp_group_cd; // 사용자구분 (officeWorker, factoryWorker, intern ..)
	private String emp_group_nm; // 사용자구분명
	private String email; // 모비스이메일
	private String email_ext; // 외부 이메일
	private String mobile; // 모바일
	private String office_tel; //사무실 연락처
	private String fax; // 팩스
	private String work_place_cd; // 근무지코드(*
	private String wrok_palce_nm; // 근무지명*
	private String jobinfo; // 업무
	private String jobdetail1; //상세업무1*
	private String jobdetail2; //상세업무2*
	private String jobdetail3; //상세업무3*
	private String status; // 계정 상태 3:재직 0:퇴직 1:휴직
	private String retire_dt; // 퇴직일yyyyMMdd
	private String hired_dt; // 고용일yyyMMdd*
	private String retire_exp_dt; // 퇴직예정일
	private String transfer_dt; // 부서이동일*
	private String corp_cd; // 회사코드(사업자번호랑은 다름)
	private String corp_nm; //회사명
	private String license_cd; // 회사사업자번호
	private String prov_dt; // 프로비전날짜 yyyyMMddHHssmm
	
	private String sync_dt; // 데이터동기화날짜 yyyyMMdd,[SYNC_DT]
	private String flag; // 데이터 동기화 여부  
	private String sync_up; // 데이터 동기화한 시스템IP
	private String desc; // 데이터 동기화 결과
	
	
	// -- paging
	public int pageNumber; // 클릭한 페이지 수 
	public int page_rows; // 페이징 하단 목록개수
	public int total_cnt; // 전체 row수 
	
	public String getBranch_cd() {
		return branch_cd;
	}
	public void setBranch_cd(String branch_cd) {
		this.branch_cd = branch_cd;
	}
	public String getBranch_nm() {
		return branch_nm;
	}
	public void setBranch_nm(String branch_nm) {
		this.branch_nm = branch_nm;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getVal_chk() {
		return val_chk;
	}
	public void setVal_chk(String val_chk) {
		this.val_chk = val_chk;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getDept_2nd_cd() {
		return dept_2nd_cd;
	}
	public void setDept_2nd_cd(String dept_2nd_cd) {
		this.dept_2nd_cd = dept_2nd_cd;
	}
	public String getDept_2nd_nm() {
		return dept_2nd_nm;
	}
	public void setDept_2nd_nm(String dept_2nd_nm) {
		this.dept_2nd_nm = dept_2nd_nm;
	}
	public String getDept_3rd_cd() {
		return dept_3rd_cd;
	}
	public void setDept_3rd_cd(String dept_3rd_cd) {
		this.dept_3rd_cd = dept_3rd_cd;
	}
	public String getDept_3rd_nm() {
		return dept_3rd_nm;
	}
	public void setDept_3rd_nm(String dept_3rd_nm) {
		this.dept_3rd_nm = dept_3rd_nm;
	}
	public String getPart_mgr_id() {
		return part_mgr_id;
	}
	public void setPart_mgr_id(String part_mgr_id) {
		this.part_mgr_id = part_mgr_id;
	}
	public String getDept_mgr_id() {
		return dept_mgr_id;
	}
	public void setDept_mgr_id(String dept_mgr_id) {
		this.dept_mgr_id = dept_mgr_id;
	}
	public String getSil_mgr_id() {
		return sil_mgr_id;
	}
	public void setSil_mgr_id(String sil_mgr_id) {
		this.sil_mgr_id = sil_mgr_id;
	}
	public String getDiv_mgr_id() {
		return div_mgr_id;
	}
	public void setDiv_mgr_id(String div_mgr_id) {
		this.div_mgr_id = div_mgr_id;
	}
	public String getExpat_yn() {
		return expat_yn;
	}
	public void setExpat_yn(String expat_yn) {
		this.expat_yn = expat_yn;
	}
	public String getDomian() {
		return domian;
	}
	public void setDomian(String domian) {
		this.domian = domian;
	}
	public String getName_kr() {
		return name_kr;
	}
	public void setName_kr(String name_kr) {
		this.name_kr = name_kr;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public String getName_zh() {
		return name_zh;
	}
	public void setName_zh(String name_zh) {
		this.name_zh = name_zh;
	}
	public String getShort_nm() {
		return short_nm;
	}
	public void setShort_nm(String short_nm) {
		this.short_nm = short_nm;
	}
	public String getPosition_cd() {
		return position_cd;
	}
	public void setPosition_cd(String position_cd) {
		this.position_cd = position_cd;
	}
	public String getPosition_nm() {
		return position_nm;
	}
	public void setPosition_nm(String position_nm) {
		this.position_nm = position_nm;
	}
	public String getPosition_out_cd() {
		return position_out_cd;
	}
	public void setPosition_out_cd(String position_out_cd) {
		this.position_out_cd = position_out_cd;
	}
	public String getPosition_out_nm() {
		return position_out_nm;
	}
	public void setPosition_out_nm(String position_out_nm) {
		this.position_out_nm = position_out_nm;
	}
	public String getDuty_cd() {
		return duty_cd;
	}
	public void setDuty_cd(String duty_cd) {
		this.duty_cd = duty_cd;
	}
	public String getDuty_nm() {
		return duty_nm;
	}
	public void setDuty_nm(String duty_nm) {
		this.duty_nm = duty_nm;
	}
	public String getCtech() {
		return ctech;
	}
	public void setCtech(String ctech) {
		this.ctech = ctech;
	}
	public String getEmp_group_cd() {
		return emp_group_cd;
	}
	public void setEmp_group_cd(String emp_group_cd) {
		this.emp_group_cd = emp_group_cd;
	}
	public String getEmp_group_nm() {
		return emp_group_nm;
	}
	public void setEmp_group_nm(String emp_group_nm) {
		this.emp_group_nm = emp_group_nm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_ext() {
		return email_ext;
	}
	public void setEmail_ext(String email_ext) {
		this.email_ext = email_ext;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOffice_tel() {
		return office_tel;
	}
	public void setOffice_tel(String office_tel) {
		this.office_tel = office_tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWork_place_cd() {
		return work_place_cd;
	}
	public void setWork_place_cd(String work_place_cd) {
		this.work_place_cd = work_place_cd;
	}
	public String getWrok_palce_nm() {
		return wrok_palce_nm;
	}
	public void setWrok_palce_nm(String wrok_palce_nm) {
		this.wrok_palce_nm = wrok_palce_nm;
	}
	public String getJobinfo() {
		return jobinfo;
	}
	public void setJobinfo(String jobinfo) {
		this.jobinfo = jobinfo;
	}
	public String getJobdetail1() {
		return jobdetail1;
	}
	public void setJobdetail1(String jobdetail1) {
		this.jobdetail1 = jobdetail1;
	}
	public String getJobdetail2() {
		return jobdetail2;
	}
	public void setJobdetail2(String jobdetail2) {
		this.jobdetail2 = jobdetail2;
	}
	public String getJobdetail3() {
		return jobdetail3;
	}
	public void setJobdetail3(String jobdetail3) {
		this.jobdetail3 = jobdetail3;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRetire_dt() {
		return retire_dt;
	}
	public void setRetire_dt(String retire_dt) {
		this.retire_dt = retire_dt;
	}
	public String getHired_dt() {
		return hired_dt;
	}
	public void setHired_dt(String hired_dt) {
		this.hired_dt = hired_dt;
	}
	public String getRetire_exp_dt() {
		return retire_exp_dt;
	}
	public void setRetire_exp_dt(String retire_exp_dt) {
		this.retire_exp_dt = retire_exp_dt;
	}
	public String getTransfer_dt() {
		return transfer_dt;
	}
	public void setTransfer_dt(String transfer_dt) {
		this.transfer_dt = transfer_dt;
	}
	public String getCorp_cd() {
		return corp_cd;
	}
	public void setCorp_cd(String corp_cd) {
		this.corp_cd = corp_cd;
	}
	public String getCorp_nm() {
		return corp_nm;
	}
	public void setCorp_nm(String corp_nm) {
		this.corp_nm = corp_nm;
	}
	public String getLicense_cd() {
		return license_cd;
	}
	public void setLicense_cd(String license_cd) {
		this.license_cd = license_cd;
	}
	public String getProv_dt() {
		return prov_dt;
	}
	public void setProv_dt(String prov_dt) {
		this.prov_dt = prov_dt;
	}
	public String getSync_dt() {
		return sync_dt;
	}
	public void setSync_dt(String sync_dt) {
		this.sync_dt = sync_dt;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getSync_up() {
		return sync_up;
	}
	public void setSync_up(String sync_up) {
		this.sync_up = sync_up;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public int getPageNumber() {
		return pageNumber;
	}

	public int getPage_rows() {
		return page_rows;
	}
	public void setPage_rows(int page_rows) {
		this.page_rows = page_rows;
	} 
	
	public int getTotal_cnt() {
		return total_cnt;
	}
	public void setTotal_cnt(int total_cnt) {
		this.total_cnt = total_cnt;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
		
	} 
	
	
	
}