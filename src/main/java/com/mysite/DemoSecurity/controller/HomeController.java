package com.mysite.DemoSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.DemoSecurity.domain.User;
import com.mysite.DemoSecurity.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/")
	public String Home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String loginpage() {
		return "login";
	}
	@PostMapping("/login")
	public void login(@RequestParam("username") String username, @RequestParam("password") String password) {
		log.info(username);
		
		User member = userMapper.findByUsername(username);
		if(password.equals(member.getPassword())) {
			log.info("회원");
		}else {
			log.info("비회원");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
}
