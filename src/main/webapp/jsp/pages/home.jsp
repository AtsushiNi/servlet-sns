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
					<li class="media py-3">
						<img src=${currentUser.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(currentUser.getAvatarFileName())} class="rounded-circle shadow-4" />
						<div class="media-body">
							<h6 class="mt-0">${currentUser.name}</h6>
							<form action="CreatePost.action" method="post">
								<textarea name="text" class="form-control" placeholder="今何してる？"></textarea>
						   		<button type="submit" class="btn btn-primary float-right my-2">投稿する</button>
						   	</form>
						</div>
					</li>
					<c:forEach var="post" items="${posts}">
					 	<a class="media py-3 post-row" href="PostDetail.action?id=${post.id}">
					  		<img src=${post.user.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(post.user.getAvatarFileName())} class="rounded-circle shadow-4" />
					  		<div class="media-body">
					  			<div class="d-flex">
							   		<h6 class="mr-1">${post.user.name}</h6>
							   		<div class="text-secondary">${post.user.id}</div>
						   		</div>
						   		<div>${post.text}</div>
						   		<div class="d-flex align-items-center justify-content-between mt-2">
						   			<div class="d-flex">
						   				<div class="action-wrapper">
								   			<span data-feather="message-circle" class="action-button"></span>
								   		</div>
							   			<span class="text-secondary mr-4 ml-1 action-number">8</span>
						   				<div class="action-wrapper">
								   			<span data-feather="repeat" class="action-button"></span>
								   		</div>
							   			<span class="text-secondary mr-4 ml-1 action-number">8</span>
						   				<div class="action-wrapper">
								   			<span data-feather="heart" class="action-button"></span>
								   		</div>
							   			<span class="text-secondary mr-4 ml-1 action-number">8</span>
							   		</div>
							   		<div style="text-align:right;">${post.createdAtText()}</div>
						   		</div>
					  		</div>
					 	</a>
					</c:forEach>
				</ul>
			</div>
		</main>
	</div>
</div>
<script>feather.replace()</script>
<script src="../../assets/js/home.js"></script>
</body>
</html>