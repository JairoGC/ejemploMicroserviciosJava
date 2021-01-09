package com.curso.jailux.serviciosweb.versionado;

public class PersonaV2 {
	private Nombre nombre;

	public PersonaV2() {
		super();
	}

	public PersonaV2(Nombre nombre) {
		super();
		this.nombre = nombre;
	}

	public Nombre getNombre() {
		return nombre;
	}

	public void setNombre(Nombre nombre) {
		this.nombre = nombre;
	}
	
}
