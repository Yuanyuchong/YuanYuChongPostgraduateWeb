package com.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.admin.AdminTypeService;
@Controller
@RequestMapping("/adminType")
public class AdminTypeController {
	@Autowired
	private AdminTypeService adminTypeService;
	//到添加类型页面
	@RequestMapping("/toAddType")
	public String toAddType(Model model) {
		return adminTypeService.toAddType(model);
	}
	//添加类型
	@RequestMapping("/addType")
	public String addType(String typename, Model model, HttpSession session) {
		return adminTypeService.addType(typename, model, session);
	}
//到删除类型页面
	@RequestMapping("/toDeleteType")
	public String toDeleteType(Model model) {
		return adminTypeService.toDeleteType(model);
	}
	@RequestMapping("/deleteType") 
	public String deleteType(Integer id,Model model) { 
		return adminTypeService.deleteType(id,model); 
	}
}
