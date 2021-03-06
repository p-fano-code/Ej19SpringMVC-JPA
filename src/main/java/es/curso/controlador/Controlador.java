package es.curso.controlador;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.curso.cfg.ConfigJPA;
import es.curso.modelo.entidad.Usuario;
import es.curso.modelo.entidad.Videojuego;
import es.curso.modelo.persistencia.DaoUsuario;
import es.curso.modelo.persistencia.DaoVideojuego;

@Controller
@ComponentScan(basePackages = {"es.curso"})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"es.curso.modelo.persistencia"})
public class Controlador {

		
	@RequestMapping("verlogin")
	public String verlogin() {
		return "login";
	}
	
	@Autowired
	DaoUsuario ud;
	
	Usuario u1 = new Usuario();
	
	@RequestMapping("singup")
	public String versingup() {
		return "singup";
	}
	
	@PostMapping("alta")
	public String doSingup(@RequestParam("user") String username,
							@RequestParam("pass") String password) {
		
		u1.setUsuario(username);
		u1.setContrasenia(password);
		
		ud.save(u1);
		
		return "login";
	}
	
	@Autowired
	DaoVideojuego dv;
	
	@PostMapping("listaJuegos")
	public String verListaJuegos(@RequestParam("user") String user,
			 				     @RequestParam("pass") String pass,
			 				     HttpServletRequest r){		
		 
		r.setAttribute("listado", dv.findAll());
		
		List<Usuario> ulista = ud.findByUsuario(user);
		
		boolean usnameVerificado = false;
		boolean uspassVerificado = false;
		System.out.println(ulista.get(0).getUsuario());
		for (int i = 0; i < ulista.size(); i++) {
			if(ulista.get(i).getUsuario().equals(user) ) {
				System.out.println(ulista);
				if(ulista.get(i).getContrasenia().equals(pass) ) {
					System.out.println("entro");
					usnameVerificado = true;
					uspassVerificado = true;
					break;
				}
			}
		}
		
		 if(usnameVerificado == true && uspassVerificado == true) {
			 return "listaVideojuegos";
		 }else return "errorLista";
		
	}
	
	@RequestMapping("adicionar")
	public String veradicionar() {
		return "adicionar";
	}
	
	@PostMapping("addJuego")
	public String addJuego(@RequestParam("nombre") String nombre,
						   @RequestParam("compania") String compania,
						   @RequestParam("nota") int nota,
						   HttpServletRequest r) {
		Videojuego vadd = new Videojuego();
		vadd.setNombre(nombre);
		vadd.setCompania(compania);
		vadd.setNotaMedia(nota);
		
		dv.save(vadd);
		r.setAttribute("listado", dv.findAll());
		
		return "listaVideojuegos";
		
	}
	
	@PostMapping("detalle")
	public String verDetalle(@RequestParam("id") String id, HttpServletRequest r){
		int newId = Integer.parseInt(id);
	
		
		if(dv.findById(newId).isEmpty() != true)  {
			r.setAttribute("j", dv.findById(newId).get());
			return "detalleJuego";
		}else return "errorDetalle";
	}
	
	
}


