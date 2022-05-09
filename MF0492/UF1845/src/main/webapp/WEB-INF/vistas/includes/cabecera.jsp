<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<title>Login</title>

<base href="${pageContext.request.contextPath}/">

<link rel="stylesheet" href="css/datatables.min.css" />
<script src="js/datatables.min.js"></script>

</head>
<body class="h-100 d-flex flex-column">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="index">LibrosApp</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item">
						<a class="nav-link" href="index">Inicio</a>
					</li>
				</ul>
				<span class="navbar-text">${sessionScope.usuario.email}</span>
				<ul class="navbar-nav mb-2 mb-lg-0">
					<li class="nav-item">
						<c:if test="${sessionScope.usuario == null}">
							<a class="nav-link" href="login">Login</a>
						</c:if>
						<c:if test="${sessionScope.usuario != null}">
							<a class="nav-link" href="admin/desconectar">Desconectar</a>
						</c:if>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<main class="container">