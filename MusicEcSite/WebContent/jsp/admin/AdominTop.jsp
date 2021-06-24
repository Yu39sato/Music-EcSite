<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="Stylesheet"  href="../../css/EC.css">
<%@include file= "../../header.html" %>

<h1>Administrator</h1>

<form action= "../../Product.action"  method="post"><button type="submit" name="listOfGoods" class="button">List of goods</button></form>
<form action= "../../jp.co.aforce.servlet/administrationServlet"  method="post"><button type="submit" name="buttonName" class="button" value = "Registration">Registration</button></form>
<form action= "../../jp.co.aforce.servlet/administrationServlet"  method="post"><button type="submit" name="buttonName" class= "button" value = "DeleteOrChange">Delete/Change</button></form>

<%@include file ="../../footer.html" %>