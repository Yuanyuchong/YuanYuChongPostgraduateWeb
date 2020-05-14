package com.service.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminNoticeDao;
import com.pojo.Notice;
@Service("adminNoticeService")
@Transactional
public class AdminNoticeServiceImpl implements AdminNoticeService {
	@Autowired
	private AdminNoticeDao adminNoticeDao;
	
	public String addNotice(Notice notice) {
		adminNoticeDao.addNotice(notice);
		return "forward:/adminNotice/deleteNoticeSelect";
	}

	
	public String deleteNoticeSelect(Model model) {
		model.addAttribute("allNotices", adminNoticeDao.deleteNoticeSelect());
		return "admin/deleteNoticeSelect";
	}

	public String selectANotice(Model model, Integer id) {
		model.addAttribute("notice", adminNoticeDao.selectANotice(id));
		return "admin/noticeDetail";
	}

	
	public String deleteNotice(Integer id) {
		adminNoticeDao.deleteNotice(id);
		return "forward:/adminNotice/deleteNoticeSelect";
	}
	public String selectNotice(Model model) {
		List<Notice> allNotice = adminNoticeDao.selectNotice();
		model.addAttribute("allNotices",allNotice);
		return "admin/selectNotice";
	}
}
