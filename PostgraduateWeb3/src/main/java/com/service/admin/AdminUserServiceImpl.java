package com.service.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.AdminUserDao;

@Service
public class AdminUserServiceImpl implements AdminUserService{
	@Autowired
	private AdminUserDao adminUserDao;
	@Override
	public String userInfo(Model model) {
		List<Map<String,Object>>list=adminUserDao.userInfo();
		model.addAttribute("userList",list);
		return"admin/userManager";
	}
	@Override
	public String deleteuserManager(Integer id) {
		
	adminUserDao.deleteBuser(id);
	
	return "forward:/adminUser/userInfo";
}
}
