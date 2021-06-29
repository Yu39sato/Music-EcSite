<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="Stylesheet"  href="css/EC.css">
<link href="${pageContext.request.contextPath}/css/EC.css" rel="stylesheet"
	type="" >
<%@include file="../../header2.html" %>
<%@include file="UserMenu.jsp" %>

<h1>Speaker</h1>



<table style= "border-collapse:separate;border-spacing:10px" align="center">
<c:forEach var="shoppingSpeaker"  items="${speakers}">
<tr>
<td><img src="AdminImage/${shoppingSpeaker.id}.jpg" height="80"></td>
<td>${shoppingSpeaker.itemName}</td>
<td>￥${shoppingSpeaker.price}</td>
<td><a href="CartAdd.action?id=${shoppingSpeaker.id}">カートに追加</a></td>

</tr>
</c:forEach>

</table>

<%@include file="../../footer.html" %>