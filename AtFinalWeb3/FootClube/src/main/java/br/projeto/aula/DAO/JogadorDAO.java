package br.projeto.aula.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.projeto.aula.acesso.Usuario;
import br.projeto.aula.classes.Jogador;

public interface JogadorDAO extends JpaRepository<Jogador, Integer>{
	
	
	
	@Query(value = "select * from jogador", nativeQuery = true)
	List<Jogador> listaJogadorGols();
	List<Jogador> findByUsuario(Usuario usuario);
	List<Jogador> findByTimeId(Integer timeId);
}
