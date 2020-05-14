package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.pojo.Courses;

public interface IndexService {
	public String before(Model model,HttpSession session,Courses courses);
	public String search(Model model,String myKey);
	public String toRegister(Model model);
	public String coursesDetail(Model model,Integer id); 


}
