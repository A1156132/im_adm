package com.mobis.im.service;

import java.util.List;

import com.mobis.im.vo.AdminUserAuthVO;

public interface AdminUserAuthService {
	/*
	 * public AdminUserAuthVO getAdminUserAuth(AdminUserAuthVO adminUserAuthVO)
	 * throws Exception;
	 */	
	public List<AdminUserAuthVO> getAdminUserAuthList(AdminUserAuthVO adminUserAuthVO) throws Exception;
	public AdminUserAuthVO getIPCheck(AdminUserAuthVO adminUserAuthVO) throws Exception;

}