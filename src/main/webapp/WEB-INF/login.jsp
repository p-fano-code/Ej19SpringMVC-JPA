<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Videojuegos</h1>
	<form action="listaJuegos" method="post">
		User: 	  <input type="text" name="user"><br>
		Password: <input type="text" name="pass">
		<input type="submit" value="Pulsame">
	</form><br>
	<h3>¿No tienes cuenta? Registrate aqui:</h3><br>
	<a href="singup">Date de alta!</a>
	
</body>
</html>