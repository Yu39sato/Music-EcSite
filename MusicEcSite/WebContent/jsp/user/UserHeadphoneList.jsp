<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="Stylesheet"  href="css/EC.css">
<link href="${pageContext.request.contextPath}/css/EC.css" rel="stylesheet"
	type="" >
<%@include file="../../header2.html" %>
<%@include file="UserMenu.jsp" %>

<h1>Headphone</h1>



<table style= "border-collapse:separate;border-spacing:10px" align="center">
<c:forEach var="shoppingHeadphone"  items="${headphones}">
<tr>
<td><img src="AdminImage/${shoppingHeadphone.id}.jpg" height="80"></td>
<td>${shoppingHeadphone.itemName}</td>
<td>￥${shoppingHeadphone.price}</td>
<td><a href="CartAdd.action?id=${shoppingHeadphone.id}" class="tda">カートに追加</a></td>

</tr>
</c:forEach>

</table>

<%@include file="../../footer.html" %>