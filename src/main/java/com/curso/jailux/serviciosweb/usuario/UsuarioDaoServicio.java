package com.curso.jailux.serviciosweb.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UsuarioDaoServicio {

	private static List<Usuario> usuarios = new ArrayList<>();
	private static int userCount = 3;
	
	static {
		usuarios.add(new Usuario(1, "Adam", new Date()));
		usuarios.add(new Usuario(2, "Eve", new Date()));
		usuarios.add(new Usuario(3, "Jack", new Date()));
	}
	
	public List<Usuario> encontrarTodos(){
		return usuarios;
	}
	
	public Usuario guardar(Usuario usuario) {
		if(usuario.getId() == null) {
			usuario.setId(++userCount);
		}
		usuarios.add(usuario);
		return usuario;
	}
	
	public Usuario encontrarPorId(Integer id) {
		for(Usuario usuario: usuarios) {
			if(usuario.getId() == id) {
				return usuario;
			}
		}
		return null;
	}
	
	public Usuario eliminarPorId(Integer id) {
		Iterator<Usuario> iterador = usuarios.iterator();
		while(iterador.hasNext()) {
			Usuario usuario = iterador.next();
			if(usuario.getId() == id) {
				iterador.remove();
				return usuario;
			}
		}
		return null;
	}
	
}
