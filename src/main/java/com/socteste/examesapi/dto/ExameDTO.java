package com.socteste.examesapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExameDTO {
	private Long id;
	private String nomeExame;
	private String observacao;
	private String resultadoExame;
}
