package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserDao {
	public List<Map<String, Object>> userInfo();
	public void deleteBuser(Integer id);

}
