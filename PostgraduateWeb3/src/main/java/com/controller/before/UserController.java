package com.controller.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Auser;
import com.pojo.Buser;
import com.service.before.UserService;
@Controller
public class UserController {
//×¢²áÒ³ÃæµÄÌø×ª
@Autowired
	private UserService userService;
@RequestMapping("/register")
	public String register(@ModelAttribute Buser buser,
			Model model,HttpSession session,String code){
		return userService.register(buser,model,session,code);
}
@RequestMapping("/login")
public String login(@ModelAttribute Buser buser,
		Model model,HttpSession session,String code){
	return userService.login(buser,model,session,code);
}
@RequestMapping("/bexit")
public String exit(@ModelAttribute Buser buser,HttpSession session){
	session.invalidate();
	return "before/login";
}
}
