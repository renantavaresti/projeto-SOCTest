package com.socteste.examesapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "TB_PACIENTE")
public class Paciente {

	@Id
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String nomePaciente;

	@OneToMany(mappedBy = "paciente")
	@JsonManagedReference
	private List<Exame> exames;
	
}
