<%@page import="com.ty.tastManagement.Controller.model.dto.Task"%>
<%@page import="com.ty.tastManagement.Controller.model.dao.UserDao"%>
<%@page import="com.ty.tastManagement.Controller.model.dto.Users"%>
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
	
		Users u=(Users)session.getAttribute("userName");
		UserDao userDao=(UserDao)session.getAttribute("userDao");
		PrintWriter pw=response.getWriter();
		List<Task> tasks=userDao.findUserById(u.getId());
		if(tasks.size()!=0){
			pw.print("<html><body><table border=2px cellspacing=4px cellpadding=4px rules=all><tr>");
			pw.print("<th>TaskId   </th>");
			pw.print("<th>TaskDescription  </th>");
			pw.print("<th>TaskCreatedTime:  </th>");
			pw.print("<th>TaskCompletedTime  </th>");
			pw.print("<th>StatusOfTask  </th>");
			pw.print("</tr>");
			for(Task t:tasks){
				
				pw.print("<html><body><tr>");
				pw.print("<td>"+t.getId()+"</td>");
				pw.print("<td>"+t.getDescription()+"</td>");
				pw.print("<td>"+t.getCreatedDateTime()+"</td>");
				pw.print("<td>"+t.getCompletedDateTime()+"</td>");
				pw.print("<td>"+t.getStatusOfTask()+"</td>");
				pw.print("</tr>");
			}
			pw.print("</table></body></html>");
		}
		else{
			pw.print("<html><body>");
			pw.print("<h2>No task found</h2>");
			pw.print("</body></html>");
		}
	%>
	<br><br><br>
	<button style=><a href="EmployeeDashBoard.jsp">click here to navigate to Manager DashBoard</a></button> 

</body>
</html>