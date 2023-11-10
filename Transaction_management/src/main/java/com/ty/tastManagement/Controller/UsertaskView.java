package com.ty.tastManagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.tastManagement.Controller.model.dao.TaskDao;
import com.ty.tastManagement.Controller.model.dao.UserDao;

public class UsertaskView {
	@Autowired
	static UserDao userDao;
	@Autowired
	static TaskDao taskDao;
	public static void main(String[] args) {
		
		while(true) {
			UsertaskView.display();
			switch(taskDao.sc.nextInt()) {
			
			case 1:userDao.saveUser(userDao.getUsers());
				break;
			case 2:userDao.updateUsers();
				break;
			case 3:userDao.deleteUsers();
				break;
			case 4:userDao.findUsersById(userDao.sc.nextInt());
				break;
			case 5:userDao.displayAllUsers();
				break;
			case 6:UsertaskView.findUserByEmailPassword();
				break;
			case 7:taskDao.saveTask(taskDao.getTask());
				break;
			case 8:taskDao.updatetask(taskDao.sc.nextInt());
				break;
			case 9:taskDao.deleteTask();
				break;
			case 10:taskDao.findById();
				break;
			case 11:taskDao.displayAllTask();
				break;
			case 12:
				return;
			default:System.out.println("invalid choice");
			}
		}
	}

	private static void findUserByEmailPassword() {
		System.out.println("enter user email");
		userDao.sc.nextLine();
		String email=userDao.sc.nextLine();
		System.out.println("enter user password");
		String password=userDao.sc.nextLine();
		userDao.findUserByEmailPassword(email,password);
	}

	private static void display() {
		System.out.println("*****************USERS***************");
		System.out.println("ENTER 1 TO SAVE USER");
		System.out.println("ENTER 2 TO UPDATE USER");
		System.out.println("ENTER 3 TO DELETE USER");
		System.out.println("ENTER 4 TO FIND USER BY ID");
		System.out.println("ENTER 5 TO DISPLAY ALL USERS");
		System.out.println("ENTER 6 TO FIND USER BY EMAIL AND PASSWORD");
		System.out.println("*****************TASKS***************");
		System.out.println("ENTER 7 TO SAVE TASK");
		System.out.println("ENTER 8 TO UPDATE TASK");
		System.out.println("ENTER 9 TO DELETE TASK");
		System.out.println("ENTER 10 TO FIND TASK BY ID");
		System.out.println("ENTER 11 TO DISPLAY ALL TASK");
		System.out.println("ENTER 12 TO EXIT");
		System.out.println("**************************************");
		System.out.println("ENTER YOUR CHOICE");
		
		
		
		
	}
}
