package com.algaworks.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.agenda.model.Evento;
import com.algaworks.agenda.repository.Eventos;

@Service
public class EdicaoEventoService {
	
	@Autowired
	private Eventos eventos;
	
	public void editar(Evento evento){
		this.eventos.findOne(evento.getIdevento())
		.setTitulo(evento.getTitulo());
		System.out.println("teste edicao service: " + 
		evento.getTitulo() + " " + evento.getIdevento());
		
	}

}