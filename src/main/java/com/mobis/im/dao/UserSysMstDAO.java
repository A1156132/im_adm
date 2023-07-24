package com.mobis.im.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobis.im.vo.AdminUserAuthVO;

@Repository("userSysMstDao")
public class UserSysMstDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<Map<String, String>> getUserAuthListByUserId(String userId) throws Exception {
		return this.sqlSessionTemplate.selectList("userSysMst.getUserAuthListByUserId", userId);
	}
	
	public List<AdminUserAuthVO> getAllAuthManager() throws Exception {
		return this.sqlSessionTemplate.selectList("userSysMst.getAllAuthManager");
	}

}
