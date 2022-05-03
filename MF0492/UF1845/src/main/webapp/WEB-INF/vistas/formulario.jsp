<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
</head>
<body>

<h1>Formulario</h1>

<pre>${libro}</pre>

<form action="formulario" method="post">
	<input type="number" name="id" value="${libro.id}" readonly placholder="Id" />
	<input type="text" name="titulo" value="${libro.titulo}" placeholder="Título" />
	<input type="text" name="autor" value="${libro.autor}" placeholder="Autor" />
	<input type="text" name="isbn" value="${libro.isbn}" placeholder="ISBN" />
	<input type="number" step=".01" name="precio" value="${libro.precio}" placeholder="Precio" />
	
	<button>Guardar</button>
</form>

</body>
</html>