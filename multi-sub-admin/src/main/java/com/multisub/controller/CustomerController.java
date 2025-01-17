package com.multisub.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multisub.biz.UsersBiz;
import com.multisub.vo.UsersVO;
 

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	UsersBiz biz;
	
	@RequestMapping("/add")
	public String add(Model m) {
		m.addAttribute("center","customer/add");
		return "main";
	}
	
	@RequestMapping("addimpl")
	public String addimpl(Model m, UsersVO uvo) {
		try {
			uvo.setUserTypeId(200); //회원
			biz.register(uvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail?id="+uvo.getId();		
	}
	
	@RequestMapping("/list")
	public String select(Model m) {
		List<UsersVO> ulist = null;
		try {
			ulist = biz.getCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.addAttribute("ulist", ulist);
		m.addAttribute("center","customer/list");
		return "main";
	}
	
	@RequestMapping("/detail")
	public String detail(Model m, String id) {
		UsersVO uvo = null;		
		try {
			uvo = biz.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		m.addAttribute("uvo", uvo);
		m.addAttribute("center","customer/detail");
		return "main";
	}		
	
	@RequestMapping("/delete")
	public String delete(Model m, UsersVO uvo) {
		String id = uvo.getId();
		try {
			biz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//m.addAttribute("center","customer/list");
		//return "main";
		return "redirect:list";
	}	
	
	@RequestMapping("update")
	public String update(Model m, UsersVO uvo) {
		try {
			biz.modify(uvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:detail?id="+uvo.getId();
	}
	
	
 
}
