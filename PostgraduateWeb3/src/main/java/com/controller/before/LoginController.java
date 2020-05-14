package com.controller.before;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Auser;

@Controller
public class LoginController {
	@RequestMapping("/toLogin")
	public String toLogin(@ModelAttribute Auser auser){
		return "before/login";
	}
}
