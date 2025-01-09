package com.example.app.service;

import java.util.List;

import com.example.app.model.Impiegato;

public interface ImpiegatoService {
	
	public List<Impiegato>ricercaPerNome(String nome);
	
	public List<Impiegato>ricercaPerCognome(String cognome);
	
	public List<Impiegato> getAll();

	public Impiegato findByMatricola(Integer matr);

	public Impiegato save(Impiegato i);
}
