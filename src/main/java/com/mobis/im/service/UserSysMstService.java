package com.mobis.im.service;

import java.util.List;
import java.util.Map;


public interface UserSysMstService {
	public List<Map<String, String>> getUserAuthListByUserId(String userId) throws Exception;
	public Map<String, List<String>> getAllAuthManager() throws Exception;
}