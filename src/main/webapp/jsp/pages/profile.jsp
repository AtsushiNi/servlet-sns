<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../components/head.jsp">
	<jsp:param name="page" value="profile" />
</jsp:include>

<!-- ヘッダー -->
<%@ include file="../components/header.jsp" %>

<div class="container-fluid">
 	<div class="row">

		<!-- サイドバー -->
		<jsp:include page="../components/sidebar.jsp">
			<jsp:param name="page" value="profile"/>
		</jsp:include>

		<!-- メイン -->
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10">
			<div class="main-content">
				<div>
					<img src=${currentUser.getHomeImageFileName().isEmpty() ? "../../assets/image.png" : "../../assets/homeImages/".concat(currentUser.getHomeImageFileName())} id="home-image"/>
		   			<img src=${currentUser.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(currentUser.getAvatarFileName())} class="rounded-circle shadow-4" id="avatar" />

					<div id="profile-edit-button-section">
						<button class="btn btn-outline-secondary" id="profile-edit-button" data-toggle="modal" data-target="#modal">プロフィールを編集</button>
						<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document"" style="max-width:800px;">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">プロフィールを編集</h5>
										<button class="btn btn-secondary" id="modal-save-button" style="border-radius:50px;" data-dismiss="modal" aria-label="close">保存</button>
									</div>

									<div class="modal-body"> 
										<div id="modal-home-image-wrapper" >
											<img id="modal-home-image" src=${currentUser.getHomeImageFileName().isEmpty() ? "../../assets/image.png" : "../../assets/homeImages/".concat(currentUser.getHomeImageFileName())} />
								   			<div class="rounded-circle" id="modal-home-image-circle"></div>
								   			<img src="../../assets/camera.png" id="modal-home-image-icon" />
								   		</div>
										<div class="rounded-circle shadow-4" id="modal-avatar-wrapper" >
											<div style="position:relative;height:100%;">
									   			<img class="rounded-circle" src=${currentUser.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(currentUser.getAvatarFileName())} id="modal-avatar"/>
									   			<div class="rounded-circle" id="modal-avatar-circle"></div>
									   			<img src="../../assets/camera.png" id="modal-avatar-icon"/>
								   			</div>
								   		</div>
							   			<form action="EditProfile.action" method="post" enctype="multipart/form-data">
							   				<input name="avatar-image" type="file" id="avatar-image-input" style="display:none;"/>
							   				<input name="home-image" type="file" id="home-image-input" style="display:none;"/>

								   			<label for="modal-name-input" style="margin-top:80px;">名前</label>
								   			<input name="name" class="form-control" id="modal-name-input" type="text" value="${currentUser.name}">
	
								   			<label for="modal-description-input" style="margin-top:30px;">自己紹介</label>
								   			<textarea name="self-description" class="form-control" id="modal-description-input" type="text">${currentUser.selfDescription}</textarea>
								   			<input type="submit" id="edit-profile-submit" style="display:none;"/>
							   			</form>
									</div>

								</div>
							</div>
						</div>
					</div>

		   			<h4>${currentUser.name}</h4>
		   			<div id="user-id">${currentUser.id}</div>
		   			<div id="self-description">${currentUser.getSelfDescriptionHTML()}</div>
		   			<div>
		   				<span class="font-weight-bold">${followerCount}</span>
		   				<span>フォロワー</span>
		   				<span class="font-weight-bold">${followedCount}</span>
		   				<span>フォロー中</span>
		   			</div>
		   		</div>
		   		<div>
		   			<ul class="list-unstyled">
						<c:forEach var="post" items="${posts}">
					      	<a class="media py-3 post-row" href="PostDetail.action?id=${post.id}" >
					      		<img src=${currentUser.getAvatarFileName().isEmpty() ? "../../assets/avatar.jpeg" : "../../assets/avatars/".concat(currentUser.getAvatarFileName())} class="rounded-circle shadow-4" style="width:50px; height:50px; margin: 10px;" />
					      		<div class="media-body">
					      			<div class="d-flex">
							      		<h6 class="mr-1">${post.user.name}</h6>
							      		<div class="text-secondary">${post.user.id}</div>
							      	</div>
						      		<div>${post.text}</div>
							   		<div class="d-flex align-items-center justify-content-between mt-2">
							   			<div class="d-flex">
								   			<span data-feather="message-circle" style="color:silver;"></span>
								   			<span class="text-secondary mr-4 ml-1">8</span>
								   			<span data-feather="repeat" style="color:silver;"></span>
								   			<span class="text-secondary mr-4 ml-1">8</span>
								   			<span data-feather="heart" style="color:silver;"></span>
								   			<span class="text-secondary mr-4 ml-1">8</span>
								   		</div>
								   		<div style="text-align:right;">${post.createdAtText()}</div>
							   		</div>
						      	</div>
					      	</a>
						</c:forEach>
					</ul>
		   		</div>
		   	</div>
		</main>
	</div>
</div>
<script>feather.replace()</script>
<script src="../../assets/js/profile.js"></script>
</body>
</html>