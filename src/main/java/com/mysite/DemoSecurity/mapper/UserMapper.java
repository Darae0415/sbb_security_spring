package com.mysite.DemoSecurity.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mysite.DemoSecurity.domain.User;

@Mapper
public interface UserMapper {
	void save(User user);

	User findByUsername(String username);

	void insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);
	
	
}
