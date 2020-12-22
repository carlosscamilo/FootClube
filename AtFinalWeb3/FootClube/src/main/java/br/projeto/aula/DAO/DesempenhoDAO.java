package br.projeto.aula.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.aula.classes.Desempenho;

public interface DesempenhoDAO extends JpaRepository<Desempenho , Integer > {
	List<Desempenho> findByGols(Integer gols);
	
}
