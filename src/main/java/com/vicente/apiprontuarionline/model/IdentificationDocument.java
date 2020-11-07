package com.vicente.apiprontuarionline.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_identification_document")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class IdentificationDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	private String rg;
	private String cpf;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@OneToOne
	@MapsId
	@JoinColumn(name = "patient_id")
	private Patient patient;

	// CONSTRUTORES
	public IdentificationDocument(Long id, String rg, String cpf, Patient patient) {
		super();
		this.id = id;
		this.rg = rg;
		this.cpf = cpf;
		this.patient = patient;
	}

}
