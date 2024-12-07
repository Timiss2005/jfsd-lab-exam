package com.desidiaries.sdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.desidiaries.sdp.model.Admin;
import com.desidiaries.sdp.model.User;
import com.desidiaries.sdp.services.AdminService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	@GetMapping("adminlogin")
	public ModelAndView adminlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminlogin");
		return mv;
	}
	@GetMapping("adminhome")
	public ModelAndView adminhome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		return mv;
	}
	@PostMapping("checkadminlogin")
	public ModelAndView checkadminlogin(HttpServletRequest request) {
		
		ModelAndView mv=new ModelAndView();
		
		String auname=request.getParameter("auname");
		String apwd=request.getParameter("apwd");
		
		Admin admin=adminservice.checkAdminLogin(auname,apwd);
		if(admin!=null) {
			mv.setViewName("adminhome");
		}else {
			mv.setViewName("adminloginfail");
			mv.addObject("message","Admin Login Failed");
		}
		return mv;
	}

@GetMapping("viewallusers")
public ModelAndView viewallusers() {
    ModelAndView mv = new ModelAndView();
    List<User> users = adminservice.viewAllUsers();
    mv.addObject("userlist", users); // Corrected syntax here
    mv.setViewName("viewallusers");
    return mv;
}
}




