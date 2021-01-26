package com.socteste.examesapi.dto;

import lombok.Builder;
import lombok.Data;

@Data /*
		 * Anotação para gerar automaticamente os métodos getters, setters, equals,
		 * hashCode e o toString
		 */
@Builder /* Utiliza o Padrão Builder na classe */
public class PacienteDTO {
	private String cpf;
	private String nomePaciente;
	private Long idExame;
	
	public PacienteDTO(String cpf, String nomePaciente, Long idExame) {
		super();
		this.cpf = cpf;
		this.nomePaciente = nomePaciente;
		this.idExame = idExame;
	}
}
