package com.algaworks.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.agenda.model.Usuario;
import com.algaworks.agenda.repository.Usuarios;

@Service
public class CadastroUsuarioService {
	@Autowired
	private Usuarios usuarios;
	
	public void salvar(Usuario usuario){
		//System.out.print("cadastro usuario service");
		if (usuario != null)
			this.usuarios.save(usuario);
	}

}
