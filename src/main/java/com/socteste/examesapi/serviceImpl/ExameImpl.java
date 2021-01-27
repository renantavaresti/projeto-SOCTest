package com.socteste.examesapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.socteste.examesapi.dto.ExameDTO;
import com.socteste.examesapi.model.Exame;
import com.socteste.examesapi.repository.ExameRepository;
import com.socteste.examesapi.repository.PacienteRepository;
import com.socteste.examesapi.service.ExameService;

@Service
public class ExameImpl implements ExameService {

	@Autowired
	ExameRepository exameRepository;

//	@Autowired
//	PacienteRepository pc;

	public List<Exame> listarExame() {
		return exameRepository.findAll();
	}

	@Override
	public Exame listarUnicoExame(Long id) {
		if (exameRepository.existsById(id)) {
			return exameRepository.findById(id).get();
		}
		return null;
	}

	public ResponseEntity<String> cadastrarExame(@RequestBody ExameDTO exame) {
		Exame exam = Exame.builder().nomeExame(exame.getNomeExame())
				.observacao(exame.getObservacao())
				.resultadoExame(exame.getResultadoExame())
				.cpf(exame.getCpf())
				.nomePaciente(exame.getNomePaciente())
				.build();
		exameRepository.save(exam);
		return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com Sucesso!");
	}

	@Override
	public ResponseEntity<String> atualizarExame(@RequestBody Exame exame) {
		if(exameRepository.existsById(exame.getId())) {
			exameRepository.save(exame);
			return ResponseEntity.status(HttpStatus.OK).body("Exame atualizado com sucesso!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível atualizar exame!!");
	}
		

	@Override
	public ResponseEntity<String> deletarExame(Long id) {
		if (!exameRepository.existsById(id)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exame não encontrado!");
		}
		exameRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso!!!");
	}
}