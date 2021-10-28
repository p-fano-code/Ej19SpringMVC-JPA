<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Añade un juego::</h1>
		<form action="addJuego" method="post">
			Nombre:  <input type="text" name="nombre"><br>
			Compañia:  <input type="text" name="compania"><br>
			Nota media:  <input type="number" name="nota"><br>
			<input type="submit" value="Pulsame">
		</form>
</body>
</html>