package com.algaworks.agenda.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.agenda.model.Evento;
import com.algaworks.agenda.model.TipoEvento;
import com.algaworks.agenda.model.Usuario;
import com.algaworks.agenda.repository.Eventos;
import com.algaworks.agenda.service.CadastroEventoService;
import com.algaworks.agenda.service.CadastroUsuarioService;
import com.algaworks.agenda.service.EdicaoEventoService;
import com.algaworks.agenda.service.ExcluirEventoService;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	@Autowired
	private CadastroEventoService cadastroEventoService;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private ExcluirEventoService excluirEventoService;
	
	@Autowired
	private EdicaoEventoService edicaoEventoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Evento evento) {
		ModelAndView mv = new ModelAndView("/agenda/CadastroEvento");
		mv.addObject("tipos", TipoEvento.values());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
    public ModelAndView cadastrarEvento(@Valid Evento evento, BindingResult bindingResult, RedirectAttributes attributes)  {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = (Date) format.parse(evento.getData()+"");
		evento.setData(parsed);
		if(evento != null)
		System.out.println("***************** cadastrar evento. Título: "+ evento.getTitulo() + "***************** \n");
		System.out.println("***************** cadastrar evento. Data: "+ evento.getData() + "***************** \n");
		System.out.println("***************** cadastrar evento. Hora: "+ evento.getHoraevento() + "*****************");*/
		
		
		if(bindingResult.hasErrors())
			return novo(evento);
		
		cadastroEventoService.salvar(evento);
		attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso!");
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
	public ModelAndView pesquisa(Evento evento) {		
		ModelAndView mv = new ModelAndView("/agenda/PesquisaEventos");
		mv.addObject("eventos", eventos.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/consulta", method = RequestMethod.POST)
	public ModelAndView fazerPesquisa(@Valid Evento evento, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("/agenda/PesquisaEventos");
		List<Evento> todosEventos = eventos.findAll();
		List<Evento> eventosResultado = new ArrayList<Evento>();
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		
		for(int i = 0; i < todosEventos.size(); i++){
			
			if((evento.getTitulo() != null) && (!evento.getTitulo().equals(""))){
				if((evento.getTipo() != null) && (!evento.getTipo().getDescricao().equals(""))){
					if(evento.getData() != null){
						//System.out.println("*********** consultar por titulo, tipo e data ***********");						
						String eventDataFormatted = sdf.format(evento.getData());
						String todosEventosDataFormatted = sdf.format(todosEventos.get(i).getData());
						
						if((todosEventos.get(i).getTitulo().equals(evento.getTitulo()))
								&&(todosEventos.get(i).getTipo().getDescricao()
										.equals(evento.getTipo().getDescricao()))
								&& (eventDataFormatted.equals(todosEventosDataFormatted))){
							eventosResultado.add(todosEventos.get(i));
						}
					}
					else{
						//System.out.println("*********** consultar por titulo e tipo ***********");
						if((todosEventos.get(i).getTitulo().equals(evento.getTitulo()))
								&&(todosEventos.get(i).getTipo().getDescricao()
										.equals(evento.getTipo().getDescricao()))){
							eventosResultado.add(todosEventos.get(i));
						}
					}
				}
				else{
					if(evento.getData() != null){
						//System.out.println("*********** consultar por titulo e data ***********");
						String eventDataFormatted = sdf.format(evento.getData());
						String todosEventosDataFormatted = sdf.format(todosEventos.get(i).getData());
						
						if((todosEventos.get(i).getTitulo().equals(evento.getTitulo()))
								&& (eventDataFormatted.equals(todosEventosDataFormatted))){
							eventosResultado.add(todosEventos.get(i));
						}
					}
					else{
						//System.out.println("*********** consultar por titulo ***********");
						if(todosEventos.get(i).getTitulo().equals(evento.getTitulo())){
							eventosResultado.add(todosEventos.get(i));
						}
					}
				}
			}
			else{
				if((evento.getTipo() != null) && (!evento.getTipo().getDescricao().equals(""))){
					if(evento.getData() != null){
						String eventDataFormatted = sdf.format(evento.getData());
						String todosEventosDataFormatted = sdf.format(todosEventos.get(i).getData());
						
						if((todosEventos.get(i).getTipo().getDescricao().equals(evento.getTipo().getDescricao()))
								&& (eventDataFormatted.equals(todosEventosDataFormatted))){
							//System.out.println("*********** consultar por tipo e data***********");
							eventosResultado.add(todosEventos.get(i));	
						}
					}
					else{
						if(todosEventos.get(i).getTipo().getDescricao().equals(evento.getTipo().getDescricao())){
							//System.out.println("*********** consultar por tipo ***********");
							eventosResultado.add(todosEventos.get(i));
							
						}
					}
				}
				else{
					if(evento.getData() != null){
						
						//System.out.println("*********** consultar por data ***********");
						
						String eventDataFormatted = sdf.format(evento.getData());
						String todosEventosDataFormatted = sdf.format(todosEventos.get(i).getData());
						
						if(eventDataFormatted.equals(todosEventosDataFormatted)){
							eventosResultado.add(todosEventos.get(i));
						}
					}
					else{
						//System.out.println("*********** não consultar ***********");
						return new ModelAndView ("redirect:/agenda/consulta");
					}
				}
			}
		}
		
		mv.addObject("eventos", eventosResultado);
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView vizualizarEvento(@PathVariable Long codigo){
		ModelAndView mv = new ModelAndView("/agenda/VizualizacaoEvento");
		Evento evento = eventos.findOne(codigo);
		mv.addObject("evento", evento);
		return mv;
	}
	
	
	
	@RequestMapping(value = "/excluir/{codigo}")
	public ModelAndView deletarEvento(@PathVariable Long codigo){
		
		excluirEventoService.excluir(codigo);
		
		return new ModelAndView("redirect:/agenda/consulta");
	}
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public ModelAndView editarEvento(@Valid Evento evento, BindingResult bindingResult){
		edicaoEventoService.editar(evento);
		return new ModelAndView("redirect:/agenda/{codigo}");
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
	public ModelAndView excluir(Evento eventoselected) {
		System.out.println("******** excluir evento" + eventoselected.getDescricao() + "********");
		
		//if(evento != null)
			//excluirEventoService.excluir(evento);
	
		return new ModelAndView ("redirect:/agenda/consulta");
		
	}
	
	@RequestMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("/agenda/index");
		mv.addObject("eventos", eventos.findAll());
		return mv;
	}
	
}
