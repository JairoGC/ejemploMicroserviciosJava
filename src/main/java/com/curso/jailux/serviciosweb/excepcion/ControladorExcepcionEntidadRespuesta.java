package com.curso.jailux.serviciosweb.excepcion;

import java.util.Date;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.curso.jailux.serviciosweb.usuario.UsuarioNoEncontradoException;

@ControllerAdvice
@RestController
public class ControladorExcepcionEntidadRespuesta extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> manejarTodasExceptiones(Exception ex, WebRequest request) {
		ExcepcionRespuesta excepcionRespuesta = new ExcepcionRespuesta(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(excepcionRespuesta, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public final ResponseEntity<Object> manejarUsuarioNoEncontradoException(UsuarioNoEncontradoException ex, WebRequest request) {
		ExcepcionRespuesta excepcionRespuesta = new ExcepcionRespuesta(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(excepcionRespuesta, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public final ResponseEntity<Object> resultadoVacioDelAccesoData(EmptyResultDataAccessException ex, WebRequest request) {
		ExcepcionRespuesta excepcionRespuesta = new ExcepcionRespuesta(new Date(), "Recurso no encontrado", request.getDescription(false));
		return new ResponseEntity<Object>(excepcionRespuesta, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExcepcionRespuesta excepcionRespuesta = new ExcepcionRespuesta(new Date(), "Validacion fallo", ex.getBindingResult().toString());
		return new ResponseEntity<Object>(excepcionRespuesta, HttpStatus.BAD_REQUEST);
	}
	
}
