package com.ty.tastManagement.Controller.model.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ty.tastManagement.Controller.model.dto.MyConfig;
import com.ty.tastManagement.Controller.model.dto.Users;

public class UserDaoTest {
	ConfigurableApplicationContext c=new AnnotationConfigApplicationContext(MyConfig.class);

	@Test
	public void testSaveUser() {
		UserDao u=(UserDao)c.getBean("userDao");
		Users users=(Users)c.getBean("users");
		users.setName("hell");
		users.setEmail("ayyappag739");
		users.setPassword("jgdut36");
		users.setPhone(97987487);
		users.setRole("active");
		users.setStatus("active");
		Users users1=u.saveUser(users);
		assertEquals(users,users1);
	}
	
	@Test
	public void testfindUsersByIdd() {
		UserDao u=(UserDao)c.getBean("userDao");
		assertTrue(u.findUsersByIdd(3));
	}

}
