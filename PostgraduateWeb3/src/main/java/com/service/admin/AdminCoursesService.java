package com.service.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.pojo.Courses;

public interface AdminCoursesService {
	public String addOrUpdateCourses(Courses courses,HttpServletRequest request,String updateAct);
	public String selectCourses(Model model,Integer pageCur,String act);
	public String selectACourses(Model model,Integer id,String act);
	public String deleteACourses(Model model, Integer id);

}
