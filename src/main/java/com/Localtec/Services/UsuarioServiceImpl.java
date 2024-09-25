package com.Localtec.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Localtec.Entity.Usuario;
import com.Localtec.Repository.UsuarioRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        List<Usuario> allUsuarios = usuarioRepository.findAll();
        return allUsuarios;
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        return null;
    }

    @Override
    public Usuario updateUsuarioById(Long id, Usuario usuario) {
        Optional<Usuario> usuario1 = usuarioRepository.findById(id);

        if (usuario1.isPresent()) {
            Usuario originalusuario = usuario1.get();

            if (Objects.nonNull(usuario.getNome()) && !"".equalsIgnoreCase(usuario.getNome())) {
                originalusuario.setNome(usuario.getNome());
            }
            if (Objects.nonNull(usuario.getCpf()) && usuario.getCpf() != null) {
                originalusuario.setCpf(usuario.getCpf());
            }
            return usuarioRepository.save(originalusuario);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {
    	Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
        	Usuario user = usuario.get();
            usuarioRepository.deleteById(id);
            return user.toString() + "deleted successfully";
        }
        return "No such usuario in the database";
    }
}