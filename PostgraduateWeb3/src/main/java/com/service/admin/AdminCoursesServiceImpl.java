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
	//addOrUpdateGoods方法实现
	public String addOrUpdateCourses(Courses courses, HttpServletRequest request, String updateAct) {

/*		上传文件保存位置"/logos",该位置是指workspace\.metadata\.plugins..发布后使用.
*/				
		//防止文件名重名
		String newFileName=" ";
		String fileName=courses.getLogoImage().getOriginalFilename();
		if(fileName.length()>0){
			String realpath=request.getServletContext().getRealPath("/logos");
			System.out.println("上传到该路径"+realpath);
			//实现文件上传
			//substring(1)从第一个字符开始读取
			String fileType=fileName.substring(fileName.lastIndexOf('.'));
			//防止文件重名
			newFileName=MyUtil.getStringID()+fileType;
			courses.setCpicture(newFileName);
			File targetFile=new File(realpath,newFileName);
			
			if(!targetFile.exists()){
				targetFile.mkdirs();
			}
			//上传
			try{
				courses.getLogoImage().transferTo(targetFile);
				System.out.println("上传成功！");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//修改
		if("update".equals(updateAct)){
			//updateAct不能与act重名，因为使用了转发
			//修改到数据库
			if(adminCoursesDao.updateCoursesById(courses)>0){
				System.out.println("使用了重定向！");
				return "forward:/adminCourses/selectCourses?act=updateSelect";
			}else{
				return "admin/updateAcourses";
			}
		
		}else{
			//保存到数据库
			if(adminCoursesDao.addCourses(courses)>0){
				//转发到查询的controller
				System.out.println("将要执行请求转发。");
				return "forward:/adminCourses/selectCourses";
			}else{
				return "card/addCard";
			}
		}
	}
	@Override
	//实现分页功能，通过字符串实现不同功能的调用
	public String selectCourses(Model model, Integer pageCur, String act) {
		List<Courses> allCourses=adminCoursesDao.selectCourses();
		int temp=allCourses.size();
		model.addAttribute("totalCount", temp);
		int totalPage=0;
		if(temp==0){
			totalPage=0;//设置总页数
		}else{				//返回大于或者等于指定表达式的最小整数
			totalPage=(int) Math.ceil((double) temp/10);
		}
		if(pageCur==null){
			pageCur=1;
		}
		if((pageCur-1)*10>temp){
			pageCur=pageCur-1;
		}
		System.out.println("实现分页功能！！！！！");
		//分页查询
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("startIndex", (pageCur-1)*10);//起始位置
		map.put("perPageSize", (10));
		allCourses=adminCoursesDao.selectAllCoursesByPage(map);
		model.addAttribute("allCourses", allCourses);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageCur", pageCur);
		//删除查询
		if("deleteSelect".equals(act)){
			return "admin/deleteSelectCourses";
		}
		//修改查询
		else if("updateSelect".equals(act)){
			return "admin/updateSelectCourses";
		}else{
			return "admin/selectCourses";
		}
	}
	//查询一个商品详情
	@Override
	public String selectACourses(Model model, Integer id, String act) {
		Courses acourses=adminCoursesDao.selectCoursesById(id);
		model.addAttribute("courses", acourses);
		//修改商品
		if("updateACourses".equals(act)){
			System.out.println("执行了if语句");
			System.out.println("执行了if语句");
			System.out.println("执行了if语句");
			System.out.println("执行了if语句");

			return "admin/updateAcourses";
		}
		//详情界面
		return "admin/coursesDetail";
	}
	

	//删除一个商品
	@Override
	public String deleteACourses(Model model, Integer id) {
//商品关联部分

		adminCoursesDao.deleteACourses(id);
		model.addAttribute("msg", "成功删除课程。");
		return "forward:/adminCourses/selectCourses?act=deleteSelect";
	}

}
