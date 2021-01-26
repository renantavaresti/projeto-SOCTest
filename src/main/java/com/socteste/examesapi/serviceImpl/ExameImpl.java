package com.socteste.examesapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.socteste.examesapi.model.Exame;
import com.socteste.examesapi.repository.ExameRepository;
import com.socteste.examesapi.service.ExameService;

@Service
public class ExameImpl implements ExameService {

	@Autowired
	ExameRepository ex;

	@Override
	public List<Exame> listarExame() {
		return ex.findAll();
	}

	@Override
	public Exame listarUnicoExame(Long id) {
		if (ex.existsById(id)) {
			return ex.findById(id).get();
		}
		return null;
	}

	@Override
	public ResponseEntity<String> cadastrarExame(Exame exame) {
		if (ex.existsById(exame.getId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Exame cod. " + exame.getId() + " já está cadastrado!");
		}
		ex.save(exame);
		return ResponseEntity.ok("Exame cadastrado com sucesso!");
	}

	@Override
	public ResponseEntity<String> atualizarExame(Exame exame) {
		if (ex.existsById(exame.getId())) {
			ex.save(exame);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Exame atualizado com sucesso!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não Foi possivel atualizar Exame!");
	}

	@Override
	public ResponseEntity<String> deletarExame(Long id) {
		if (ex.existsById(id)) {
			ex.deleteById(id);
			return ResponseEntity.ok("Exame deletado com sucesso!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível deletar Exame!");
	}
}
