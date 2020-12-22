package br.projeto.aula.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.aula.DAO.DesempenhoDAO;
import br.projeto.aula.DAO.JogadorDAO;
import br.projeto.aula.classes.Desempenho;

@Controller
public class DesempenhoController {

	@Autowired
	private DesempenhoDAO desempenhodao;
	
	@Autowired
	private JogadorDAO jogadordao;
	
	@GetMapping("/cadastrar_desempenho")
	public String caDes(Model model) {
		model.addAttribute("lista_jog",
				this.jogadordao.findAll(Sort.by("id"))
				);
		return "CadDes";
	}
	@PostMapping("/EfetDes")
	public String efdes(Desempenho des){
		this.desempenhodao.save(des);
		System.out.println(des);
		return "pag";
	}
}
