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
    <div style="display:flex;">
	    <div style="width:80%;">
	  	  <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	        <h1 class="h2">Home</h1>
	      </div>
	      <c:forEach var="post" items="${posts}">
	      	<div class="card">
	      		<div style="display: flex">
		      		<img src="../assets/avatar.jpeg" class="rounded-circle shadow-4" style="width:50px; height:50px; margin: 10px;" />
		      		<div style="width:100%;">
			      		<div style="margin: 5px 0; font-weight:bold;">${post.user.name}</div>
			      		<div>${post.text}</div>
			      		<div style="text-align:right;">${post.createdAt}</div>
			      	</div>
			    </div>
	      	</div>
	      </c:forEach>
	    </div>
	    <div>
	    </div>
	</div>
	</main>
	</div>
</div>
<script>feather.replace()</script>
</body>
</html>