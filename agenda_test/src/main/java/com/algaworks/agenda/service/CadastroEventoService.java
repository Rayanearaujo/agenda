package com.algaworks.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.agenda.model.Evento;
import com.algaworks.agenda.repository.Eventos;

@Service
public class CadastroEventoService {
	
	@Autowired
	private Eventos eventos;
	
	public void salvar(Evento evento){
		//Escrever as regras de negócio, caso existam
		this.eventos.save(evento);
	}

}
