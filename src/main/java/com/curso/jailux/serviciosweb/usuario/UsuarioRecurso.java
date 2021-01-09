package com.curso.jailux.serviciosweb.usuario;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UsuarioRecurso {

	@Autowired
	private UsuarioDaoServicio servicio;
	
	@GetMapping("/usuarios")
	public List<Usuario> recuperarTodos(){
		return servicio.encontrarTodos();
	}
	
	@GetMapping("/usuarios/{id}")
	public EntityModel<Usuario> recuperar(@PathVariable int id){
		Usuario usuario = servicio.encontrarPorId(id);
		if(usuario == null) {
			throw new UsuarioNoEncontradoException("id-"+id);
		}
		EntityModel<Usuario> resource = EntityModel.of(usuario);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).recuperarTodos());
		
		resource.add(linkTo.withRel("usuarios-todos"));
		return resource;
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void eliminar(@PathVariable int id){
		Usuario usuario = servicio.eliminarPorId(id);
		if(usuario == null) {
			throw new UsuarioNoEncontradoException("id-"+id);
		}
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Object> crear(@Valid @RequestBody Usuario usuario){
		Usuario usuarioGuardado = servicio.guardar(usuario);
		URI localizacion = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(usuarioGuardado.getId()).toUri();
		return ResponseEntity.created(localizacion).build();
	}
	
}
