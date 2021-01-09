package com.curso.jailux.serviciosweb.usuario;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Definicion de usuario")
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message = "El nombre debe tener mas de un caracter")
	@ApiModelProperty(notes = "El nombre debe tener mas de un caracter")
	private String nombre;
	
	@Past
	@ApiModelProperty(notes = "La fecha de nacimiento no puede ser mayor a la fecha actual")
	private Date fechaNacimiento;
	
	protected Usuario() {
		super();
	}

	public Usuario(Integer id, String nombre, Date fechaNacimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	
}
