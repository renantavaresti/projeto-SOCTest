package com.socteste.examesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor //Cria construtor vazio - lombok
@AllArgsConstructor //Cria construtor com todos os atributos
@Table(name ="TB_EXAME")
public class Exame {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter private Long id;
	
	@Column(nullable = false)
	@Getter @Setter private String nomeExame;
	@Getter @Setter private String observacao;
	@Getter @Setter private String resultadoExame;
	
}
