package com.pojo;

import org.springframework.web.multipart.MultipartFile;

public class Courses {
	private int id;
	private String cname;
	private double coprice;
	private double crprice;
	private MultipartFile logoImage;
	private String cpicture;
	private String typename;
	private int coursestype_id;

	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Courses(int id, String cname, double coprice, double crprice,  MultipartFile logoImage,
			String cpicture, String typename, int coursestype_id) {
		super();
		this.id = id;
		this.cname = cname;
		this.coprice = coprice;
		this.crprice = crprice;
		this.logoImage = logoImage;
		this.cpicture = cpicture;
		this.typename = typename;
		this.coursestype_id = coursestype_id;
	}



	@Override
	public String toString() {
		return "Courses [id=" + id + ", cname=" + cname + ", coprice=" + coprice + ", crprice=" + crprice
				+ ", logoImage=" + logoImage + ", cpicture=" + cpicture + ", typename=" + typename + ", coursestype_id="
				+ coursestype_id + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getCoprice() {
		return coprice;
	}

	public void setCoprice(double coprice) {
		this.coprice = coprice;
	}

	public double getCrprice() {
		return crprice;
	}

	public void setCrprice(double crprice) {
		this.crprice = crprice;
	}


	public MultipartFile getLogoImage() {
		return logoImage;
	}

	public void setLogoImage(MultipartFile logoImage) {
		this.logoImage = logoImage;
	}

	public String getCpicture() {
		return cpicture;
	}

	public void setCpicture(String cpicture) {
		this.cpicture = cpicture;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getCoursestype_id() {
		return coursestype_id;
	}

	public void setCoursestype_id(int coursestype_id) {
		this.coursestype_id = coursestype_id;
	}
	
	
}