package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.Courses;
import com.pojo.CoursesType;
@Repository
public interface AdminTypeDao {
	public List<CoursesType> selectCoursesType();
	public int addType(String typename);
    public int deleteType(Integer id);
	public List<Courses> selectCoursesByType(Integer id);

 }
