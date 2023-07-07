package com.mobis.im.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobis.im.vo.MobisImUserVO;
import com.mobis.im.vo.UserSysMstVO;

@Repository("mobisImUserDao")
public class MobisImUserDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<Map<String, String>> getUserAuthListByUserId(String userId) throws Exception {
		return this.sqlSessionTemplate.selectList("userSys.getUserAuthListByUserId", userId);
	}
	
	public List<Map<String, String>> getAllAuthManager() throws Exception {
		return this.sqlSessionTemplate.selectList("userSys.getAllAuthManager");
	}
	
	// 사용자 정보 조회
	public MobisImUserVO getUserInfo(MobisImUserVO mobisImUserVO) {
		return this.sqlSessionTemplate.selectOne("user.getUserInfom", mobisImUserVO);

	}
	
}