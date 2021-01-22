package com.socteste.examesapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter 
@Builder
@NoArgsConstructor //Cria construtor vazio - lombok
@AllArgsConstructor //Cria construtor com todos os atributos
@Table(name ="TB_PACIENTE")
public class Paciente {

	@Id
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String nomePaciente;


}
