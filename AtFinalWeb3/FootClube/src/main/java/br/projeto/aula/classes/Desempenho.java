package br.projeto.aula.classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Desempenho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer chutes;
	
	private Integer gols;
	
	private Integer passesCertos;
	
	private Integer passesErrados;
	
	private Integer desarmes;
	
	private Integer faltasCometidas;
	
	private Integer faltasFeitas;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getChutes() {
		return chutes;
	}
	public void setChutes(Integer chutes) {
		this.chutes = chutes;
	}
	public Integer getGols() {
		return gols;
	}
	public void setGols(Integer gols) {
		this.gols = gols;
	}
	public Integer getPassesCertos() {
		return passesCertos;
	}
	public void setPassesCertos(Integer passesCertos) {
		this.passesCertos = passesCertos;
	}
	public Integer getPassesErrados() {
		return passesErrados;
	}
	public void setPassesErrados(Integer passesErrados) {
		this.passesErrados = passesErrados;
	}
	public Integer getDesarmes() {
		return desarmes;
	}
	public void setDesarmes(Integer desarmes) {
		this.desarmes = desarmes;
	}
	public Integer getFaltasCometidas() {
		return faltasCometidas;
	}
	public void setFaltasCometidas(Integer faltasCometidas) {
		this.faltasCometidas = faltasCometidas;
	}
	public Integer getFaltasFeitas() {
		return faltasFeitas;
	}
	public void setFaltasFeitas(Integer faltasFeitas) {
		this.faltasFeitas = faltasFeitas;
	}
}
