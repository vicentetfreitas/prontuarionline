package com.vicente.apiprontuarionline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vicente.apiprontuarionline.model.PatientPhysicalState;

@Repository
public interface PatientPhysicalStateRepository extends JpaRepository<PatientPhysicalState, Long> {

}
