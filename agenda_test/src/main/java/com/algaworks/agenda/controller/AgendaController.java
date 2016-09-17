package com.algaworks.agenda.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.agenda.model.Evento;
import com.algaworks.agenda.model.TipoEvento;
import com.algaworks.agenda.model.Usuario;
import com.algaworks.agenda.repository.Eventos;
import com.algaworks.agenda.service.CadastroEventoService;
import com.algaworks.agenda.service.CadastroUsuarioService;
import com.algaworks.agenda.service.ExcluirEventoService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	@Autowired
	private CadastroEventoService cadastroEventoService;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	//@Autowired
	private ExcluirEventoService excluirEventoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Evento evento) {
		ModelAndView mv = new ModelAndView("/agenda/CadastroEvento");
		mv.addObject("tipos", TipoEvento.values());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView cadastrarEvento(@Valid Evento evento, BindingResult bindingResult)  {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = (Date) format.parse(evento.getData()+"");
		evento.setData(parsed);*/
		//if(evento != null)
		System.out.println("***************** cadastrar evento. Título: "+ evento.getTitulo() + "***************** \n");
		System.out.println("***************** cadastrar evento. Data: "+ evento.getData() + "***************** \n");
		System.out.println("***************** cadastrar evento. Hora: "+ evento.getHoraevento() + "*****************");
		
		
		if(bindingResult.hasErrors())
			return novo(evento);
		
		cadastroEventoService.salvar(evento);
		return new ModelAndView("redirect:/agenda/novo");
	}
	
	/*@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastarNovoEvento(Evento evento){
		cadastroEventoService.salvar(evento);
		return new ModelAndView("redirect:/agenda/novo");
		//return new ModelAndView();
	}*/
	
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
	public ModelAndView cadastro(Usuario usuario) {
		return new ModelAndView("/agenda/Cadastro");
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public ModelAndView cadastrarUsuario(@Valid Usuario usuario, BindingResult bindingResult){
		
		if(bindingResult.hasErrors())
			return cadastro(usuario);
		
		if (usuario != null){
			cadastroUsuarioService.salvar(usuario);
		}
		
		return new ModelAndView("redirect:/agenda/login");
	}

	@RequestMapping("/excluir")
	public ModelAndView excluir(Evento evento) {
		System.out.println("excluir evento "+ evento.getTitulo() + "*****************");
		
		if(evento != null)
			excluirEventoService.excluir(evento);
	
		return new ModelAndView ("redirect:/agenda/consulta");
		
	}
	
	@RequestMapping
	public String home() {
		return "/agenda/index";
	}
	
}
