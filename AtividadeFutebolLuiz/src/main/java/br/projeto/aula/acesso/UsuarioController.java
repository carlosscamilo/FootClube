package br.projeto.aula.acesso;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuariodao;
	
	@PostMapping("/efetuarCadUs")
	public String efetuarCadUsuario(Usuario usuario) {
		this.usuariodao.save(usuario);
		System.out.println(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/cadastrar_usuario")
	public String cadastus() {
		return "CadUsu";
	}
	
	@GetMapping("/")
	public String exibirIndex(Usuario usuario) {
		return "index";
	}
	
	@PostMapping("/efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session, RedirectAttributes ra) {
		
		Usuario usuarioConsultado = this.usuariodao.findByEmail(usuario.getEmail());
		
		if (usuario != null && usuario.getSenha().equals(usuarioConsultado.getSenha())) {
			session.setAttribute("UsuarioLogado", usuario);
			return "redirect:/paginas";
		} else {
			
			ra.addFlashAttribute("mensagem", "login/senha invalidos");
			return "redirect:/";
		}
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session, Usuario usuario) {
		session.invalidate();
		System.out.println(usuario);
		return "redirect:/";
	}
	
	@PostMapping("/efeus")
	public String efetucaus(Usuario usuario) {
		this.usuariodao.save(usuario);
		System.out.println(usuario);
		return "index";
	}
	
}
