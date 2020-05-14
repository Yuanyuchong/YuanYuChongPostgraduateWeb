package com.pojo;

import java.io.Serializable;

public class CoursesType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int id;
	private String typename;
	
	
	public CoursesType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoursesType(int id, String typename) {
		super();
		this.id = id;
		this.typename = typename;
	}
	@Override
	public String toString() {
		return "CoursesType [id=" + id + ", typename=" + typename + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}

	
	

	

}