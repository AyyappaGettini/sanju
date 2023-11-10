<%@page import="org.hibernate.Session"%>
<%@page import="com.ty.tastManagement.Controller.model.dto.Users"%>
<%@page import="com.ty.tastManagement.Controller.model.dao.UserDao"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserDao userDao=(UserDao)session.getAttribute("userDao");
		List<Users> user=userDao.displayAllUsers();
		
		PrintWriter pw=response.getWriter();
		for(Users u:user){
			pw.print("<html><body>");
			pw.print("<h2>UserId:"+u.getId()+"</h2>");
			pw.print("<h2>UserName:"+u.getName()+"</h2>");
			pw.print("<h2>UserEmail:"+u.getEmail()+"</h2>");
			pw.print("<h2>UserPassword:"+u.getPassword()+"</h2>");
			pw.print("<h2>UserPhone:"+u.getPhone()+"</h2>");
			pw.print("<h2>UserRole:"+u.getRole()+"</h2>");
			pw.print("<h2>UserStatus:"+u.getStatus()+"</h2>");
			pw.print("<h2>*********************************</h2>");
			pw.print("</body></html>");
		}
	%>
	
	<button style=><a href="ManagerDashBoard.jsp">click here to navigate to Manager DashBoard</a></button> 
	
</body>
</html>