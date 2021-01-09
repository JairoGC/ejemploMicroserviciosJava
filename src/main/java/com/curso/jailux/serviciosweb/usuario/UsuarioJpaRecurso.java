package com.curso.jailux.serviciosweb.usuario;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class UsuarioJpaRecurso {

	@Autowired
	private UsuarioRespositorio usuarioRespositorio;

	@GetMapping("/jpa/usuarios")
	public List<Usuario> recuperarTodos() {
		return usuarioRespositorio.findAll();
	}

	@GetMapping("/jpa/usuarios/{id}")
	public EntityModel<Usuario> recuperar(@PathVariable int id) {
		Optional<Usuario> usuario = usuarioRespositorio.findById(id);

		if (!usuario.isPresent()) {
			throw new EmptyResultDataAccessException("usuario no encontrado [id=" + id+"]",1);
		}

		EntityModel<Usuario> resource = EntityModel.of(usuario.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).recuperarTodos());

		resource.add(linkTo.withRel("usuarios-todos"));
		return resource;
	}

	@DeleteMapping("/jpa/usuarios/{id}")
	public void eliminar(@PathVariable int id) {
		usuarioRespositorio.deleteById(id);
	}

	@PostMapping("/jpa/usuarios")
	public ResponseEntity<Object> crear(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioGuardado = usuarioRespositorio.save(usuario);
		URI localizacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioGuardado.getId()).toUri();
		return ResponseEntity.created(localizacion).build();
	}

}
