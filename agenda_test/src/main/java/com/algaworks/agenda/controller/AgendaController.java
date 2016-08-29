package com.algaworks.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

	@RequestMapping("/novo")
	public String novo() {
		return "/agenda/CadastroEvento";
	}
	
	@RequestMapping("/consulta")
	public String pesquisa() {
		return "/agenda/PesquisaEventos";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/agenda/Login";
	}
	
	@RequestMapping
	public String home() {
		return "/agenda/Home";
	}
	
}
