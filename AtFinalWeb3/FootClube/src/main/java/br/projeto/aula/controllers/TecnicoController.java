package br.projeto.aula.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.aula.DAO.TecnicoDAO;
import br.projeto.aula.acesso.Usuario;
import br.projeto.aula.classes.Tecnico;

@Controller
public class TecnicoController {

	@Autowired
	private TecnicoDAO tecnicodao;

	@GetMapping("/cadastrar_tecnico")
	public String CadTec(Tecnico tecnico) {
		return "CadTecn";
	}

	@PostMapping("/salvartecn")
	public String EfetuaCdatec(Tecnico tecnic, HttpSession session) {

		Usuario usuario = (Usuario) session.getAttribute("UsuarioLogado");

		tecnic.setUsuario(usuario);

		this.tecnicodao.save(tecnic);
		System.out.println(tecnic);
		return "redirect:/paginas";
	}

	@GetMapping("/exibirtecnico")
	public String exibirtecnico(Integer id, Model model) {
		Tecnico teni = this.tecnicodao.getOne(id);
		model.addAttribute("tecnico", teni);
		return "CadTecn";
	}

	@GetMapping("/excluirtecnico")
	public String excluirtecnico(Integer id) {
		this.tecnicodao.deleteById(id);
		return "redirect:/paginas";
	}
	
	//@GetMapping("/tecnico/findByTimeId/{timeId}")
//	public List<Tecnico> findByTi	meId(@PathVariable(value = "timeId")Integer timeId) {
		
	//}
	
	
}
