package org.juanfigueroa.springcloud.msvc.usuarios.services;

import org.juanfigueroa.springcloud.msvc.usuarios.clients.CursoClientRest;
import org.juanfigueroa.springcloud.msvc.usuarios.models.entity.Usuario;
import org.juanfigueroa.springcloud.msvc.usuarios.repository.UsuarioRpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRpository usuarioRepo;

    @Autowired
    private CursoClientRest cursoCliente;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return (List<Usuario>) usuarioRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> porId(Long id) {
        return usuarioRepo.findById(id);
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        usuarioRepo.deleteById(id);
        cursoCliente.eliminarCursoUsuarioPorId(id);
    }

    @Override
    @Transactional
    public Optional<Usuario> porEmail(String email) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listarPorIds(Iterable<Long> ids) {
        return (List<Usuario>) usuarioRepo.findAllById(ids);
    }
}
