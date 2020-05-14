package com.service.before;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.UserCenterDao;
import com.util.MyUtil;
@Service
public class UserCenterServiceImpl implements UserCenterService {
@Autowired
	private UserCenterDao userCenterDao;
    @Override
    public String userCenter(HttpSession session,Model model) {
    	model.addAttribute("myOrder", userCenterDao.myOrder(MyUtil.getUserId(session)));
    	model.addAttribute("myFocus", userCenterDao.myFocus(MyUtil.getUserId(session)));
    	return"before/userCenter";
    }
    @Override
    public String orderDetail(Model model,Integer ordersn) {
    	System.out.println(userCenterDao.orderDetail(ordersn));
    	model.addAttribute("myOrderDetail", userCenterDao.orderDetail(ordersn));
    	return"before/userOrderDetail";
    }
}
