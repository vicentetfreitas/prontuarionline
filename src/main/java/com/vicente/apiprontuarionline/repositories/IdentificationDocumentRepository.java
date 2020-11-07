package com.vicente.apiprontuarionline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vicente.apiprontuarionline.model.IdentificationDocument;

@Repository
public interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, Long>{

}
