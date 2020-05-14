package com.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.AdminDao;
import com.dao.AdminTypeDao;
import com.pojo.Auser;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;
	
    @Autowired 
	 private AdminTypeDao adminTypeDao;
	@Override
	public String login(Auser auser, Model model, HttpSession session) {
		if(adminDao.login(auser)!=null&&adminDao.login(auser).size()>0){
			session.setAttribute("auser", auser);
			//�����Ʒ���޸���Ʒҳ��ʹ��
			session.setAttribute("coursesType", adminTypeDao.selectCoursesType());
			return "admin/index";
		}
		model.addAttribute("msg", "�û������������");
		return "admin/login";
}
}
