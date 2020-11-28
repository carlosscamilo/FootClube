package br.projeto.aula.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TecnicoController {

	@Autowired
	private TecnicoDAO tecnicodao;
	
	@GetMapping("/cadastrar_tecnico")
	public String CadTec(){
		return "CadTecn";
	}
	
	@PostMapping("/salvartecn")
	public String EfetuaCdatec(Tecnico tecnic){
		this.tecnicodao.save(tecnic);
		System.out.println(tecnic);
		return "pag";
	}
}
