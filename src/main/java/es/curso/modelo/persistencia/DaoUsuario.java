package es.curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidad.Usuario;
@Repository

public interface DaoUsuario extends JpaRepository<Usuario, Integer>{

	public List<Usuario> findByUsuario(String usuario); 
	
	/*public static Usuario obtener(String usuario, String contrasena) {
		if (usuario.equals("pepe")) {
		if(contrasena.equals("1234")) {
		Usuario u = new Usuario();
		return u;
		}
		return null;
		} else {
		return null;
		}
		}*/
}
