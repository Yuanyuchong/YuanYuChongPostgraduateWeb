package com.pojo;

public class Buser {
	private int id;
	private String bemail;
	private String bpwd;
	
	public Buser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Buser(int id, String bemail, String bpwd) {
		super();
		this.id = id;
		this.bemail = bemail;
		this.bpwd = bpwd;
	}
	@Override
	public String toString() {
		return "Buser [id=" + id + ", bemail=" + bemail + ", bpwd=" + bpwd + ", getId()=" + getId() + ", getBemail()="
				+ getBemail() + ", getBpwd()=" + getBpwd() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBemail() {
		return bemail;
	}
	public void setBemail(String bemail) {
		this.bemail = bemail;
	}
	public String getBpwd() {
		return bpwd;
	}
	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}
	
}
