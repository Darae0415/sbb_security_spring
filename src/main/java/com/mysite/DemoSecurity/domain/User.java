package com.mysite.DemoSecurity.domain;

import lombok.Data;

@Data
//	Data : Getter, Setter, ToString, EqualsAndHashCode, RequiredArgsConstructor:final, NonNull를 포함하고 있음
//	@Getter: 모든 필드에 대한 getter 메서드를 생성
//	@Setter: 모든 필드에 대한 setter 메서드를 생성
//	@ToString: 객체의 문자열 표현을 생성
//	@EqualsAndHashCode: 객체의 동등성(equality) 및 해시코드(hashCode) 메서드를 생성
//	@RequiredArgsConstructor: final 또는 @NonNull이 붙은 필드만을 매개변수로 받는 생성자를 생성
public class User {
	private Long id;
	private String username;
	private String password;
	private boolean enabled;
	private String role;

}
