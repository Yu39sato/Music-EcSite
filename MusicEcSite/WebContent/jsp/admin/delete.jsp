<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="Stylesheet"  href="../css/EC.css">
<%@include file="/header.html" %>

<h1>Delete</h1>

<table style= "border-collapse:separate;border-spacing:10px">
<c:forEach var="shoppingproduct" items="${list}">
<tr>
<td><img src="AdminImage/${shoppingproduct.id}.jpg" height="80"></td>
<td>${shoppingproduct.itemName}</td>
<td>￥${shoppingproduct.price}</td>
<td><form action= "../../jp.co.aforce.servlet/deleteServlet"  method="post"><a href = "${shoppingproduct.id }"><button type="submit" name="delete" class="button" >delete</button></a></form></td>
</tr>
</c:forEach>

</table>

<%@include file= "/footer.html" %>