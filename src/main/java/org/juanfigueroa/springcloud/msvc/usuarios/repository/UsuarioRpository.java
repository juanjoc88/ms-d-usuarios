package org.juanfigueroa.springcloud.msvc.usuarios.repository;

import org.juanfigueroa.springcloud.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRpository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
