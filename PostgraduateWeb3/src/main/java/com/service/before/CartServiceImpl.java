package com.service.before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.dao.CartDao;
import com.util.MyUtil;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartDao cartDao;
	@Override
	//关注商品
	public String focus(Model model,Integer id,HttpSession session) {
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("uid", MyUtil.getUserId(session));
		map.put("cid",id);
		List<Map<String,Object>> list=cartDao.isFocus(map);
		if(list.size()>0) {
			model.addAttribute("msg","已关注该商品");
}	
		else {
			int n=cartDao.focus(map);
			if (n>0)
				model.addAttribute("msg","成功关注该商品");
			else
				model.addAttribute("msg", "关注失败！");
		}
		return "forward:/coursesDetail?id="+id;
	}
	//加入购物车
	@Override
	public String putCart(Model model,Integer shoppingnum,Integer id,HttpSession session) {
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("uid", MyUtil.getUserId(session));
		System.out.println(MyUtil.getUserId(session));
		map.put("cid", id);
		System.out.println(id);
		map.put("shoppingnum", shoppingnum);
		System.out.println(shoppingnum);

	List<Map<String,Object>>list=cartDao.isPutCart(map);
	if(list.size()>0)
		cartDao.updateCart(map);
	else
		cartDao.putCart(map);
	return "forward:/selectCart";
	}
	//查看购物车
	@Override
	public String selectCart(Model model,HttpSession session) {
		List<Map<String,Object>>list=cartDao.selectCart(MyUtil.getUserId(session));
		double sum=0;
		for(Map<String,Object>map:list) {
			sum=sum+(Double)map.get("smallsum");
		}//循环遍历计算花费总和
			model.addAttribute("total",sum);
			model.addAttribute("cartlist",list);		
		return "before/cart";
	}	
	//删除购物车
	@Override
	public String deleteAcourses(Integer id, HttpSession session) {
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("uid",MyUtil.getUserId(session));
		map.put("cid", id);
		cartDao.deleteAcourses(map);
		return"forward:/selectCart";
	}
	//清空购物车
	@Override
	public String clear(HttpSession session) {
		cartDao.clear(MyUtil.getUserId(session));
		return "forward:/selectCart";
	}
	//去结算
	@Override
    public String orderConfirm(Model model,HttpSession session) {
    	List<Map<String,Object>> list=cartDao.selectCart(MyUtil.getUserId(session));
    	double sum=0;
    	for(Map<String,Object>map:list) {
    		sum=sum+(Double)map.get("smallsum");
    	}
    	model.addAttribute("total",sum);
    	model.addAttribute("cartlist", list);
    	return "before/orderconfirm";
    }
}
