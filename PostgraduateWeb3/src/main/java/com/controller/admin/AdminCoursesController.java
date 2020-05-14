package com.controller.admin;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Courses;
import com.service.admin.AdminCoursesService;
@Controller
@RequestMapping("/adminCourses") 
public class AdminCoursesController {
	@Autowired
	private AdminCoursesService adminCoursesService;
	//跳到addGoods页面
	@RequestMapping("/toAddCourses") 
	public String toaddCourses(@ModelAttribute Courses courses,  Model model){
		model.addAttribute("Courses", new Courses());
		return "admin/addCourses";
	}
	//添加商品
	@RequestMapping("/addCourses") 
	public String addCourses(@ModelAttribute Courses courses,
			HttpServletRequest request,String updateAct){
		return adminCoursesService.addOrUpdateCourses(courses,request,updateAct);
	}
	//查询页面
	@RequestMapping("/selectCourses") 
	public String toselectCourses(Model model,Integer pageCur,String act){
		return adminCoursesService.selectCourses(model, pageCur, act);
	}
	@RequestMapping("/selectACourses") 
	public String toselectACourses(Model model,Integer id,String act){
		return adminCoursesService.selectACourses(model, id, act);
	}

	@RequestMapping("/deleteACourses") 
	public String todeleteACourses(Integer id,Model model){
		return adminCoursesService.deleteACourses(model, id);
	}
	
}
