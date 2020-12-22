package br.projeto.aula.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.projeto.aula.acesso.Usuario;
import br.projeto.aula.classes.Tecnico;

public interface TecnicoDAO extends JpaRepository<Tecnico, Integer> {
	
	public List<Tecnico> findByUsuario(Usuario usuario);
	
	@Query("SELECT T.tecnico " +
		    " FROM Time T " +		
		    "WHERE T.id = ?1")
	public List<Tecnico> findByTimeId(Integer timeId);
	
	
	
	
}
