package com.vicente.apiprontuarionline.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_patient_physical_state")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientPhysicalState implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private Double weight;
	private Double height;
	private Double abdominalCircumference;
	private Double imc;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@OneToOne(mappedBy = "patientPhysicalState")
	private Patient patient;

	// CONSTRUTORES
	public PatientPhysicalState(Long id, Double weight, Double height, Double abdominalCircumference, Double imc,
			Patient patient) {
		super();
		this.id = id;
		this.weight = weight;
		this.height = height;
		this.abdominalCircumference = abdominalCircumference;
		this.imc = imc;
		this.patient = patient;
	}

}
