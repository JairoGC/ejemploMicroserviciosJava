package com.curso.jailux.serviciosweb.excepcion;

import java.util.Date;

public class ExcepcionRespuesta {
	private Date timestamp;
	private String mensaje;
	private String detalle;
	
	public ExcepcionRespuesta(Date timestamp, String mensaje, String detalle) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMensaje() {
		return mensaje;
	}

	public String getDetalle() {
		return detalle;
	}
	
}
