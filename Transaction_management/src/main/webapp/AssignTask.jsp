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
<body>
	<fieldset style=" color:red ; background-color:grey; width:350px">
		<form action="assigntask" method="post">
		
			UserId<input type="number" name="uid"><br><br>
			TaskId<input type="number" name="tid"><br><br>
			
			<input type="submit" value="AssignTask" id="button"> <br><br>
			<button id="button"> <a href="ManagerDashBoard.jsp">Cancel</a> </button>
		
		</form>
	</fieldset>
</body>
</html>