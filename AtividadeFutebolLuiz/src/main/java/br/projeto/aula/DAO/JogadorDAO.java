package br.projeto.aula.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.aula.classes.Jogador;

public interface JogadorDAO extends JpaRepository<Jogador, Integer>{

}
