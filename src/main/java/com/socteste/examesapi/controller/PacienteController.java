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

import com.socteste.examesapi.model.Paciente;
import com.socteste.examesapi.service.PacienteService;

@RestController
@RequestMapping(value="pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteService pc;
	
	@CrossOrigin
	@GetMapping
	public List<Paciente> listarTodosPacientes(){
		return pc.listarPaciente();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Paciente listarUnicoPaciente(@PathVariable(value = "id") String id) {
		return pc.listarUnicoPaciente(id);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> cadastarPaciente(@RequestBody Paciente paciente){
		return pc.cadastrarPaciente(paciente);
	}
	
	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> atualizarPaciente(@RequestBody Paciente paciente){
		return pc.atualizarPaciente(paciente);
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarPaciente(@PathVariable(value="id") String id){
		return pc.deletarPaciente(id);
	}
	
}
