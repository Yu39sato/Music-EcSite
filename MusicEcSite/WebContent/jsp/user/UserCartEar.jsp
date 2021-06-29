<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<link rel="Stylesheet"  href="../css/EC.css">
<%@include file="../../header.html" %>

<c:choose>
	<c:when  test="${cart.size()>0}">
		<p>${cart.size()}個の商品がカートに入っています。</p>
		<hr>
	</c:when>
	<c:otherwise>
		<p>カートに商品がありません。</p>
	</c:otherwise>	
</c:choose>

<table style="border-collapse:separate;border-spacing:10px" align="center">
<c:forEach var="item" items="${cart}">
<tr>
<td>商品${item.shoppingEar.id}</td>
<td><img src="../AdminImage/${item.shoppingEar.id}.jpg" height="96"></td>
<td>${item.shoppingEar.itemName}</td>
<td>￥${item.shoppingEar.price}</td>
<td>${item.count}個</td>
<td><a href="CartRemove.action?id=${item.shoppingEar.id}">カートから削除</a></td>
</tr>
</c:forEach>
</table>

<%@include file="../../footer.html" %>