package com.mysite.DemoSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.DemoSecurity.domain.Role;
import com.mysite.DemoSecurity.domain.User;
import com.mysite.DemoSecurity.mapper.UserMapper;

import org.springframework.ui.Model;
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
	
	@GetMapping("/users")
	public String userList(Model model) {
		List<User> users = userMapper.findAll();
		model.addAttribute("users", users);
		return "user-list";
	}
	
	// 사용자의 권한 목록 조회
    @GetMapping("/user/{userId}/roles")
    public String userRoles(@PathVariable("userId") Long userId, Model model) {
        List<Role> roles = userMapper.findRolesByUserId(userId);
        String username = userMapper.findById(userId).getUsername();
        List<Role> allRoles = userMapper.getAllRoles();
        
        model.addAttribute("allRoles", allRoles);
        model.addAttribute("roles", roles);
        model.addAttribute("username", username);
        model.addAttribute("userId", userId);

        return "user-roles";
    }
    
    @PostMapping("/user/{userId}/role/add")
    public String addRole(@PathVariable("userId") Long userId, @RequestParam("roleId") Long roleId) {
        userMapper.insertUserRole(userId, roleId);
        return "redirect:/user/%d/roles".formatted(userId);
    }
}
