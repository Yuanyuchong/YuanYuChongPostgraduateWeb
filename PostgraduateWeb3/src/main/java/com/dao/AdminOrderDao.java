package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminOrderDao {
	public List<Map<String, Object>> orderInfo();
	public void deleteOrderDetail(Integer id);
	public void deleteOrderBase(Integer id);
}
