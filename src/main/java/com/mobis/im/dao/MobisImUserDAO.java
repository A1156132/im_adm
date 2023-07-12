package com.mobis.im.dao;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobis.im.vo.MobisImUserVO;

@Repository("mobisImUserDao")
public class MobisImUserDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// 사용자 정보 조회
	public MobisImUserVO getUserInfo(MobisImUserVO mobisImUserVO) {
		return this.sqlSessionTemplate.selectOne("user.getUserInfom", mobisImUserVO);

	}
	
}