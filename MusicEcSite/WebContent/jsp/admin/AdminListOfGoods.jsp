<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="Stylesheet"  href="../../css/EC.css">
<%@include file="../../header.html" %>

<h1>List of Goods</h1>
<p>検索キーワードを入力してください。</p>
<form action="../Product.action" method= "post">
<input type="text" name="keyword">
<input type="submit" value="Search">
</form>
<hr>

<table style= "border-collapse:separate;border-spacing:10px">
<c:forEach var="shoppingproduct" items="${list}">
<tr>
<td><img src="AdminImage/${shoppingproduct.id}.jpg" height="80"></td>
<td>${shoppingproduct.itemName}</td>
<td>￥${shoppingproduct.price}</td>
</tr>
</c:forEach>

</table>

<%@include file= "../../footer.html" %>