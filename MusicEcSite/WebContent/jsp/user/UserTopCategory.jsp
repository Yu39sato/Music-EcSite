<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="Stylesheet"  href="../../css/EC.css">
<%@include file= "../../header.html" %>
<%@include file="UserMenu.jsp"  %>

<h1>Category</h1>
<div class="message">
<p>Welcome to SoundHome!</p>
</div>
<div class="form-conf">
<form action="../Headphone.action" method="post"><button type="submit" name="Headphone"  class="button">Headphone</button></form>
<form action ="../Earphone.action" method= "post"><button type="submit" name="Earphone"  class="button">Earphone</button></form>
<form action ="../Microphone.action" method= "post"><button type="submit" name="Microphone" class="button">Microphone</button></form>
<form action="../Speaker.action" method= "post"><button type="submit" name="Speaker" class="button">Speaker</button></form>
<%@include file ="../../footer.html" %>
</div>
<div class="a-search">
<a href="../jsp/user/UserSearch.jsp" class="search">検索はこちら</a>
</div>