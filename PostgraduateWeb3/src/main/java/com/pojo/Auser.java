package com.pojo;

public class Auser {
	private String aname;
	private String apwd;
	public Auser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Auser(String aname, String apwd) {
		super();
		this.aname = aname;
		this.apwd = apwd;
	}
	@Override
	public String toString() {
		return "Auser [aname=" + aname + ", apwd=" + apwd + "]";
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
}
