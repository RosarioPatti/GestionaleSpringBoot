package com.example.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.model.Impiegato;
import com.example.app.repository.ImpiegatoRepository;

@Service
public class ImpiegatoServiceImpl implements ImpiegatoService {

	@Autowired
	private ImpiegatoRepository impRepo;

	@Override
	public List<Impiegato> getAll() {

		return impRepo.findAll();
	}

	@Override
	public Impiegato findByMatricola(Integer matr) {

		return impRepo.findByMatricola(matr);
	}

	@Override
	public Impiegato save(Impiegato i) {

		return impRepo.save(i);
	}

	@Override
	public List<Impiegato> ricercaPerNome(String nome) {
		List<Impiegato> res = new LinkedList<>();
		List<Impiegato> ls = getAll();
		for (Impiegato impiegato : ls) {
			if (nome.trim().equalsIgnoreCase(impiegato.getNome())) {
				res.add(impiegato);
			}
		}
		return res;
	}

	@Override
	public List<Impiegato> ricercaPerCognome(String cognome) {
		List<Impiegato> res = new LinkedList<>();
		List<Impiegato> ls = getAll();
		for (Impiegato impiegato : ls) {
			if (cognome.trim().equalsIgnoreCase(impiegato.getCognome())) {
				res.add(impiegato);
			}
		}
		return res;
	}

}
