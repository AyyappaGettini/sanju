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
public class UpdateTask{
	
	@Autowired
	TaskDao t;
	
	@PostMapping("/EmployeeDashBoar")
	protected String updateTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		t.updatetask( Integer.parseInt(req.getParameter("uid")));
	
		return "EmployeeDashBoard.jsp";
	}
	
}
