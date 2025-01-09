package com.example.app.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Impiegato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricola;

	@Column(name = "name")
	private String nome;

	@Column(name = "surname")
	private String cognome;

	public Impiegato() {

	}

	public Impiegato(Integer matricola, String nome, String cognome) {

		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		return "Impiegato [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

}
