package com.Localtec.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Localtec.Entity.Avaliacao;
import com.Localtec.Entity.Usuario;
import com.Localtec.Services.AvaliacaoService;
import com.Localtec.Services.UsuarioService;

@RestController
public class ControllerTest {
	
	@Autowired
	private	UsuarioService usuarioService;
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	 @PostMapping("/usuario")
		public Usuario saveUsuario(@RequestBody Usuario usuario) {
	        return usuarioService.saveUsuario(usuario);
	    }

	    @GetMapping("/usuario")
	    public List<Usuario> getAllUsuarios() {
	        return usuarioService.getAllUsuarios();
	    }

	    @PostMapping("/avaliacao")
	    public Avaliacao saveAvaliacao(@RequestBody Avaliacao avaliacao) {
	    	return avaliacaoService.saveAvaliacao(avaliacao);
	    }
	    
	    @GetMapping("/usuario/{id}")
	    public Usuario getUsuarioById(@PathVariable("id") Long id) {
	        return usuarioService.getUsuarioById(id);
	    }

	    @PutMapping("/usuario/{id}")
	    public Usuario updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
	        return usuarioService.updateUsuarioById(id, usuario);
	    }

	    @DeleteMapping("/usuario/{id}")
	    public String deleteUsuario(@PathVariable("id") Long id) {
	        return usuarioService.deleteDepartmentById(id);
	        }
}