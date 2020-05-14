package com.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.exception.AdminLoginNoException;
@Controller
public class BaseController {
	//管理员登录权限设置
	@ModelAttribute
	public void isLogin(HttpSession session,HttpServletRequest requests)throws AdminLoginNoException{
		if(session.getAttribute("auser")==null){
			throw new AdminLoginNoException("没有登录");
		}
		
	}
}
