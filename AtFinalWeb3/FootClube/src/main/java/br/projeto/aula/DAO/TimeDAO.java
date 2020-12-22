package br.projeto.aula.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.aula.acesso.Usuario;
import br.projeto.aula.classes.Time;

public interface TimeDAO extends JpaRepository<Time,Integer> {
	List<Time> findByUsuario(Usuario usuario);
}
