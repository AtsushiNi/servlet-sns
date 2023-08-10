<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../components/head.jsp">
	<jsp:param name="page" value="userIndex" />
</jsp:include>

<!-- ヘッダー -->
<%@ include file="../components/header.jsp" %>

<div class="container-fluid">
  <div class="row">
  
  <!-- サイドバー -->
  <%@ include file="../components/sidebar.jsp" %>

	<!-- メイン -->
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">Users</h1>
      </div>
      <table class="table">
      <thead>
      	<tr>
      		<th>name</th>
      		<th>email</th>
      	</tr>
      </thead>
      <c:forEach var="user" items="${users}">
      	<tr>
      		<td>${user.name}</td>
      		<td>${user.email}</td>
      	</tr>
      </c:forEach>
      </table>
	</main>
	</div>
</div>
<script>feather.replace()</script>
</body>
</html>