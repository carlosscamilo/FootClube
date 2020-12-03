package br.projeto.aula.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.projeto.aula.classes.DadosCorporais;

public interface DadosCorporaisDAO extends JpaRepository<DadosCorporais , Integer> {

}
