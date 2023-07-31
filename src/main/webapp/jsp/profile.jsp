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
		<main role="main" class="col-md-9 ml-sm-auto col-lg-10">
			<div style="margin: 0 100px;max-width:700px;">
				<div>
					<img src="../assets/image.png" style="width:100%;"/>
		   			<img src="../assets/avatar.jpeg" class="rounded-circle shadow-4" style="width:150px; height:150px; border: silver solid 1px;position:absolute;left:130px;top:200px;" />

					<div style="height:80px;width:100%;display:flex;justify-content:flex-end;align-items:flex-end;">
						<button class="btn btn-outline-secondary" style="border-radius:50px;" data-toggle="modal" data-target="#modal">プロフィールを編集</button>
						<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document"" style="max-width:800px;">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title">プロフィールを編集</h5>
										<button class="btn btn-secondary" style="border-radius:50px;" data-dismiss="modal" aria-label="close">保存</button>
									</div>
									<div class="modal-body">
										<img src="../assets/image.png" style="width:100%;"/>
							   			<img src="../assets/avatar.jpeg" class="rounded-circle shadow-4" style="width:150px; height:150px; border: silver solid 1px;position:absolute;left:40px;top:200px;" />
							   			<label for="modal-name-input" style="margin-top:80px;">名前</label>
							   			<input class="form-control" id="modal-name-input" type="text" value="${user.name}">
							   			<label for="modal-description-input" style="margin-top:30px;">自己紹介</label>
							   			<textarea class="form-control" id="modal-description-input" type="text"></textarea>
									</div>
								</div>
							</div>
						</div>
					</div>

		   			<h4>${user.name}</h4>
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
</body>
</html>