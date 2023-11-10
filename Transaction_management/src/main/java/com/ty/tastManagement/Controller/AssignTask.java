package com.ty.tastManagement.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.tastManagement.Controller.model.dao.TaskDao;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Controller
public class AssignTask {
	@Autowired
	TaskDao taskDao;
	@PostMapping("/assigntask")
	protected String assignTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		taskDao.assignTask(Integer.parseInt(req.getParameter("uid")), Integer.parseInt(req.getParameter("tid")));
		
		return "ManagerDashBoard.jsp";
	}
}
