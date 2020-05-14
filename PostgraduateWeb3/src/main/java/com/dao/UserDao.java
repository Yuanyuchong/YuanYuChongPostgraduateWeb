package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pojo.Buser;
 
@Repository
public interface UserDao {
	public int register(Buser buser);
	public List<Buser> login(Buser buser);
}
