<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="Stylesheet"  href="../../css/EC.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../header.html"%>
<%@include file="UserMenu.jsp"  %>

<h1>Search</h1>
<div class="searchpage">
<form action="../../Search.action" method="post">
<input type ="text" name="keyword" class="">
<input type="submit" value="検索">

</form>
</div>
<hr>
<table style="border-collapse:separate;border-spacing:10px;">
<c:forEach var="ShoppingProduct"  items="${list}">
<tr>
<td>${ShoppingProduct.id}</td>
<td><img src="AdminImage/${ShoppingProduct.id}.jpg" height="64"></td>
<td>${ShoppingProduct.itemName}</td>
<td>￥${ShoppingProduct.price}</td>
<td><a href="CartAdd.action?id=${ShoppingProduct.id}">カートに追加</a></td>
</tr>
</c:forEach>
</table>

<%@include file="../../footer.html" %>