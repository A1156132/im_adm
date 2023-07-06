package com.mobis.im.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobis.im.vo.AdminUserAuthVO;

@Repository
public class AdminUserAuthDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;

	
	/*
	 * public AdminUserAuthVO getAdminUserAuth(AdminUserAuthVO AdminUserAuthVO)
	 * throws Exception{ return this.sqlSession.selectOne("adminUserAuth.getUser",
	 * AdminUserAuthVO); }
	 */

	public List<AdminUserAuthVO> getAdminUserAuthList(AdminUserAuthVO AdminUserAuthVO) throws Exception {
		System.out.println("시스템목록조회");
		return this.sqlSession.selectList("adminUserAuth.getUserList", AdminUserAuthVO);
	}
	
	public AdminUserAuthVO getIPCheck(AdminUserAuthVO AdminUserAuthVO) throws Exception {
		return this.sqlSession.selectOne("adminUserAuth.getIPCheck", AdminUserAuthVO);
	}
	
}