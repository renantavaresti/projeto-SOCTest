package com.socteste.examesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socteste.examesapi.model.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {
}

