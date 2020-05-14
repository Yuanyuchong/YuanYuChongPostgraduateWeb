package com.service.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.AdminTypeDao;
import com.pojo.CoursesType;

@Service
public class AdminTypeServiceImpl implements AdminTypeService {
	@Autowired
	private AdminTypeDao adminTypeDao;
//�������
	@Override
	public String toAddType(Model model) {
		List<CoursesType> list=adminTypeDao.selectCoursesType();
		System.out.println(list);
		model.addAttribute("allTypes",list);
		//ҳ����ת
		return "admin/addType";
	}
	@Override
	public String addType(String typename, Model model, HttpSession session) {
		adminTypeDao.addType(typename);
		//�����Ʒ���޸���Ʒҳ��ʹ��
		System.out.println("��CoursesType��session��֮ǰ");
		/*
		 * session.setAttribute("CoursesType", adminTypeDao.selectCoursesType());
		 */		System.out.println("��CoursesType��session��֮��");
		//�ض���toAddType����
		return "forward:/adminType/toAddType";
	}
//����ɾ��
	public String toDeleteType(Model model) {
	 model.addAttribute("allTypes",adminTypeDao.selectCoursesType());
	 System.out.println("Ԭ���111");
	 	return "admin/deleteType";
	}
	public String deleteType(Integer id,Model model){ 
		 if(adminTypeDao.selectCoursesByType(id).size()>0) {
			 model.addAttribute("msg", "�����й�����������ɾ��"); 
			 return "forward:/adminType/toDeleteType"; }
		 if(adminTypeDao.deleteType(id)>0)
			 model.addAttribute("msg", "���ͳɹ�ɾ��");
		 	return "forward:/adminType/toDeleteType"; 
	 }
	
}
