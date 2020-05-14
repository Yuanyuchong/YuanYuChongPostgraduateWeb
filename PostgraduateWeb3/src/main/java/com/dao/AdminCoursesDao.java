package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.pojo.Courses;
@Repository
@Mapper
public interface AdminCoursesDao {
	public int addCourses(Courses courses);
	public int updateCoursesById(Courses courses);
	public List<Courses> selectCourses();
	//输出参数类型为Map
	public List<Courses> selectAllCoursesByPage(Map<String, Object> map);
	public Courses selectCoursesById(Integer id);
	public void deleteCourses(List<Integer> list);
	public void deleteACourses(Integer id);

}
