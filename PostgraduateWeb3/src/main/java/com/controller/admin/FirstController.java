package com.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.Auser;

@Controller
public class FirstController {
	@RequestMapping("/first")
	public String first(Auser auser){
		return "admin/login";
	}
}


