package com.ty.tastManagement.Controller.model.dao;

import java.util.Collection;


import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.ty.tastManagement.Controller.model.dto.MyConfig;
import com.ty.tastManagement.Controller.model.dto.Task;
import com.ty.tastManagement.Controller.model.dto.Users;


@Component
public class UserDao {
	
	
	
	@Autowired
	EntityManagerFactory emf;
	@Autowired
	EntityManager em;
	@Autowired
	EntityTransaction et;
	
	public static ConfigurableApplicationContext c=new AnnotationConfigApplicationContext(MyConfig.class);
	
	@Autowired
	public Scanner sc;
	
	public Users saveUser(Users s) {
		if(s.)
		et.begin();
		em.persist(s);
		et.commit();
		System.out.println("user added....!");
		return s;
	}
	
	public void updateUsers() {
		System.out.println("Enter user id to update");
		Users u=em.find(Users.class,sc.nextInt());
		
		if(u!=null) {
			
			System.out.println("enter user name");
			sc.nextLine();
			u.setName(sc.nextLine());
			System.out.println("enter user email");
			u.setEmail(sc.nextLine());
			System.out.println("enter user password");
			u.setPassword(sc.nextLine());
			System.out.println("enter user status");
			u.setStatus(sc.nextLine());
			System.out.println("enter user phone number");
			u.setPhone(sc.nextLong());
			
			et.begin();
			em.merge(u);
			et.commit();
			System.out.println("Users updated...!");
		}
		else {
			System.out.println("Users is not present...!");
		}
	}
	
	public void deleteUsers() {
		System.out.println("enter user id to delete");
		Users u=em.find(Users.class,sc.nextInt());
		if(u!=null) {
			List<Task> tasks=u.getTasks();
			for(Task t:tasks) {
				if(t.getUser().getId()==u.getId()) {
					t.setUser(null);
					et.begin();
					em.merge(t);
					et.commit();
				}
			}
			et.begin();
			em.merge(u);
			em.remove(u);
			et.commit();
			System.out.println("user is deleted...!");
		}
		else {
			System.out.println("user is not deleted...!");
		}
	}
	
	public boolean findUsersByIdd(int userId) {
		Users u=em.find(Users.class, userId);
		if(u!=null) {
			return true;
		}
		return false;
	}
	
	public List<Task> findUsersById(int userId) {
		Users u=em.find(Users.class, userId);
		if(u!=null) {
			System.out.println("******************************");
			System.out.println("userId:"+u.getId()+",\nUserName:"+u.getName()+",\nUserEmail:"+u.getEmail()+",\nUserPassword:"+u.getPassword()+",\nUserPhone:"+u.getPhone()+",\nUserRole"+u.getRole()+",\nUserStatus:"+u.getStatus());
			System.out.println("******************************");
			return u.getTasks();
		}
		return null;
	}
	
	public List<Users> displayAllUsers() {
		Query q=em.createQuery("select u from Users u ");
		List<Users> users=q.getResultList();
		for(Users u:users) {
			
			System.out.println("userId:"+u.getId()+",\nUserName:"+u.getName()+",\nUserEmail:"+u.getEmail()+",\nUserPassword:"+u.getPassword()+",\nUserPhone:"+u.getPhone()+",\nUserRole"+u.getRole()+",\nUserStatus:"+u.getStatus());
			System.out.println("******************************");
		}
		return users;
	}
	
	public Users findUserByEmailPassword(String email,String password) {
		Query q=em.createQuery("select u from Users u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		Users u=(Users)q.getSingleResult();
		if(u!=null) {
			System.out.println("******************************");
			System.out.println("userId:"+u.getId()+",\nUserName:"+u.getName()+",\nUserEmail:"+u.getEmail()+",\nUserPassword:"+u.getPassword()+",\nUserPhone:"+u.getPhone()+",\nUserRole"+u.getRole()+",\nUserStatus:"+u.getStatus());
			System.out.println("******************************");
			return u;
		}
		return null;
	}

	public Users getUsers() {
		Users u=(Users)c.getBean("users");
		System.out.println("enter user name");
		u.setName(sc.nextLine());
		System.out.println("enter user email");
		u.setEmail(sc.nextLine());
		System.out.println("enter user password");
		u.setPassword(sc.nextLine());
		System.out.println("enter role as manager or employee");
		u.setRole(sc.nextLine());
		System.out.println("enter user status");
		u.setStatus(sc.nextLine());
		System.out.println("enter user phone number");
		u.setPhone(sc.nextLong());
		
		return u;
	}
	

	public List<Task> findUserById(int userId) {
		Users u=em.find(Users.class, userId);
		List<Task> tasks=u.getTasks();
		
		Collections.sort(tasks,(i,j)->i.getStatusOfTask().compareTo(j.getStatusOfTask()));
		return tasks;
		
	}

	

}
