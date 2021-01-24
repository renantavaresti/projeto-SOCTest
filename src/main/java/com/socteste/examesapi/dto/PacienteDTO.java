package com.socteste.examesapi.dto;

import lombok.Builder;
import lombok.Data;

@Data /*
		 * Anotação para gerar automaticamente os métodos getters, setters, equals,
		 * hashCode e o toString
		 */
@Builder /* Utiliza o Padrão Builder na classe */
public class PacienteDTO {
	private Long id;
	private String nomePaciente;
}
