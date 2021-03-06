package com.vicente.apiprontuarionline.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_identification_document")
@Getter
@Setter
public class DocumentoIdentificacao implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rg;
	private String cpf;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@OneToOne
	@JoinColumn(name = "id_paciente", referencedColumnName = "id")
	@JsonIgnore
	private Paciente paciente;

	// CONSTRUTORES
	public DocumentoIdentificacao() {
	}

	public DocumentoIdentificacao(Long id, String rg, String cpf) {
		super();
		this.id = id;
		this.rg = rg;
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoIdentificacao other = (DocumentoIdentificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
