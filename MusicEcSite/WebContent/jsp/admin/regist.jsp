<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sound Home</title>
</head>
<body>

	<div class="form" align="center">

		<span class="errorMsg">${itemBean.errorMsg}</span> <span class="completeMsg">${itemBean.completeMsg}</span>

		<div class="signin cf" align="center">
			<div class="formtitle">Registration</div>

			<h4>新規登録する商品の情報を入力して下さい。</h4>

			<form action="../jp.co.aforce.servlet/registServlet" method="post" enctype ="multipart/form-data">

				<table border="1">
					<tbody>
						<tr>
							<td>id</td>
							<td><input type="text" name="id"></td>
						</tr>
						<tr>
							<td>商品名</td>
							<td><input type="text" name="itemName"></td>
						</tr>
						<tr>
							<td>値段</td>
							<td><input type="text" name="price"></td>
						</tr>
						<!--<tr>
							<td>説明</td>
							<td><textarea id = discript rows = "10" cols = "50"></textarea></td>
						</tr>-->
						<!--<tr>
							<td>写真</td>
							<td><input type = "file" name = "picture"></input></td>
						</tr>-->
						<tr>
							<td>カテゴリid</td>
							<td><input type = "text" name ="categoryId"></td>
						</tr>

					</tbody>
				</table>

				<input type="submit" name="buttonName" value="戻る" /> 
				<input type = "submit" name = "buttonName" value ="登録" id = "regist"/>

			</form>

		</div>
	</div>



</body>
</html>