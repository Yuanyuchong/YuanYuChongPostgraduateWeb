package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
@Repository
public interface CartDao {
	//=======================================��Ʒ��ע
	public  List<Map<String, Object>> isFocus(Map<String, Object> map);
	public  int focus(Map<String, Object> map);
	//=======================================���ﳵ
	public  List<Map<String, Object>> isPutCart(Map<String, Object> map);
	public  int putCart(Map<String, Object> map);
	public  int updateCart(Map<String, Object> map);
	public  List<Map<String, Object>> selectCart(Integer userId);
	public  void deleteAcourses(Map<String, Object> map);
	public  void clear(Integer userId);
}
