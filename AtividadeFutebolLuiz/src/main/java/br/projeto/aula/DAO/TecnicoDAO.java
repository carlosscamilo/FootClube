package br.projeto.aula.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.aula.classes.Tecnico;

public interface TecnicoDAO extends JpaRepository<Tecnico, Integer> {

}
