<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="Stylesheet"  href="../../css/admin.css">
<%@include file= "../../adminHeader.html" %>
	<div class = "delete" align = "center">
	<h4>Delete/Change</h4>
	
	<form action ="../../jp.co.aforce.servlet/deleteOrChangeServlet" method = "post">
	
		<div class = admin>
			<div class = "inputtitle">
				<input type = "submit" name = "buttonName" value ="Delete Item" class = "button"/>
				<input type = "submit" name = "buttonName" value ="Change Item" class = "button"/>
			</div>
		</div>
	
	</form>
	</div>

<%@include file ="../../adminFooter.html" %>