<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Listado de juegos:</h1>
<h2>${listado}</h2>
<form action="detalle" method="post">
		Id juego:  <input type="text" name="id"><br>
		<input type="submit" value="Pulsame">
	</form>
</body>
</html>