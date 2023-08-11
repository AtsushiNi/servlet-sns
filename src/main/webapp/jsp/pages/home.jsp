<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../components/head.jsp">
	<jsp:param name="page" value="home" />
</jsp:include>

<!-- ヘッダー -->
<%@ include file="../components/header.jsp" %>

<div class="container-fluid">
	<div class="row">
	
		<!-- サイドバー -->
		<jsp:include page="../components/sidebar.jsp">
			<jsp:param name="page" value="home"/>
		</jsp:include>
		
		<!-- メイン -->
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
			<div style="width:80%;">
				<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">Home</h1>
				</div>
				<ul class="list-unstyled">
					<li class="media my-3 py-1">
						<img src=${currentUser.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(currentUser.getAvatarFileName())} class="rounded-circle shadow-4" />
						<div class="media-body">
							<h5 class="mt-0">${currentUser.name}</h5>
							<form action="CreatePost.action" method="post">
								<textarea name="text" class="form-control" placeholder="今何してる？"></textarea>
						   		<button type="submit" class="btn btn-primary float-right my-2">投稿する</button>
						   	</form>
						</div>
					</li>
					<c:forEach var="post" items="${posts}">
					 	<li class="media my-3 py-1">
					  		<img src=${post.user.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(post.user.getAvatarFileName())} class="rounded-circle shadow-4" />
					  		<div class="media-body">
						   		<h5 class="mt-0">${post.user.name}</h5>
						   		<div>${post.text}</div>
						   		<div style="text-align:right;">${post.createdAtText()}</div>
					  		</div>
					 	</li>
					</c:forEach>
				</ul>
			</div>
		</main>
	</div>
</div>
<script>feather.replace()</script>
</body>
</html>