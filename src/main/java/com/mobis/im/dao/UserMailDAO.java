package com.mobis.im.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mobis.im.vo.UserSysMailHistoryVO;

@Repository("userMailDao")
public class UserMailDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<UserSysMailHistoryVO> getSendList() {
		return this.sqlSessionTemplate.selectList("userMail.getSendList");
	}
	
	public String procSendSysListMail(Map<String, String> map) {
		return this.sqlSessionTemplate.selectOne("userMail.procSendSysListMail", map);
	}

}