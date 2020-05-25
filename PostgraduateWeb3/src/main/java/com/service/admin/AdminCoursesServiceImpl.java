package com.service.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.AdminCoursesDao;
import com.dao.AdminTypeDao;
import com.pojo.Courses;
import com.util.MyUtil;
@Service
public class AdminCoursesServiceImpl implements AdminCoursesService{
	@Autowired
	private AdminCoursesDao adminCoursesDao;
	private AdminTypeDao adminTypeDao;
	@Override
	//addOrUpdateGoods����ʵ��
	public String addOrUpdateCourses(Courses courses, HttpServletRequest request, String updateAct) {

/*		�ϴ��ļ�����λ��"/logos",��λ����ָworkspace\.metadata\.plugins..������ʹ��.
*/				
		//��ֹ�ļ�������
		String newFileName=" ";
		String fileName=courses.getLogoImage().getOriginalFilename();
		if(fileName.length()>0){
			String realpath=request.getServletContext().getRealPath("/logos");
			System.out.println("�ϴ�����·��"+realpath);
			//ʵ���ļ��ϴ�
			//substring(1)�ӵ�һ���ַ���ʼ��ȡ
			String fileType=fileName.substring(fileName.lastIndexOf('.'));
			//��ֹ�ļ�����
			newFileName=MyUtil.getStringID()+fileType;
			courses.setCpicture(newFileName);
			File targetFile=new File(realpath,newFileName);
			
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			//�ϴ�
			try{
				courses.getLogoImage().transferTo(targetFile);
				System.out.println("�ϴ��ɹ���");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//�޸�
		if("update".equals(updateAct)){
			//updateAct������act��������Ϊʹ����ת��
			//�޸ĵ����ݿ�
			if(adminCoursesDao.updateCoursesById(courses)>0){
				System.out.println("ʹ�����ض���");
				return "forward:/adminCourses/selectCourses?act=updateSelect";
			}else{
				return "admin/updateAcourses";
			}
		
		}else{
			//���浽���ݿ�
			if(adminCoursesDao.addCourses(courses)>0){
				//ת������ѯ��controller
				System.out.println("��Ҫִ������ת����");
				return "forward:/adminCourses/selectCourses";
			}else{
				return "card/addCard";
			}
		}
	}
	@Override
	//ʵ�ַ�ҳ���ܣ�ͨ���ַ���ʵ�ֲ�ͬ���ܵĵ���
	public String selectCourses(Model model, Integer pageCur, String act) {
		List<Courses> allCourses=adminCoursesDao.selectCourses();
		int temp=allCourses.size();
		model.addAttribute("totalCount", temp);
		int totalPage=0;
		if(temp==0){
			totalPage=0;//������ҳ��
		}else{				//���ش��ڻ��ߵ���ָ�����ʽ����С����
			totalPage=(int) Math.ceil((double) temp/10);
		}
		if(pageCur==null){
			pageCur=1;
		}
		if((pageCur-1)*10>temp){
			pageCur=pageCur-1;
		}
		System.out.println("ʵ�ַ�ҳ���ܣ���������");
		//��ҳ��ѯ
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startIndex", (pageCur-1)*10);//��ʼλ��
		map.put("perPageSize", (10));
		allCourses=adminCoursesDao.selectAllCoursesByPage(map);
		model.addAttribute("allCourses", allCourses);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		//ɾ����ѯ
		if("deleteSelect".equals(act)){
			return "admin/deleteSelectCourses";
		}
		//�޸Ĳ�ѯ
		else if("updateSelect".equals(act)){
			return "admin/updateSelectCourses";
		}else{
			return "admin/selectCourses";
		}
	}
	//��ѯһ����Ʒ����
	@Override
	public String selectACourses(Model model, Integer id, String act) {
		Courses acourses=adminCoursesDao.selectCoursesById(id);
		model.addAttribute("courses", acourses);
		//�޸���Ʒ
		if("updateACourses".equals(act)){
			System.out.println("ִ����if���");
			System.out.println("ִ����if���");
			System.out.println("ִ����if���");
			System.out.println("ִ����if���");

			return "admin/updateAcourses";
		}
		//�������
		return "admin/coursesDetail";
	}
	

	//ɾ��һ����Ʒ
	@Override
	public String deleteACourses(Model model, Integer id) {
//��Ʒ��������

		adminCoursesDao.deleteACourses(id);
		model.addAttribute("msg", "�ɹ�ɾ���γ̡�");
		return "forward:/adminCourses/selectCourses?act=deleteSelect";
	}

}
