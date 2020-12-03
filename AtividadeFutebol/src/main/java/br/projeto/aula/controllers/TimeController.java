package br.projeto.aula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.aula.DAO.TecnicoDAO;
import br.projeto.aula.DAO.TimeDAO;
import br.projeto.aula.classes.Time;
import br.projeto.aula.classes.UF;

@Controller
public class TimeController {

	@Autowired
	private TimeDAO timedao;
	
	@Autowired
	private TecnicoDAO tecnicodao;
	
	@GetMapping("/cadastrar_time")
	public String CadTim(Model model){
		
		model.addAttribute("lista_tecn",
				this.tecnicodao.findAll(Sort.by("id")));
		
		return "CadTime";
	}
	
	@ModelAttribute("enum_uf")
	public UF[] getEnumUf(){
		return UF.values();
	}
	
	@PostMapping("/efetTimeca")
	public String cadastrTime(Time time){
		this.timedao.save(time);
		System.out.println(time);
		return "pag";
	}
}
