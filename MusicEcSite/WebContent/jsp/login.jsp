<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>

<%@ include file="../header.html" %>	

<%-- <link rel="stylesheet" href="../css/login.css">--%>


<p>${login.error}</p>

<div class="loged_in">
<h2>Login</h2>
<form action ="../servlet/loginAction" method = "post">

	<div class="member">
		<input type ="text" name="id" placeholder="ID"><br>
	</div>
	
	<div class="member">
		<input type ="password" name="password" placeholder="password"><br>
	</div>
	
	<div class="button">
		<input type ="submit" value="Login">
	</div>
</form>
</div>


<%@ include file="../footer.html" %>	

