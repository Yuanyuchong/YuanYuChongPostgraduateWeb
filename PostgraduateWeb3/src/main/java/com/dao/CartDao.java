package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface CartDao {
	//=======================================商品关注
	public  List<Map<String, Object>> isFocus(Map<String, Object> map);
	public  int focus(Map<String, Object> map);
	//=======================================购物车
	public  List<Map<String, Object>> isPutCart(Map<String, Object> map);
	public  int putCart(Map<String, Object> map);
	public  int updateCart(Map<String, Object> map);
	public  List<Map<String, Object>> selectCart(Integer userId);
	public  void deleteAcourses(Map<String, Object> map);
	public  void clear(Integer userId);
}
