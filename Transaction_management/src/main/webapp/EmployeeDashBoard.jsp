<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	#button{
		border-radius: 10px;
		color:red;
		background-color:white;
	}
	#button:hover{
		rotate:360deg;
		transition:1s;
	}
</style>

</head>
<body style="margin-left: 40%; margin-top: 5%; text-align: center ;">
	<fieldset style=" color:red ; background-color:grey; width:400px">
		<h1 style="margin-top:-10px; ">choose any option</h1>
	
		<button id="button"><a href="viewTask.jsp">ViewEmployee</a></button>
		
		<button id="button"><a href="UpdateTask.jsp">UpdateTask</a></button>
		
		<button id="button"><a href="logoutManager.jsp">LogoutEmployee</a></button>
	</fieldset>
	
</body>
</html>