package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface UserCenterDao {
	 public List<Map<String,Object>> myOrder(Integer userId);
	 public List<Map<String,Object>> myFocus(Integer userId);
	 public List<Map<String,Object>> orderDetail(Integer ordersn);
}
