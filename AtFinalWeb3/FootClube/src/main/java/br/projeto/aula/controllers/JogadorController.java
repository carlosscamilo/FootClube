package br.projeto.aula.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.projeto.aula.DAO.DadosCorporaisDAO;
import br.projeto.aula.DAO.DesempenhoDAO;
import br.projeto.aula.DAO.JogadorDAO;
import br.projeto.aula.DAO.TimeDAO;
import br.projeto.aula.acesso.Usuario;
import br.projeto.aula.classes.Jogador;

@Controller
public class JogadorController {

    @Autowired
	private JogadorDAO jogadordao;
    
    @Autowired
    private TimeDAO timedao;
	
    @Autowired
    private DadosCorporaisDAO dadosdao;
    
    @Autowired
    private DesempenhoDAO desdao;
    
	@GetMapping("/cadastra_jogador")
	public String CadJog(Model model, Jogador jogador){
		
		model.addAttribute("list_time",
				this.timedao.findAll(Sort.by("id")));
		return "CadJogad";
	}

	
	@PostMapping("/efetuJogCa")
	public String cadaJog(Jogador jogado, HttpSession session){
		
		
		Usuario usuario = (Usuario) session.getAttribute("UsuarioLogado");
		
		jogado.setUsuario(usuario);
		
		jogado.getDadosCorporais().setImc(jogado.getDadosCorporais().getPeso()/(jogado.getDadosCorporais().getAltura()*jogado.getDadosCorporais().getAltura()));
		this.jogadordao.save(jogado);
		System.out.println(jogado);
		return "redirect:/paginas";
		
	}
	
	@GetMapping("/exibirjogador")
	public String exibirjogador(Integer id,Model model){
		Jogador jog = this.jogadordao.getOne(id);
		System.out.println("o time e " + jog.getTime().getNome());
		model.addAttribute("list_time",
				this.timedao.findAll(Sort.by("id")));
		model.addAttribute("jogador" , jog);
		return "CadJogad";
	}

	@GetMapping("/excluirjogador")
	public String excluirjogador(Integer id) {
	this.jogadordao.deleteById(id);
	return "redirect:/paginas";
	}
	

	
}
