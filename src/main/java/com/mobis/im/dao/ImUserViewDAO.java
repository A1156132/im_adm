package com.mobis.im.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobis.im.vo.ImUserViewVO;

@Repository
public class ImUserViewDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	/**
	 * 시스템 별 사용자뷰 조회
	 * 
	 * @param sys_code
	 * @return #시스템명#_IM_USER
	 * */
	public ImUserViewVO getImUserView(String sys_code) throws Exception {
		ImUserViewVO imUserViewVO = new ImUserViewVO();
		
		if(!sys_code.equals("")){
			imUserViewVO = this.sqlSession.selectOne("imUserView.get"+sys_code+"ImUser", sys_code);
		}
		
		return imUserViewVO;
	}
	
	/**
	 * 시스템 별 사용자뷰 조회
	 * 
	 * @param sys_code
	 * @return #시스템명#_IM_USER
	 * */
	public List<ImUserViewVO> getImUserViewList(String sys_code, int pageNumber, int p_rows,String user_id, String name, String dept_nm,String start_dt, String end_dt) throws Exception {
		List<ImUserViewVO> list = new ArrayList<ImUserViewVO>();
		ImUserViewVO vo = new ImUserViewVO();
		HashMap<String, Object> map = new HashMap<>();
		
		if(!sys_code.equals("")){
			vo.setPageNumber(pageNumber);
			vo.setPage_rows(p_rows);
			start_dt = start_dt.replaceAll("-", "")+"000000";
			end_dt = end_dt.replaceAll("-", "")+"999999";
						
			map.put("user_id", user_id);
			map.put("name", name);
			map.put("dept_nm", dept_nm);
			map.put("start_dt", start_dt);
			map.put("end_dt", end_dt);
			map.put("page_rows", p_rows);
			map.put("pageNumber", pageNumber);
			
			list = this.sqlSession.selectList("imUserView.get"+sys_code+"ImUser", map);
		}
		
		return list;
	}
	
	
	/**
	 * 시스템 별 사용자뷰 조회
	 * 
	 * @param sys_code
	 * @return #시스템명#_IM_USER
	 * */
	public int getImUserViewTotalCntForPaging(String sys_code, String user_id, String name, String dept_nm,String start_dt, String end_dt) throws Exception {
		int totalCnt = 0;
		HashMap<String, Object> map = new HashMap<>();

		if(!sys_code.equals("")){
			start_dt = start_dt.replaceAll("-", "")+"000000";
			end_dt = end_dt.replaceAll("-", "")+"999999";
			
			map.put("user_id", user_id);
			map.put("name", name);
			map.put("dept_nm", dept_nm);
			map.put("start_dt", start_dt);
			map.put("end_dt", end_dt);
			System.out.println("start_dt="+start_dt);
			totalCnt = this.sqlSession.selectOne("imUserView.get"+sys_code+"ImUserCnt", map);
		}
		
		return totalCnt;
	}
	
	
}