package com.admin.test;

import com.admin.test.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurityJwtApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void test1() {
//		List<User> expected = userRepository.findUserAge(23);
////		List<User> actual =
////		Assert.assertEquals();
//
//
//	}

}
