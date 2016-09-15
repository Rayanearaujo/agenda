package com.algaworks.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.agenda.model.Evento;
import com.algaworks.agenda.model.TipoEvento;
import com.algaworks.agenda.repository.Eventos;
import com.algaworks.agenda.service.CadastroEventoService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	@Autowired
	private CadastroEventoService cadastroEventoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Evento evento) {
		ModelAndView mv = new ModelAndView("/agenda/CadastroEvento");
		mv.addObject("tipos", TipoEvento.values());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastarNovoEvento(Evento evento){
		cadastroEventoService.salvar(evento);
		return new ModelAndView("redirect:/agenda/novo");
		//return new ModelAndView();
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
