package com.mysite.DemoSecurity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mysite.DemoSecurity.domain.User;
import com.mysite.DemoSecurity.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class UserTest {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Test
	@DisplayName("사용자 추가 테스트")
	void addUser() {
        // 테스트용 사용자 생성
        User user = new User();
        user.setUsername("test");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setEnabled(true);
        user.setRole("ROLE_USER");

        log.info("password: {}", user.getPassword());
        userMapper.save(user);
    }
}
