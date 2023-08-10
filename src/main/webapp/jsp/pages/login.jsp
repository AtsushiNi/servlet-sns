<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<title>Insert title here</title>
	<link rel="stylesheet" href="../../assets/css/login.css">
</head>

<body class="text-center">

<form class="form-signin" action="Login.action" method="post">
	<img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
	<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
	<label for="inputEmail" class="sr-only">User name</label>
	<input type="text" name="id" id="inputEmail" class="form-control" placeholder="User name" required autofocus>
	<label for="inputPassword" class="sr-only">Password</label>
	<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
	<div class="checkbox mb-3">
		<label>
			<input type="checkbox" value="remember-me"> Remember me
		</label>
	</div>
	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	<p class="mt-5 mb-3 text-muted">&copy; 2023 AtsushiNi</p>
</form>

</body>
</html>