<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="head.jsp" %>

<!-- ヘッダー -->
<%@ include file="header.jsp" %>

<div class="container-fluid">
 	<div class="row">

		<!-- サイドバー -->
		<%@ include file="sidebar.jsp" %>

		<!-- メイン -->
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
			<div style="text-align: center;">
	   			<img src="../assets/avatar.jpeg" class="rounded-circle shadow-4" style="width:150px; height:150px; border: silver solid 1px;" />
	   		</div>
		</main>
	</div>
</div>
<script>feather.replace()</script>
</body>
</html>