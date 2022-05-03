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
	<input type="number" name="id" value="${libro.id}" readonly placeholder="Id" />
	<span>${libro.errores.id}</span>
	<input type="text" name="titulo" value="${libro.titulo}" placeholder="Título" />
	<span>${libro.errores.titulo}</span>
	<input type="text" name="autor" value="${libro.autor}" placeholder="Autor" />
	<span>${libro.errores.autor}</span>
	<input type="text" name="isbn" value="${libro.isbn}" placeholder="ISBN" />
	<span>${libro.errores.isbn}</span>
	<input type="number" step=".01" name="precio" value="${libro.precio}" placeholder="Precio" />
	<span>${libro.errores.precio}</span>
	
	<button>Guardar</button>
</form>

</body>
</html>