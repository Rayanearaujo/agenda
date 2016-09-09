package com.algaworks.agenda.model;

public enum TipoEvento {
	COMPROMISSO("Compromisso"), REUNIAO("reunião"),	
	ENTREVISTA("entrevista"), FESTA("festa"), 
	JANTAR("jantar"), LEMBRETE("lembrete"), 
	CONFERENCIA("conferência"), ANIVERSARIO("aniversário");
	

	private String descricao;
	
	TipoEvento(String descricao){
		this.descricao = descricao;		
	}
	
	public String getDescricao() {
		return descricao;
	}

}
