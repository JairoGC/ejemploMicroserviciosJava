package com.curso.jailux.serviciosweb.versionado;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaVersionRecurso {

	@GetMapping("v1/persona")
	public PersonaV1 personaV1() {
		return new PersonaV1("Jose");
	}
	
	@GetMapping("v2/persona")
	public PersonaV2 personaV2() {
		return new PersonaV2(new Nombre("Miguel","Torres"));
	}
	
	@GetMapping(value="/persona/param", params = "version=1")
	public PersonaV1 parametroV1() {
		return new PersonaV1("Jose");
	}
	
	@GetMapping(value="/persona/param", params = "version=2")
	public PersonaV2 parametroV2() {
		return new PersonaV2(new Nombre("Miguel","Torres"));
	}
	
	@GetMapping(value="/persona/encabezado", headers = "X-API-VERSION=1")
	public PersonaV1 encabezadoV1() {
		return new PersonaV1("Jose");
	}
	
	@GetMapping(value="/persona/encabezado", headers = "X-API-VERSION=2")
	public PersonaV2 encabezadoV2() {
		return new PersonaV2(new Nombre("Miguel","Torres"));
	}
	
	@GetMapping(value="/persona/produces", produces = "application/vnd.company.app-v1+json")
	public PersonaV1 producesV1() {
		return new PersonaV1("Jose");
	}
	
	@GetMapping(value="/persona/produces", produces = "application/vnd.company.app-v2+json")
	public PersonaV2 producesV2() {
		return new PersonaV2(new Nombre("Miguel","Torres"));
	}
	
}
