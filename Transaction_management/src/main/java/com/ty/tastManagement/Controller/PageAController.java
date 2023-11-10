package com.ty.tastManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.tastManagement.Controller.model.dao.TaskDao;
import com.ty.tastManagement.Controller.model.dao.UserDao;
import com.ty.tastManagement.Controller.model.dto.Users;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class PageAController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	TaskDao taskDao;
	
	@PostMapping("/verify")
	public String verify(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");
		
		Users u= userDao.findUserByEmailPassword(user, pass);
		PrintWriter pw=resp.getWriter();
		if(u!=null) {
			if(u.getRole().equals("manager")) {
				pw.print("<h1>login successfully to manager</h1>");
				HttpSession s=req.getSession();
				s.setAttribute("userName", u);
				s.setAttribute("userDao", userDao);
				return "ManagerDashBoard.jsp";
			}
			else if(u.getRole().equals("employee")) {
				pw.print("<h1>login successfully to employee</h1>");
				HttpSession s=req.getSession();
				s.setAttribute("userName", u);
				s.setAttribute("userDao", userDao);
				return "EmployeeDashBoard.jsp";
			}
		}
		pw.print("<h1>login failed</h1>");
		return "Login.jsp";

	}
}
