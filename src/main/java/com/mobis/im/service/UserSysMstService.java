package com.mobis.im.service;

import java.util.List;
import java.util.Map;

import com.mobis.im.vo.AdminUserAuthVO;


public interface UserSysMstService {
	public List<Map<String, String>> getUserAuthListByUserId(String userId) throws Exception;
	public Map<String, Map<String, String>> getAllAuthManager() throws Exception;
}