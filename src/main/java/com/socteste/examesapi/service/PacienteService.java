package com.socteste.examesapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.socteste.examesapi.model.Paciente;

public interface PacienteService {
	
	List<Paciente> listarPaciente();
	Paciente listarUnicoPaciente(String id);
	ResponseEntity<String> cadastrarPaciente(@RequestBody Paciente paciente);
	ResponseEntity<String> atualizarPaciente(@RequestBody Paciente paciente);
	ResponseEntity<String> deletarPaciente(String id);
	
}
