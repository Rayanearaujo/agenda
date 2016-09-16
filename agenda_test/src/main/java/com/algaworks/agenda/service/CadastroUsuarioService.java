package com.algaworks.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.agenda.model.Usuario;
import com.algaworks.agenda.repository.Usuarios;

public class CadastroUsuarioService {
	@Autowired
	private Usuarios usuarios;
	
	public void salvar(Usuario usuario){
		//if (usuario != null)
		this.usuarios.save(usuario);
	}

}
