package com.algaworks.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.algaworks.agenda.model.Evento;
import com.algaworks.agenda.repository.Eventos;

public class ExcluirEventoService {
	@Autowired
	private Eventos eventos;
	
	public void excluir(Evento evento){
		if (evento != null)
			this.eventos.delete(evento);
	}
}
