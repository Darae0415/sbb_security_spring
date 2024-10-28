package com.mysite.DemoSecurity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mysite.DemoSecurity.domain.User;

@Mapper
public interface UserMapper {
	void save(User user);

	User findByUsername(String username);

	void insertUserRole(@Param("userId") Long userId, @Param("roleId") Long roleId);

	List<User> findAll();
	
	
}
