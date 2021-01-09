package com.curso.jailux.serviciosweb.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRespositorio extends JpaRepository<Usuario, Integer>{ 

}
