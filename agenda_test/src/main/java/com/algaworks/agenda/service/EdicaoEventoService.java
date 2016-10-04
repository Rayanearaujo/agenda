package com.algaworks.agenda.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.algaworks.agenda.model.Evento;
import com.algaworks.agenda.repository.Eventos;

@Service
public class EdicaoEventoService {
	
	@Autowired
	private Eventos eventos;
	
	public void editar(Evento evento) {
		//this.eventos.findOne(evento.getIdevento()).setTitulo(evento.getTitulo());
		Evento oldEvent = this.eventos.findOne(evento.getIdevento());
		
		System.out.println("teste edicao service: " + 
				evento.getTitulo());
	
		System.out.println("Data evento " + 
				evento.getData());
		
		System.out.println("Data oldEvent " + 
				oldEvent.getData());
		
		evento.setData(oldEvent.getData());
		
		this.eventos.save(evento);
	}

}