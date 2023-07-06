package com.mobis.im.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobis.im.dao.AdminUserAuthDAO;
import com.mobis.im.dao.MobisImUserDAO;
import com.mobis.im.vo.AdminUserAuthVO;


@Service("adminUserAuth")
public class AdminUserAuthImpl implements AdminUserAuthService {


	@Autowired
	AdminUserAuthDAO adminUserAuthDAO;
	
	/*
	 * @Override public AdminUserAuthVO getAdminUserAuth(AdminUserAuthVO
	 * adminUserAuthVO) throws Exception { return
	 * adminUserAuthDAO.getAdminUserAuth(adminUserAuthVO);
	 * 
	 * }
	 */

	@Override
	public List<AdminUserAuthVO> getAdminUserAuthList(AdminUserAuthVO adminUserAuthVO) throws Exception{
		return adminUserAuthDAO.getAdminUserAuthList(adminUserAuthVO);

	}
	
	@Override
	public AdminUserAuthVO getIPCheck(AdminUserAuthVO adminUserAuthVO) throws Exception{
		return adminUserAuthDAO.getIPCheck(adminUserAuthVO);

	}

}