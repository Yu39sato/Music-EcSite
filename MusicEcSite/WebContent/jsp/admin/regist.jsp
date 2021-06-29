<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="Stylesheet"  href="../css/admin.css">
<%@include file= "../../adminHeader.html" %>

	<% 
		String cmsg = (String)request.getAttribute("cmsg");
		String emsg = (String)request.getAttribute("emsg");
	%>

	
	
	<div class="form" align="center">

		<div  align="center">
			<div class="formtitle">Registration</div>

			
			
			<%if(cmsg != null){ %>
			<div class = "alert alert-complete" role ="alert">
			<%=cmsg %>
			</div>
			<%} %>
			
			<%if(emsg != null){ %>
			<div class = "alert alert-danger" role ="alert">
			<%=emsg %>
			</div>
			<%} %>

			<h4>新規登録する商品の情報を入力して下さい。</h4>

			<form action="../jp.co.aforce.servlet/registServlet" method="post">

				<table>
					<tbody>
						<tr>
							<td>id</td>
							<td><input type="text" name="id" class = "idtd"></td>
						</tr>
						<tr>
							<td>商品名</td>
							<td><input type="text" name="itemName" class = "itemNametd"></td>
						</tr>
						<tr>
							<td>値段</td>
							<td><input type="text" name="price" class = "pricetd"></td>
						</tr>
						<tr>
							<td>カテゴリid</td>
							<td><input type="text" name ="categoryId" class = "categoryIdtd"></td>
						</tr>

					</tbody>
				</table>

				<input type = "submit" name = "btn" value = "戻る" class = "button"/> 
				<input type = "submit" name = "btn" value = "登録" class = "button"/>

			</form>

		</div>
	</div>

<%@include file ="../../adminFooter.html" %>