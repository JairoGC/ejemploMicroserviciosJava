package com.curso.jailux.serviciosweb.holamundo;

public class HolaMundoBean {

	private String mensaje;

	public HolaMundoBean(String mensaje) {
		this.mensaje = mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	@Override
	public String toString() {
		return "HolaMudoBean [mensaje=" + mensaje + "]";
	}
	
}
