package com.algaworks.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.agenda.repository.Eventos;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

	@RequestMapping("/novo")
	public String novo() {
		return "/agenda/CadastroEvento";
	}
	
	@Autowired
	private Eventos eventos;
	
	@RequestMapping("/consulta")
	public ModelAndView pesquisa() {		
		ModelAndView mv = new ModelAndView("/agenda/PesquisaEventos");
		mv.addObject("eventos", eventos.findAll());
		return mv;
	}
		
	@RequestMapping("/login")
	public String login() {
		return "/agenda/Login";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "/agenda/Cadastro";
	}
	
	@RequestMapping
	public String home() {
		return "/agenda/index";
	}
	
}
