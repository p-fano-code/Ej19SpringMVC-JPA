package es.curso.modelo.negocio;

public class Rules {
	
	public boolean verificar(String user, String pass) {
		if(user.equals("pepe") && pass.equals("1234")) {
			return true;
		}else if(user.equals("juan") && pass.equals("contrasenia")) {
			return true;
		}else if(user.equals("manuel") && pass.equals("cachopo")) {
			return true;
		}else {
			return false;
		}
		
	}
}
