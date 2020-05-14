package com.service.before;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.UserDao;
import com.pojo.Buser;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public String register(Buser buser, Model model, HttpSession session, String code) {
		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())){
			model.addAttribute("codeError", "验证码错误！");
			return "before/register";
		}
		int n=userDao.register(buser);
		if(n>0){
			return "before/login";
		}else{
			model.addAttribute("msg", "注册失败！");
			return "before/register";
		}
	}
	@Override
	public String login(Buser buser, Model model, HttpSession session, String code) {
		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())){
			model.addAttribute("codeError", "验证码错误！");
		return "before/login";
	}
		Buser ruser=null;
		List<Buser> list=userDao.login(buser);
		if(list.size()>0){
			ruser=list.get(0);
			//list.get(0)得到第一个元素
		};
		if(ruser!=null){
			session.setAttribute("bruser", ruser);
			return "forward:/before";
		}else{
			model.addAttribute("msg", "用户或者密码错误!");
			return "before/login";
		}
	}
}