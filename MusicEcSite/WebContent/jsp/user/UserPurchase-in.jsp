<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<link rel="Stylesheet"  href="css/EC.css">
<%@include file="../../header2.html" %>

<p>${cart.size()}個の商品がカートに入っています。</p>
<hr>

<table style="border-collapse:separate;border-spacing:10px" align="center">
<c:forEach var="item" items="${cart}">
<tr>
<td>商品${item.shoppingHead.id}</td>
<td><img src="AdminImage/${item.shoppingHead.id}.jpg" height="96"></td>
<td>${item.shoppingHead.itemName}</td>
<td>￥${item.shoppingHead.price}</td>
<td>${item.count}個</td>
<td><a href="CartRemove.action?id=${item.shoppingHead.id}">カートから削除</a></td>
</tr>
</c:forEach>
</table>

<hr>
<div class="insertform">
<form action="Purchase.action" method="post" >
<p>名前<input type="text" name="name"></p>
<p>住所<input type= "text" name="address"></p>
<p><input type= "submit" value="購入を確定" class="purchase"></p>
</form>
</div>
<%@include file="../../footer.html" %>