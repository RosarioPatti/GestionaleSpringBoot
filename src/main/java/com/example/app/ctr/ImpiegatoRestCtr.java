package com.example.app.ctr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.Impiegato;
import com.example.app.service.ImpiegatoService;

@RestController
@RequestMapping("api/v1")
public class ImpiegatoRestCtr {

	private static final Logger LOG = LoggerFactory.getLogger(ImpiegatoRestCtr.class);

	@Autowired
	private ImpiegatoService impS;

	@GetMapping("/impiegati")
	public ResponseEntity<List<Impiegato>> get() {
		LOG.info("Call endpoint return all Employees");
		List<Impiegato> lsImpiegato = impS.getAll();

		return ResponseEntity.status(HttpStatus.OK).body(lsImpiegato);
	}

	@GetMapping("/impiegati/{matricola}")
	public ResponseEntity<Impiegato> getSingleEmployee(@PathVariable Integer matricola) {
		Impiegato resImp = impS.findByMatricola(matricola);
		return ResponseEntity.status(HttpStatus.OK).body(resImp);
	}

	@GetMapping("/impiegati/search1/{nome}")
	public ResponseEntity<List<Impiegato>> getListaByNome(@PathVariable String nome) {
		List<Impiegato> res = impS.ricercaPerNome(nome);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}

	@GetMapping("/impiegati/search2/{cognome}")
	public ResponseEntity<List<Impiegato>> getListaByCognome(@PathVariable String cognome) {
		List<Impiegato> res = impS.ricercaPerCognome(cognome);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
}
