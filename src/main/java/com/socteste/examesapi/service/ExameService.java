package com.socteste.examesapi.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.socteste.examesapi.dto.ExameDTO;
import com.socteste.examesapi.model.Exame;

public interface ExameService {

	List<Exame> listarExame();
	Exame listarUnicoExame(Long id);
	ResponseEntity<String> cadastrarExame(@RequestBody ExameDTO exDTO);
	ResponseEntity<String> atualizarExame(@RequestBody Exame exame);
	ResponseEntity<String> deletarExame(Long id);
}
