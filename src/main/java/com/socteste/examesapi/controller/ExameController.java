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

import com.socteste.examesapi.dto.ExameDTO;
import com.socteste.examesapi.model.Exame;
import com.socteste.examesapi.service.ExameService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Exames")
@CrossOrigin(origins="*") /*Qualquer dominio pode acessar essa API*/
public class ExameController {
	
	@Autowired
	private ExameService exameService;
		
	@GetMapping("/exames")
	@ApiOperation(value="Retorna uma lista de Exames")
	public List<Exame> listarTodosExames() {
		return exameService.listarExame();
	}

	@GetMapping("/exame/{id}")
	@ApiOperation(value="Retorna um unico Exame")
	public Exame listarUnicoExame(@PathVariable(value = "id") long id) {
		return exameService.listarUnicoExame(id);
	}

	@PostMapping("/exame")
	@ApiOperation(value="Cadastra um Exame")
	public ResponseEntity<String> cadastarExame(@RequestBody ExameDTO exame) {
		return exameService.cadastrarExame(exame);
	}

	@PutMapping("/exames")
	@ApiOperation(value="Atualiza um Exame")
	public ResponseEntity<String> atualizarExame(@RequestBody Exame exame) {
		return exameService.atualizarExame(exame);
	}

	@DeleteMapping("/exames/{id}")
	@ApiOperation(value="Deleta um Exame")
	public ResponseEntity<String> deletarExame(@PathVariable(value = "id") long id) {
		return exameService.deletarExame(id);
	}
}