package br.projeto.aula.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String CadJog(Model model){
		
		model.addAttribute("list_time",
				this.timedao.findAll(Sort.by("id")));
		return "CadJogad";
	}
	
	@PostMapping("/efetuJogCa")
	public String cadaJog(Jogador jogado){
		this.jogadordao.save(jogado);
		System.out.println(jogado);
		return "pag";
		
	}
	
	
}
