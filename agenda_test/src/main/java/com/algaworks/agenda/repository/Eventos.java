package com.algaworks.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.agenda.model.Evento;

public interface Eventos extends JpaRepository<Evento, Long>{

}