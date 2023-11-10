package com.ty.tastManagement.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.tastManagement.Controller.model.dao.TaskDao;
import com.ty.tastManagement.Controller.model.dto.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Controller
public class CreateTask{
	@Autowired
	TaskDao taskDao;
	@PostMapping("/CreateTask")
	protected String createTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Task t=new Task();
		t.setDescription(req.getParameter("taskd"));
		t.setStatusOfTask(req.getParameter("status"));
		
		
		taskDao.saveTask(t);
		
		return "ManagerDashBoard.jsp";
	}
}
