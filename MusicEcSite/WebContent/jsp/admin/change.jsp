<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="Stylesheet"  href="../css/admin.css">
<%@include file="../../adminHeader.html" %>

<h1>Change</h1>

<form action= "../../jp.co.aforce.servlet/changeServlet"  method="post">
<table style= "border-collapse:separate;border-spacing:10px">
<c:forEach var="shoppingproduct" items="${list}">
<tr>
<td><img src="AdminImage/${shoppingproduct.id}.jpg" height="80"></td>
<td>${shoppingproduct.itemName}</td>
<td>￥${shoppingproduct.price}</td>
<td><a href = "${shoppingproduct.id }"><button type="submit" name="change" class="button" >change</button></a></td>
</tr>
</c:forEach>

</table>
</form>

<%@include file= "../../adminFooter.html" %>