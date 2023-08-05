<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="head.jsp">
	<jsp:param name="page" value="profile" />
</jsp:include>

<!-- ヘッダー -->
<%@ include file="header.jsp" %>

<div class="container-fluid">
 	<div class="row">

		<!-- サイドバー -->
		<%@ include file="sidebar.jsp" %>

		<!-- メイン -->
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10">
			<div class="main-content">
				<div>
					<img src="../assets/image.png" style="width:100%;"/>
		   			<img src="../assets/avatar.jpeg" class="rounded-circle shadow-4" id="avatar" />

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
											<img id="modal-home-image" src="../assets/image.png"/>
								   			<div class="rounded-circle" id="modal-home-image-circle"></div>
								   			<img src="../assets/camera.png" id="modal-home-image-icon" />
								   		</div>
										<div class="rounded-circle shadow-4" id="modal-avatar-wrapper" >
											<div style="position:relative;height:100%;">
									   			<img class="rounded-circle" src="../assets/avatar.jpeg" id="modal-avatar"/>
									   			<div class="rounded-circle" id="modal-avatar-circle"></div>
									   			<img src="../assets/camera.png" id="modal-avatar-icon"/>
								   			</div>
								   		</div>
							   			<form action="EditProfile.action" method="post" enctype="multipart/form-data">
							   				<input name="avatar-image" type="file" id="avatar-image-input" style="display:none;"/>
							   				<input name="home-image" type="file" id="home-image-input" style="display:none;"/>

								   			<label for="modal-name-input" style="margin-top:80px;">名前</label>
								   			<input name="name" class="form-control" id="modal-name-input" type="text" value="${currentUser.name}">
	
								   			<label for="modal-description-input" style="margin-top:30px;">自己紹介</label>
								   			<textarea name="self-description" class="form-control" id="modal-description-input" type="text"></textarea>
								   			<input type="submit" id="edit-profile-submit" style="display:none;"/>
							   			</form>
									</div>

								</div>
							</div>
						</div>
					</div>

		   			<h4>${currentUser.name}</h4>
		   			<div>${user.id}</div>
		   			<div>
		   				<span class="font-weight-bold">${followerCount}</span>
		   				<span>フォロワー</span>
		   				<span class="font-weight-bold">${followedCount}</span>
		   				<span>フォロー中</span>
		   			</div>
		   		</div>
		   		<div>
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
		   	</div>
		</main>
	</div>
</div>
<script>feather.replace()</script>
<script src="../assets/js/profile.js"></script>
</body>
</html>