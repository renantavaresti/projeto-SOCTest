package com.socteste.examesapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socteste.examesapi.model.Paciente;

@RestController
@RequestMapping(value="pacientes")
public class PacienteController {
	
	@GetMapping
	public List<Paciente> listarTodosPacientes(){
		return null;
	}
	
}
