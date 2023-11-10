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
		background-color:teal;
	}
</style>

</head>
<body>
	<fieldset style=" color:red ; background-color:grey; width:350px">
		<form action="createEmployee" method="post">
		
			userName <input type="text" name="user"><br><br>
			userEmail <input type="text" name="email"><br><br>
			userPhoneNo <input type="tel" name="phone"><br><br>
			userPassword <input type="password" name="pass"><br><br>
			<input type="hidden" value="employee" name="role">
			userStatus <input type="text" name="status"><br><br>
			
			<input type="submit" value="saveEmployee" id="button"> <br><br>
			<button id="button"> <a href="ManagerDashBoard.jsp">Cancel</a> </button>
		
		</form>
	</fieldset>
</body>
</html>