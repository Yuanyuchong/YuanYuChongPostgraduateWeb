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
	//�ύ����
	@Override
	public String orderSubmit(Model model,HttpSession session,Double amount) {
		Order order=new Order();
		System.out.println(amount);
		order.setAmount(amount);
		order.setBuserstable_id(MyUtil.getUserId(session));
		//���ɶ�����������������order
		orderDao.addOrder(order);
		//���ɶ�������
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("ordersn",order.getId());
		map.put("uid", MyUtil.getUserId(session));
		orderDao.addOrderDetail(map);

		orderDao.clear(MyUtil.getUserId(session));
		model.addAttribute("ordersn", order.getId());
		return "before/orderdone";
	}
	@Override
	//ȥ����
	public String pay(Integer ordersn) {
		orderDao.pay(ordersn);
		return "before/paydone";
	}

}
