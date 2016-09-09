package com.algaworks.agenda.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "evento")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long idevento;
	
	@NotBlank(message = "Titulo é obrigatório")
	private String titulo;
	
	@NotBlank(message = "Descrição é obrigatório")
	private String descricao;
	
	@NotBlank(message = "Data é obrigatório")
	private Date data;
	
	//private Time hora; -> Qual library
	
	@NotNull(message = "Nome é obrigatório")
	@Enumerated(EnumType.STRING)
	private TipoEvento tipo;

	public Long getIdevento() {
		return idevento;
	}

	public void setIdevento(Long idevento) {
		this.idevento = idevento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
