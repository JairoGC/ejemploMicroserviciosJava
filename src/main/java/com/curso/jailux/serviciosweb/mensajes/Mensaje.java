package com.curso.jailux.serviciosweb.mensajes;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.curso.jailux.serviciosweb.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Definicion de mensajes de usuario")
@Entity
public class Mensaje {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message = "La descripcion debe tener mas de un caracter")
	@ApiModelProperty(notes = "El descripcion debe tener mas de un caracter")
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Usuario usuario;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Mensajes [id=" + id + ", descripcion=" + descripcion + "]";
	}
}
 