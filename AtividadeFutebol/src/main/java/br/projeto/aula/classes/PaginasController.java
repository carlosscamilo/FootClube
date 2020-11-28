package br.projeto.aula.classes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginasController {

	@GetMapping("/paginas")
	public String navpag(){
		return "pag";
	}
	
	@GetMapping("/editab")
	public String navtab(){
		return "editarTabela";
	}
	
	@GetMapping("/tabs")
	public String vertab(){
		return "tables";
	}
	
}
