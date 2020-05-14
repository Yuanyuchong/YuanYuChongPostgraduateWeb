package com.service.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.AdminTypeDao;
import com.pojo.CoursesType;

@Service
public class AdminTypeServiceImpl implements AdminTypeService {
	@Autowired
	private AdminTypeDao adminTypeDao;
//类型添加
	@Override
	public String toAddType(Model model) {
		List<CoursesType> list=adminTypeDao.selectCoursesType();
		System.out.println(list);
		model.addAttribute("allTypes",list);
		//页面跳转
		return "admin/addType";
	}
	@Override
	public String addType(String typename, Model model, HttpSession session) {
		adminTypeDao.addType(typename);
		//添加商品与修改商品页面使用
		System.out.println("存CoursesType到session域之前");
		/*
		 * session.setAttribute("CoursesType", adminTypeDao.selectCoursesType());
		 */		System.out.println("存CoursesType到session域之后");
		//重定向到toAddType方法
		return "forward:/adminType/toAddType";
	}
//类型删除
	public String toDeleteType(Model model) {
	 model.addAttribute("allTypes",adminTypeDao.selectCoursesType());
	 System.out.println("袁雨宠111");
	 	return "admin/deleteType";
	}
	public String deleteType(Integer id,Model model){ 
		 if(adminTypeDao.selectCoursesByType(id).size()>0) {
			 model.addAttribute("msg", "类型有关联，不允许删除"); 
			 return "forward:/adminType/toDeleteType"; }
		 if(adminTypeDao.deleteType(id)>0)
			 model.addAttribute("msg", "类型成功删除");
		 	return "forward:/adminType/toDeleteType"; 
	 }
	
}
