<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>

	<c:forEach items="${pizarras}" var="pizarra">
		<li>${pizarra}</li>
	</c:forEach>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>