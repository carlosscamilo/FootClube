package br.projeto.aula.classes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
	private LocalDate datanas;
	
	private Double salario;
	
	@OneToOne
	private Time time;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "dados_id")
	private DadosCorporais dadosCorporais;
	
	@OneToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "desempenho_id")
	private Desempenho desempenho;
	
	public Desempenho getDesempenho() {
		return desempenho;
	}
	public void setDesempenho(Desempenho desempenho) {
		this.desempenho = desempenho;
	}
	public DadosCorporais getDadosCorporais() {
		return dadosCorporais;
	}
	public void setDadosCorporais(DadosCorporais dadosCorporais) {
		this.dadosCorporais = dadosCorporais;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDatanas() {
		return datanas;
	}
	public void setDatanas(LocalDate datanas) {
		this.datanas = datanas;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
}
