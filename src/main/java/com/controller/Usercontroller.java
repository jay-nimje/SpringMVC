 package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.dao.userdao;
import com.model.usermodel;

@Controller
public class Usercontroller {
	@Autowired
	private userdao dao;
	
	@RequestMapping("/about")
	public String about() {
		return "about";
		
	}
	@RequestMapping("/")
	public String about2(Model m) {
		List<usermodel>list = dao.getalluser();
		m.addAttribute("list",list);
		/*requset.setAttribute("name", "my name is SpringMVC");
		requset.setAttribute("rollnum", "12");
		requset.setAttribute("active", "false");
		requset.setAttribute("per", "85.25");s
		List<String>list = new ArrayList<String>();
		list.add("c");
		list.add("c++");
		list.add("java");
		list.add("python");
		list.add("php");
		requset.setAttribute("list", list);*/
		return "index";
		
	}
	@RequestMapping("/home")
	public String home () {
		return "home";
		
	}
	@RequestMapping(value = "/adduser",method = RequestMethod.POST)	
	public  RedirectView adduser (@ModelAttribute usermodel u, HttpServletRequest request) {
		System.out.println(u);
		dao.insertuser(u);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath()+"/");
		return view;
		
	}
	@RequestMapping(value= "/update/{id}")
	public ModelAndView getUser(@PathVariable int id) {
		System.out.println("update called : "+id);
		usermodel u = dao.getuserbyid(id);
		ModelAndView view = new ModelAndView();
		view.addObject("data", u);
		view.setViewName("update");
		return view;
	}
	@RequestMapping(value= "/delete/{id}")
	public RedirectView deleteUser(@PathVariable int id,HttpServletRequest request) {
		usermodel u = dao.getuserbyid(id);
		dao.deleteuser(u);
		RedirectView view = new RedirectView();
		view.setUrl(request.getContextPath()+"/");
		return view;
	}
	
}
