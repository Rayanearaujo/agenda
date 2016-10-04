package com.algaworks.agenda.model;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	@NotNull(message = "Data é obrigatório")
	private Date data;
	
	private String localevento;
	
	private Time horaevento;
	
	//private Time hora; -> Qual library
	
	public String getLocalevento() {
		return localevento;
	}

	public void setLocalevento(String localevento) {
		this.localevento = localevento;
	}

	public Time getHoraevento() {
		return horaevento;
	}

	public void setHoraevento(Time horaevento) {
		this.horaevento = horaevento;
	}

	@NotNull(message = "Tipo é obrigatório")
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

	public String getDia() {
		//String.format("%02d/%02m/%04y", data.getDay(), data.getMonth(), data.getYear());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(data);

	}
	
	public void setDia(String data) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		this.data = (Date) format.parse(data);
	}
	
	public Date getData() {
		return data;

	}

	public void setData(String data) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		this.data = (Date) format.parse(data);
	}
	
	public void setData(Date data){
		this.data = data;
	}

	public TipoEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
