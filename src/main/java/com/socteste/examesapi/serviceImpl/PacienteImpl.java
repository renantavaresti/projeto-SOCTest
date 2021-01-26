package com.socteste.examesapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.socteste.examesapi.dto.PacienteDTO;
import com.socteste.examesapi.model.Paciente;
import com.socteste.examesapi.repository.PacienteRepository;
import com.socteste.examesapi.service.PacienteService;

@Service
public class PacienteImpl implements PacienteService {

	@Autowired
	PacienteRepository pc;

	@Override
	public List<Paciente> listarPaciente() {
		return pc.findAll();
	}

	@Override
	public Paciente listarUnicoPaciente(String id) {
		if (pc.existsById(id)) {
			return pc.findById(id).get();
		}
		return null;
	}

	@Override
	public ResponseEntity<String> cadastrarPaciente(PacienteDTO pacDTO) {
		if (!pc.existsById(pacDTO.getCpf())) {
			Paciente paciente = Paciente.builder()
					.cpf(pacDTO.getCpf())
					.nomePaciente(pacDTO.getNomePaciente())
					.build();
			pc.save(paciente);
			return ResponseEntity.ok("Paciente cadastrado com sucesso!");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("Paciente de CPF " + pacDTO.getCpf() + " já está cadastrado!");
		}
	}

	@Override
	public ResponseEntity<String> atualizarPaciente(Paciente paciente) {
		if (pc.existsById(paciente.getCpf())) {
			pc.save(paciente);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Paciente atualizado com sucesso!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não Foi possivel atualizar Paciente!");
	}

	@Override
	public ResponseEntity<String> deletarPaciente(String id) {
		if (pc.existsById(id)) {
			pc.deleteById(id);
			return ResponseEntity.ok("Paciente deletado com sucesso!");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível deletar Paciente!");
	}

}
