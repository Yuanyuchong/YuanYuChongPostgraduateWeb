package com.service.before;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.AdminTypeDao;
import com.dao.IndexDao;
import com.pojo.Buser;
import com.pojo.Courses;

@Service
public class IndexServiceImpl implements IndexService {
	@Autowired
	private AdminTypeDao adminTypeDao;
	@Autowired
	private IndexDao indexDao;
	@Override
	//首页的跳转
	public String before(Model model, HttpSession session, Courses courses) {
		session.setAttribute("coursesType",adminTypeDao.selectCoursesType());
		model.addAttribute("salelist",indexDao.getSaleOrder());
		model.addAttribute("focuslist",indexDao.getFocusOrder());
		model.addAttribute("noticelist",indexDao.selectNotice());
		//由于id为基本类型int不能使用null，用name。
		if(courses.getCname()==null)
		courses.setId(0);
		 model.addAttribute("lastedlist", indexDao.getLastedCourses(courses));
		return "before/index";
	}

	@Override
	public String search(Model model, String myKey) {
		List<Courses> list=indexDao.search(myKey);
		model.addAttribute("searchlist", list);
		return "before/searchResult";
	}

	@Override
	public String toRegister(Model model) {
		model.addAttribute("rbuser", new Buser());
		return "before/register";
	}

	@Override
	public String coursesDetail(Model model, Integer id) {
		Courses courses=indexDao.selectCoursesById(id);
		model.addAttribute("courses", courses);
		return "before/coursesdetail";
	}

}
