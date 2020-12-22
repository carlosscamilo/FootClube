package br.projeto.aula.acesso;



import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioDAO extends JpaRepository<Usuario , Integer> {

	public Usuario findByEmail(String email);
	
	public Usuario findById(String id);
	
	
}
