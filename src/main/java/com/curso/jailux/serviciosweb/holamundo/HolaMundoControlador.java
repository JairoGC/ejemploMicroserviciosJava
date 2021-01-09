package com.curso.jailux.serviciosweb.holamundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoControlador {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/hola-mundo")
	public String holaMundo() {
		return "hola mundo";
	}
	
	@GetMapping(path = "/hola-mundo-bean")
	public HolaMundoBean holaMundoBean() {
		return new HolaMundoBean("hola mundo");
	}
	
	@GetMapping(path = "/hola-mundo/path-variable/{nombre}")
	public HolaMundoBean holaMundoPathVariable(@PathVariable String nombre) {
		return new HolaMundoBean(String.format("hola mundo, %s", nombre));
	}
	
	@GetMapping(path = "/hola-mundo-internacionalizacion")
	public String holaMundoInternacionalizacion() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
