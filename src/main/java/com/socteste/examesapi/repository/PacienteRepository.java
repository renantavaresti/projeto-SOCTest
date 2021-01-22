package com.socteste.examesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socteste.examesapi.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, String> {

}
