package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.pojo.Buser;

public class MyUtil {
	//���ʱ���ַ���
	public static String getStringID(){
		String id=null;
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		id=sdf.format(date);
		return id;
	}
	//��õ�¼�û�id
	public static Integer getUserId(HttpSession session){
		Buser ruser=(Buser)session.getAttribute("bruser");
		return ruser.getId();
	}
}