package com.vicente.apiprontuarionline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vicente.apiprontuarionline.model.EmergencyContact;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Long> {

}
