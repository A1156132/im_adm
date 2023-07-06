package com.mobis.im.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobis.im.dao.ImUserViewDAO;
import com.mobis.im.vo.ImUserViewVO;


@Service("imUserView")
public class ImUserViewImpl implements ImUserViewService {

	@Autowired
	ImUserViewDAO imUserViewDAO;
	
	@Override
	public ImUserViewVO getImUserView(String sys_code) throws Exception{
		return imUserViewDAO.getImUserView(sys_code);

	}
	
	@Override
	public List<ImUserViewVO> getImUserViewList(String sys_code, int p_no, int p_rows,String user_id, String name, String dept_nm,String start_dt, String end_dt) throws Exception{
		return imUserViewDAO.getImUserViewList(sys_code,  p_no,  p_rows,  user_id,  name,  dept_nm,start_dt,  end_dt);

	}

	
	@Override
	public int getImUserViewTotalCntForPaging(String sys_code,String user_id, String name, String dept_nm,String start_dt, String end_dt) throws Exception {

		return imUserViewDAO.getImUserViewTotalCntForPaging(sys_code, user_id,  name,  dept_nm , start_dt,  end_dt);

	}

}