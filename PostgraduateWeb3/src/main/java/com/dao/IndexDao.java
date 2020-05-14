package com.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pojo.Courses;
import com.pojo.Notice;

@Repository
public interface IndexDao {

	public List<Map<String, Object>> getSaleOrder();
	public List<Map<String, Object>> getFocusOrder();
	public List<Notice> selectNotice();
	public List<Courses> getLastedCourses(Courses courses);
	public List<Courses> search(String myKey);
	public Courses selectCoursesById(Integer id);

}
