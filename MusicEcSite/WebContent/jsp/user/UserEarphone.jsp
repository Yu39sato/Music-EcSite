<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="Stylesheet"  href="css/EC.css">

<%@include file="../../header.html" %>
<%@include file="UserMenu.jsp" %>

<h1>Earphone</h1>



<table style= "border-collapse:separate;border-spacing:10px">
<c:forEach var="shoppingEarphone"  items="${earphones}">
<tr>
<td><img src="AdminImage/${shoppingEarphone.id}.jpg" height="80"></td>
<td>${shoppingEarphone.itemName}</td>
<td>￥${shoppingEarphone.price}</td>
<td><a href="CartAdd.action?id=${shoppingEarphone.id}">カートに追加</a></td>

</tr>
</c:forEach>

</table>

<%@include file="../../footer.html" %>