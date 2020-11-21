package br.projeto.aula.classes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario , Integer> {

}
