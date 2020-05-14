package com.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.admin.AdminOrderServiceImpl;
@Controller
@RequestMapping("/adminOrder") 

public class AdminOrderController {
	@Autowired
	private AdminOrderServiceImpl adminOrderService;
	@RequestMapping("/orderInfo")
	public String orderInfo(Model model) {
		return adminOrderService.orderInfo(model);
	}
	@RequestMapping("/deleteOrderManager")
	public String deleteorderManager(Integer id) {
		return adminOrderService.deleteorderManager(id);
	}

}

