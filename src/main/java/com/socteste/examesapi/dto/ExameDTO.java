package com.socteste.examesapi.dto;

import lombok.Builder;
import lombok.Data;

@Data /*
		 * Anotação para gerar automaticamente os métodos getters, setters, equals,
		 * hashCode e o toString
		 */
@Builder /* Utiliza o Padrão Builder na classe */
public class ExameDTO {
	
	private Long id;
	private String nomeExame;
	private String observacao;
	private String resultadoExame;
	private String cpf;
	
	public ExameDTO(Long id, String nomeExame, String observacao, String resultadoExame, String cpf) {
		super();
		this.id = id;
		this.nomeExame = nomeExame;
		this.observacao = observacao;
		this.resultadoExame = resultadoExame;
		this.cpf = cpf;
	}
}
