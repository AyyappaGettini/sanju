package com.ty.tastManagement.Controller.model.dto;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ty.tastManagement.Controller.model.dao.UserDao;

@Configuration
@ComponentScan(basePackages = "com.ty.tastManagement.Controller")
public class MyConfig {
	
	
	@Bean
	public ConfigurableApplicationContext getConfig() {
		return UserDao.c;
	}
	
	@Bean
	public EntityManagerFactory getEmf() {
		return Persistence.createEntityManagerFactory("vikas");
	}
	
	@Bean
	public EntityManager getEm() {
		return getEmf().createEntityManager();
	}
	
	@Bean
	public EntityTransaction getEt() {
		return getEm().getTransaction();
	}
	
	@Bean
	public Scanner getScan() {
		return new Scanner(System.in);
	}
}
