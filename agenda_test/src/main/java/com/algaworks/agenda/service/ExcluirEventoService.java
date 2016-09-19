package com.algaworks.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.agenda.model.Evento;
import com.algaworks.agenda.repository.Eventos;

@Service
public class ExcluirEventoService {
	@Autowired
	private Eventos eventos;
	
	public void excluir(Long codigo){
		if (codigo != null)
			this.eventos.delete(codigo);
	}
}
