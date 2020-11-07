package com.vicente.apiprontuarionline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vicente.apiprontuarionline.model.PatientAnamnesis;

@Repository
public interface PatientAnamnesisRepository extends JpaRepository<PatientAnamnesis, Long> {

}
