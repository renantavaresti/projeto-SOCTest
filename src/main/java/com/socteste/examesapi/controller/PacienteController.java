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

import com.socteste.examesapi.dto.PacienteDTO;
import com.socteste.examesapi.model.Paciente;
import com.socteste.examesapi.service.PacienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Exames")
@CrossOrigin(origins="*") /*Qualquer dominio pode acessar essa API*/
public class PacienteController {

	@Autowired
	private PacienteService pc;

	@GetMapping("/paciente")
	@ApiOperation(value="Retorna uma lista de Pacientes")
	public List<Paciente> listarTodosPacientes() {
		return pc.listarPaciente();
	}

	@GetMapping("/paciente/{id}")
	@ApiOperation(value="Retorna um unico Paciente")
	public Paciente listarUnicoPaciente(@PathVariable(value = "id") String id) {
		return pc.listarUnicoPaciente(id);
	}

	@PostMapping("/paciente")
	@ApiOperation(value="Cadastra um Paciente")
	public ResponseEntity<String> cadastarPaciente(@RequestBody PacienteDTO pacDTO) {
		return pc.cadastrarPaciente(pacDTO);
	}

	@PutMapping("/paciente")
	@ApiOperation(value="Atualiza um Paciente")
	public ResponseEntity<String> atualizarPaciente(@RequestBody Paciente paciente) {
		return pc.atualizarPaciente(paciente);
	}

	@DeleteMapping("/paciente/{id}")
	@ApiOperation(value="Deleta um Paciente")
	public ResponseEntity<String> deletarPaciente(@PathVariable(value = "id") String id) {
		return pc.deletarPaciente(id);
	}

}
