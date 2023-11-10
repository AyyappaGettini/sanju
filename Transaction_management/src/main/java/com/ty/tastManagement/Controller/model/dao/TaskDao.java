package com.ty.tastManagement.Controller.model.dao;

import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;

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
public class TaskDao {
	
	@Autowired
	EntityManager em;
	
	@Autowired
	EntityTransaction et;
	
	@Autowired
	ConfigurableApplicationContext c;
	
	@Autowired
	public Scanner sc;
	
	public Task saveTask(Task t) {
		
		et.begin();
		em.persist(t);
		et.commit();
		System.out.println("task is saved...!");
		
		return t;
		
	}
	
	public String assignTask(int personId,int taskId) {
		Users u=em.find(Users.class,personId);
		Task t=em.find(Task.class, taskId);
		List<Task> tasks;
		if(u!=null) {
			if(t!=null) {
				if(u.getTasks()!=null) {
					tasks=new ArrayList<Task>();
					tasks.add(t);
				}
				else {
					tasks=u.getTasks();
					tasks.add(t);
				}
					t.setUser(u);
			}
			else {
				return "task";
			}
			
		}
		else {
			return "user";
		}
		et.begin();
		em.merge(u);
		em.merge(t);
		et.commit();
		return null;
	}
	
	public void updatetask(int taskId) {
		Task t=em.find(Task.class,taskId);
		
		if(t!=null) {
			
			t.setStatusOfTask("completed");
			et.begin();
			em.merge(t);
			et.commit();
			System.out.println("task updated...!");
		}
		else {
			System.out.println("task is not present...!");
		}
	}
	
	public void deleteTask() {
		System.out.println("enter task id to delete");
		Task t=em.find(Task.class,sc.nextInt());
		if(t!=null) {
			t.setUser(null);
			et.begin();
			em.merge(t);
			em.remove(t);
			et.commit();
			System.out.println("Task is deleted...!");
		}
		else {
			System.out.println("Task is not deleted...!");
		}
	}
	
	public void findById() {
		System.out.println("enter id to find task");
		Task t=em.find(Task.class,sc.nextInt());
		if(t!=null) {
			System.out.println("TaskId:"+t.getId()+",\nTask Description:"+t.getDescription()+",\nTask created time:"+t.getCreatedDateTime()+",\nTask status:"+t.getStatusOfTask()+",\nTaskCompletedTime:"+t.getCompletedDateTime());
		}
		else {
			System.out.println("task not found");
		}
	}
	
	public List<Task> displayAllTask() {
		Query q=em.createQuery("select t from Task t ");
		List<Task> tasks=q.getResultList();
		for(Task t:tasks) {
			System.out.println("TaskId:"+t.getId()+",\nTask Description:"+t.getDescription()+",\nTask created time:"+t.getCreatedDateTime()+",\nTask status:"+t.getStatusOfTask()+",\nTaskCompletedTime:"+t.getCompletedDateTime());
			System.out.println("*********************************");
		}
		return tasks;
	}

	public Task getTask() {
		Task t=(Task)c.getBean("task");
		
		System.out.println("enter description of task");
		sc.nextLine();
		t.setDescription(sc.nextLine());
		System.out.println("enter status of task");
		t.setStatusOfTask(sc.nextLine());
		
		return t;
	}
}
