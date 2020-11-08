package com.vicente.apiprontuarionline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vicente.apiprontuarionline.model.PacienteEstadoFisico;

@Repository
public interface PacienteEstadoFisicoRepository extends JpaRepository<PacienteEstadoFisico, Long> {

}
