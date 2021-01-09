package com.curso.jailux.serviciosweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiciosWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiciosWebApplication.class, args);
	}

	/*
	 * @Bean public LocaleResolver localeResolver() { AcceptHeaderLocaleResolver
	 * localeResolver = new AcceptHeaderLocaleResolver();
	 * localeResolver.setDefaultLocale(Locale.US); return localeResolver; }
	 */

	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource messageSource = new
	 * ResourceBundleMessageSource(); messageSource.setBasename("mensajes"); return
	 * messageSource; }
	 */

}
