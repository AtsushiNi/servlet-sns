<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../components/head.jsp">
	<jsp:param name="page" value="postDetail" />
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
				<ul class="list-unstyled">
				 	<li class="media py-3 post-row" href="PostDetail.action?id=${post.id}">
				  		<img src=${post.user.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(post.user.getAvatarFileName())} class="rounded-circle shadow-4" />
				  		<div class="media-body">
				  			<div class="d-flex">
						   		<h6 class="mr-1">${post.user.name}</h6>
						   		<div class="text-secondary">${post.user.id}</div>
					   		</div>
					   		<div>${post.text}</div>
					   		<div style="text-align:right;">${post.createdAtText()}</div>
					   		
							<a class="media py-3 post-row not-a">
								<img src=${currentUser.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(currentUser.getAvatarFileName())} class="rounded-circle shadow-4" />
								<div class="media-body">
									<h6 class="mt-0">${currentUser.name}</h6>
									<form action="Reply.action" method="post">
										<textarea name="text" class="form-control" placeholder="返信する"></textarea>
										<input name="id" type="hidden" value=${post.id} />
								   		<button type="submit" class="btn btn-primary float-right my-2">投稿する</button>
								   	</form>
								</div>
							</a>

							<c:forEach var="post" items="${replies}">
							 	<a class="media py-3 post-row" href="PostDetail.action?id=${post.id}">
							  		<img src=${post.user.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(post.user.getAvatarFileName())} class="rounded-circle shadow-4" />
							  		<div class="media-body">
							  			<div class="d-flex">
									   		<h6 class="mr-1">${post.user.name}</h6>
									   		<div class="text-secondary">${post.user.id}</div>
								   		</div>
								   		<div>${post.text}</div>
								   		<div style="text-align:right;">${post.createdAtText()}</div>
							  		</div>
							 	</a>
							 </c:forEach>
						</div>
					</li>
				</ul>
			</div>
		</main>
	</div>
</div>
<script>feather.replace()</script>
</body>
</html>