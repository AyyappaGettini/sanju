package com.ty.tastManagement.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.tastManagement.Controller.model.dao.UserDao;
import com.ty.tastManagement.Controller.model.dto.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Controller
public class CreateEmployee
{
	@Autowired
	UserDao u;
	@PostMapping("/createEmployee")
	protected String createEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users user=new Users();
		
		user.setName(req.getParameter("user"));
		user.setEmail(req.getParameter("email"));
		user.setPassword(req.getParameter("pass"));
		user.setPhone(Long.parseLong(req.getParameter("phone")));
		user.setRole(req.getParameter("role"));
		user.setStatus(req.getParameter("status"));
		
		
		u.saveUser(user);
		return "ManagerDashBoard.jsp";
	}
}
