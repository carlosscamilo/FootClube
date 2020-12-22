package br.projeto.aula.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.projeto.aula.DAO.JogadorDAO;
import br.projeto.aula.DAO.TecnicoDAO;
import br.projeto.aula.DAO.TimeDAO;
import br.projeto.aula.acesso.Usuario;
import br.projeto.aula.acesso.UsuarioDAO;
import br.projeto.aula.classes.Jogador;
import br.projeto.aula.classes.Tecnico;
import br.projeto.aula.classes.Time;

@Controller
public class PaginasController {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private TimeDAO timedao;

	@Autowired
	private JogadorDAO jogadordao;

	@Autowired
	private TecnicoDAO tecnicodao;

	@GetMapping("/paginas")
	public String navpag(Model model, HttpSession session, Time time) {

		Usuario usuario = (Usuario) session.getAttribute("UsuarioLogado");

		// Se tiver algum time selecionado a consulta vai ser find by time

		if (time == null || time.getId() == null) {
			model.addAttribute("totalTimes", this.timedao.findByUsuario(usuario).size());
			model.addAttribute("totalJogadores", this.jogadordao.findByUsuario(usuario).size());
			model.addAttribute("totalTecnicos", this.tecnicodao.findByUsuario(usuario).size());
		} else {
			model.addAttribute("totalTimes", this.timedao.findByUsuario(usuario).size());
			model.addAttribute("totalJogadores", this.jogadordao.findByTimeId(time.getId()).size());
			model.addAttribute("totalTecnicos", this.tecnicodao.findByTimeId(time.getId()).size());

		}
		
		
		List<Jogador> listaGols = new ArrayList<Jogador>();

		int size = jogadordao.listaJogadorGols().size();
		
		listaGols = jogadordao.findByTimeId(time.getId());
		
		String dados = "";
		
		String dadosGols = ""; 
		
		for (Jogador l : listaGols) {
			
			  dados += ("" + l.getNome() + ", ");  
			  dadosGols += ("" + l.getDesempenho().getGols() + ", ");  
			  
	          System.out.println(dados);
	          
	      }
		
		
		
		model.addAttribute("dados", dados);
		model.addAttribute("gols", dadosGols);
		
		
		
		List<Time> timeTodos = new ArrayList<Time>();
		Time todos = new Time();
		todos.setId(0);
		todos.setNome("TODOS");

		timeTodos.add(todos);
		timeTodos.addAll(this.timedao.findByUsuario(usuario));

		model.addAttribute("times", timeTodos);
		
		

		return "pag";

	}

	@GetMapping("/editab")
	public String navtab() {
		return "editarTabela";
	}

	@GetMapping("/tabste")
	public String vertabtec(Model model) {
		// Jogador jog = (Jogador)
		// this.jogadordao.findAll(Sort.by("nome")).get(0).getTime().getNome();
		// System.out.println("Meu time e " +
		// this.jogadordao.findAll(Sort.by("nome")).get(0).getTime().getNome());
		model.addAttribute("tecnicos", this.tecnicodao.findAll(Sort.by("nome")));
		return "tabsTecnico";
	}

	@GetMapping("/tabsjo")
	public String vertabjog(Model model) {
		model.addAttribute("jogadores", this.jogadordao.findAll(Sort.by("nome")));
		return "tabsJogador";
	}

	@GetMapping("/tabstim")
	public String vertabtim(Model model) {
		model.addAttribute("times", this.timedao.findAll(Sort.by("nome")));
		return "tabsTime";
	}
}
