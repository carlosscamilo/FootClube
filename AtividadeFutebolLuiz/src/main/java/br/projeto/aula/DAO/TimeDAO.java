package br.projeto.aula.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.aula.classes.Time;

public interface TimeDAO extends JpaRepository<Time,Integer> {

}
