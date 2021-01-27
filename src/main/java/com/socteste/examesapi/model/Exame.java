package com.socteste.examesapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@NoArgsConstructor /* Cria construtor vazio - lombok */
@AllArgsConstructor /* Cria construtor com todos os atributos */
@Getter
@Setter
@Table(name = "TB_EXAME")
public class Exame {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nomeExame;
	private String observacao;
	private String resultadoExame;
	private String cpf;
	private String nomePaciente;

}
