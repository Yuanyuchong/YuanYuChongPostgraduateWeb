package com.service.before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.OrderDao;
import com.pojo.Order;
import com.util.MyUtil;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
    private OrderDao orderDao;
	//提交订单
	@Override
	public String orderSubmit(Model model,HttpSession session,Double amount) {
		Order order=new Order();
		System.out.println(amount);
		order.setAmount(amount);
		order.setBuserstable_id(MyUtil.getUserId(session));
		//生成订单，并将主键返回order
		orderDao.addOrder(order);
		//生成订单详情
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("ordersn",order.getId());
		map.put("uid", MyUtil.getUserId(session));
		orderDao.addOrderDetail(map);

		orderDao.clear(MyUtil.getUserId(session));
		model.addAttribute("ordersn", order.getId());
		return "before/orderdone";
	}
	@Override
	//去结算
	public String pay(Integer ordersn) {
		orderDao.pay(ordersn);
		return "before/paydone";
	}

}
