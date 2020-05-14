package com.controller.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Courses;
import com.service.before.IndexService;

@Controller
public class IndexController {
	//Ê×Ò³
	@Autowired
	private IndexService indexService;
	@RequestMapping("/before")
	public String before(Model model,HttpSession session,Courses courses){
		return indexService.before(model,session,courses);
	}
	//Ê×Ò³ËÑË÷
	@RequestMapping("/search")
	public String search(Model model,String myKey){
		return indexService.search(model,myKey);
	}
	//È¥×¢²á
	@RequestMapping("/toRegister")
	public String toRegister(Model model){
		return indexService.toRegister(model);
		}
	//Ìøµ½ÏêÇéÒ³
	@RequestMapping("/coursesDetail")
	public String coursesDetail(Model model,Integer id){
		return indexService.coursesDetail(model,id);
		
	}
}
