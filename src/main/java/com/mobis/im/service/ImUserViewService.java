package com.mobis.im.service;

import java.util.List;

import com.mobis.im.vo.ImUserViewVO;

public interface ImUserViewService {
	public ImUserViewVO getImUserView(String sys_code) throws Exception;

	public List<ImUserViewVO> getImUserViewList(String sys_code, int pageNumber, int p_rows, String user_id, String name, String dept_nm, String start_dt, String end_dt) throws Exception;
	public int getImUserViewTotalCntForPaging(String sys_code, String user_id, String name, String dept_nm, String start_dt, String end_dt) throws Exception;

}