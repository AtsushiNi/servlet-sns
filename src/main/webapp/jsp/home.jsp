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

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Home</h1>
        <p>name: ${user.name}</p>
      </div>
      <table class="table">
      <thead>
      	<tr>
      		<th>text</th>
      		<th>created at</th>
      	</tr>
      </thead>
      
      <c:forEach var="post" items="${posts}">
      	<tr>
      		<td>${post.text}</td>
      		<td>${post.createdAt}</td>
      	</tr>
      </c:forEach>
      </table>
	</main>
	</div>
</div>
<script>feather.replace()</script>
</body>
</html>