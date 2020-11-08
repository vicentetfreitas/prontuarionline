package com.vicente.apiprontuarionline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vicente.apiprontuarionline.model.DocumentoIdentificacao;

@Repository
public interface DocumentoIdentificacaoRepository extends JpaRepository<DocumentoIdentificacao, Long>{

}
