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

import com.curso.jailux.serviciosweb.mensajes.Mensaje;
import com.curso.jailux.serviciosweb.mensajes.MensajeRepositorio;

@RestController
public class UsuarioJpaRecurso {

	@Autowired
	private UsuarioRepositorio usuarioRespositorio;
	
	@Autowired
	private MensajeRepositorio mensajeRepositorio;

	@GetMapping("/jpa/usuarios")
	public List<Usuario> recuperarTodos() {
		return usuarioRespositorio.findAll();
	}

	@GetMapping("/jpa/usuarios/{id}")
	public EntityModel<Usuario> recuperarUno(@PathVariable int id) {
		Optional<Usuario> usuario = usuarioRespositorio.findById(id);

		if (!usuario.isPresent()) {
			throw this.getExceptionUsurioNoEncontrado(id);
		}

		EntityModel<Usuario> resource = EntityModel.of(usuario.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).recuperarTodos());

		resource.add(linkTo.withRel("usuarios-todos"));
		return resource;
	}

	@DeleteMapping("/jpa/usuarios/{id}")
	public void eliminar(@PathVariable int id) {
		try {
			usuarioRespositorio.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw this.getExceptionUsurioNoEncontrado(id);
		}
	}

	@PostMapping("/jpa/usuarios")
	public ResponseEntity<Object> crear(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioGuardado = usuarioRespositorio.save(usuario);
		URI localizacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioGuardado.getId()).toUri();
		return ResponseEntity.created(localizacion).build();
	}
	
	@GetMapping("/jpa/usuarios/{id}/mensajes")
	public List<Mensaje> recuperarMensajesDeUsuario(@PathVariable int id) {
		Optional<Usuario> usuario = usuarioRespositorio.findById(id);
		if (!usuario.isPresent()) {
			throw this.getExceptionUsurioNoEncontrado(id);
		}
		return usuario.get().getMensajes();
	}
	
	@PostMapping("/jpa/usuarios/{id}/mensajes")
	public ResponseEntity<Object> crearMensajesDeUsuario(@PathVariable int id, @Valid @RequestBody Mensaje mensaje) {
		Optional<Usuario> usuario = usuarioRespositorio.findById(id);
		if (!usuario.isPresent()) {
			throw this.getExceptionUsurioNoEncontrado(id);
		}
		
		mensaje.setUsuario(usuario.get());
		mensajeRepositorio.save(mensaje);
		
		URI localizacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(mensaje.getId()).toUri();
		return ResponseEntity.created(localizacion).build();
	}
	
	private EmptyResultDataAccessException getExceptionUsurioNoEncontrado(int id) {
		return new EmptyResultDataAccessException("usuario no encontrado [id=" + id+"]",1);
	}

}
