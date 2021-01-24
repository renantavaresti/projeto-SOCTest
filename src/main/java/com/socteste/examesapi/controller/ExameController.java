package com.socteste.examesapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socteste.examesapi.model.Exame;
import com.socteste.examesapi.service.ExameService;

@RestController
@RequestMapping(value = "/exames")
public class ExameController {

	@Autowired
	private ExameService ex;

	@CrossOrigin
	@GetMapping
	public List<Exame> listarTodosExames() {
		return ex.listarExame();
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public Exame listarUnicoExame(@PathVariable(value = "id") Long id) {
		return ex.listarUnicoExame(id);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> cadastarExame(@RequestBody Exame exame) {
		return ex.cadastrarExame(exame);
	}

	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> atualizarExame(@RequestBody Exame exame) {
		return ex.atualizarExame(exame);
	}

	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarExame(@PathVariable(value = "id") Long id) {
		return ex.deletarExame(id);
	}

}