package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pojo.Order;
@Repository
public interface OrderDao {
	public void addOrder(Order order);
	public void addOrderDetail(Map<String, Object> map);
	public List<Map<String, Object>> selectGoodsShop(Integer userId);
	public  int updateStore(Map<String, Object> map);
	public void clear(Integer userId);
	public void pay(Integer ordersn);
}
