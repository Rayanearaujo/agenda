package com.algaworks.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.agenda.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long>{

}
