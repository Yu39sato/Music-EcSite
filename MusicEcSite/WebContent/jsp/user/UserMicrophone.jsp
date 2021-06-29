<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="Stylesheet"  href="css/EC.css">
<link href="${pageContext.request.contextPath}/css/EC.css" rel="stylesheet"
	type="" >
<%@include file="../../header2.html" %>
<%@include file="UserMenu.jsp" %>

<h1>Microphone</h1>



<table style= "border-collapse:separate;border-spacing:10px">
<c:forEach var="shoppingMicrophone"  items="${microphones}">
<tr>
<td><img src="AdminImage/${shoppingMicrophone.id}.jpg" height="80"></td>
<td>${shoppingMicrophone.itemName}</td>
<td>￥${shoppingMicrophone.price}</td>
<td><a href="CartAdd.action?id=${shoppingMicrophone.id}">カートに追加</a></td>

</tr>
</c:forEach>

</table>

<%@include file="../../footer.html" %>