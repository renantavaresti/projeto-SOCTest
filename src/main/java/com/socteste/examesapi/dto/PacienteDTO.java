package com.socteste.examesapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteDTO {
	private Long id;
	private String nomePaciente;
}
