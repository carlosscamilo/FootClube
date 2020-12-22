package br.projeto.aula.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.aula.DAO.TecnicoDAO;
import br.projeto.aula.DAO.TimeDAO;
import br.projeto.aula.acesso.Usuario;
import br.projeto.aula.acesso.UsuarioDAO;
import br.projeto.aula.classes.Time;
import br.projeto.aula.classes.UF;

@Controller
public class TimeController {

	@Autowired
	private UsuarioDAO usuariodao;
	
	@Autowired
	private TimeDAO timedao;
	
	@Autowired
	private TecnicoDAO tecnicodao;
	
	@GetMapping("/cadastrar_time")
	public String CadTim(Model model,Time time){
		
		model.addAttribute("lista_tecn",
				this.tecnicodao.findAll(Sort.by("id")));
		
		return "CadTime";
	}
	
	@ModelAttribute("enum_uf")
	public UF[] getEnumUf(){
		return UF.values();
	}
	
	@PostMapping("/efetTimeca")
	public String cadastrTime(HttpSession session, Time time){
		Usuario usuario = (Usuario) session.getAttribute("UsuarioLogado");
//		System.out.println(usuario.getEmail());
		time.setUsuario(usuario);
		this.timedao.save(time);
		System.out.println(time);
		return "redirect:/paginas";
	}
	
	@GetMapping("/exibirtime")
	public String exibirtime(Integer id,Model model){
		Time tim = this.timedao.getOne(id);
		model.addAttribute("lista_tecn",
				this.tecnicodao.findAll(Sort.by("id")));
		model.addAttribute("time" , tim);
		return "CadTime";
	}

	@GetMapping("/excluirtime")
	public String excluirtime(Integer id) {
	this.timedao.deleteById(id);
	return "redirect:/paginas";
	}
}
