package com.mysite.DemoSecurity.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mysite.DemoSecurity.domain.User;

@Mapper
public interface UserMapper {
	void save(User user);
	
	
}
