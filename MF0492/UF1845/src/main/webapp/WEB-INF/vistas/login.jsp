<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- import="com.ipartek.formacion.uf1845.modelo.*" --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<link rel="stylesheet" href="css/bootstrap.min.css" />
<script src="js/bootstrap.bundle.min.js"></script>

</head>
<body class="container">

	<form action="login" method="post">
		<fieldset>
			<legend>Login</legend>

			<div class="row mb-3">
				<label for="email" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" name="email"
						value="${usuario.email}">
				</div>
			</div>
			<div class="row mb-3">
				<label for="password" class="col-sm-2 col-form-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password">
				</div>
			</div>

			<div class="row mb-3">
				<div class="offset-sm-2 col-sm-10">
					<button type="submit" class="btn btn-primary">Login</button>
					<span class="text-danger">${mensaje}</span>
				</div>
			</div>

		</fieldset>
	</form>


</body>
</html>