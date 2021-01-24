package com.socteste.examesapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socteste.examesapi.model.Exame;

@RestController
@RequestMapping("/exames")
public class ExameController {

	@GetMapping
	public List<Exame> listar() {
		return null;
	}

}