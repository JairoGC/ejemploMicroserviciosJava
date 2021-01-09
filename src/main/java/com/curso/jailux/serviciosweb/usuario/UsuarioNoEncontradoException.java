package com.curso.jailux.serviciosweb.usuario;

//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -139549019923340595L;

	public UsuarioNoEncontradoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
