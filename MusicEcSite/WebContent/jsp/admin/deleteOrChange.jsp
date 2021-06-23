<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sound Home</title>
</head>
<body>

	<p>Delete/Change</p>
	
	<form action ="../../jp.co.aforce.servlet/deleteOrChangeServlet" method = "post">
	
		<div class = admin>
			<div class = "">Delete Or Change
				<input type = "submit" name = "buttonName" value ="DeleteItem" id = "deleteItem"/>
				<input type = "submit" name = "buttonName" value ="ChangeItem" id = "changeItem"/>
			</div>
		</div>
	
	</form>


</body>
</html>