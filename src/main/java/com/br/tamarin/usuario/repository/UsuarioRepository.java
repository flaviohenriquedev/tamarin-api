package com.br.tamarin.usuario.repository;


import com.br.tamarin.root.repository.CRUDRepository;
import com.br.tamarin.usuario.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends CRUDRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String email);
}
