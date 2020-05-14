package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.Auser;

@Repository
public interface AdminDao {
	public List<Auser> login(Auser auser);
}
