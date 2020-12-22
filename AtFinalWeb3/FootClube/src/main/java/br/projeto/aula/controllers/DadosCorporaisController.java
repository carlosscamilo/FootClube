package br.projeto.aula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.aula.DAO.DadosCorporaisDAO;
import br.projeto.aula.DAO.JogadorDAO;
import br.projeto.aula.classes.DadosCorporais;

@Controller
public class DadosCorporaisController {

	@Autowired
	private DadosCorporaisDAO dadsdao;
	
	@Autowired
	private JogadorDAO jogadordao;
	
	@GetMapping("/cadastrar_dados")
	public String cadDados(Model model) {
		model.addAttribute("lista_jooj",
				this.jogadordao.findAll(Sort.by("id")));
		return "CadDads";
	}
	
	@PostMapping("/cadDados")
	public String Efdads(DadosCorporais dads){
		this.dadsdao.save(dads);
		System.out.println(dads);
		return "pag";
	}
}
