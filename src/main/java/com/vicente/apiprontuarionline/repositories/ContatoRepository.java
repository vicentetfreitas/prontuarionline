package com.vicente.apiprontuarionline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vicente.apiprontuarionline.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
