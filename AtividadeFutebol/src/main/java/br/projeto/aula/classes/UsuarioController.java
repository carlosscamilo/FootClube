package br.projeto.aula.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuariodao;
	
	@GetMapping("/cadastrar_usuario")
	public String cadastus() {
		return "CadUsu";
	}
	
	@PostMapping("/efeus")
	public String efetucaus(Usuario usuario) {
		this.usuariodao.save(usuario);
		System.out.println(usuario);
		return "index";
	}
	
}
