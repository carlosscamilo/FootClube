package br.projeto.aula.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.aula.classes.Desempenho;

public interface DesempenhoDAO extends JpaRepository<Desempenho , Integer > {

}
