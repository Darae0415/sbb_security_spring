package com.mysite.DemoSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.DemoSecurity.domain.User;
import com.mysite.DemoSecurity.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final PasswordEncoder passwordEncoder;
	private final UserMapper userMapper;
	
	@GetMapping({"/", "/home"})
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String SingupPage() {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String signup(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(passwordEncoder.encode(password));
		user.setEnabled(true);
		
		userMapper.save(user);
		// 권한 부여 ROLE_USER
		userMapper.insertUserRole(user.getId(), 1L);
		
		return "redirect:/login";
	}
}
