package com.Localtec.Services;

import java.util.List;

import com.Localtec.Entity.Usuario;

public interface UsuarioService {

	Usuario saveUsuario(Usuario usuario);
	
	List<Usuario> getAllUsuarios();
	
	Usuario getUsuarioById(Long id);
	
	Usuario updateUsuarioById(Long id, Usuario newUsuario);
	
	String deleteDepartmentById(Long id);
}
