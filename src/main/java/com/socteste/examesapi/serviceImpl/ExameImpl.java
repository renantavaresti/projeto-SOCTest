package com.socteste.examesapi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.socteste.examesapi.dto.ExameDTO;
import com.socteste.examesapi.model.Exame;
import com.socteste.examesapi.model.Paciente;
import com.socteste.examesapi.repository.ExameRepository;
import com.socteste.examesapi.repository.PacienteRepository;
import com.socteste.examesapi.service.ExameService;

@Service
public class ExameImpl implements ExameService {

	@Autowired
	ExameRepository ex;

	@Autowired
	PacienteRepository pc;

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

	public ResponseEntity<String> cadastrarExame(@RequestBody ExameDTO exDTO) {
		if (ex.existsById(exDTO.getId())) {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Exame cod. " + exDTO.getId() + " já está cadastrado!");
		}
		Exame exame = Exame.builder()
				.id(exDTO.getId())
				.nomeExame(exDTO.getNomeExame())
				.observacao(exDTO.getObservacao())
				.resultadoExame(exDTO.getResultadoExame())
				.build();
		ex.save(exame);
		return ResponseEntity.status(HttpStatus.OK).body("Exame cadastrado com sucesso!!");
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
