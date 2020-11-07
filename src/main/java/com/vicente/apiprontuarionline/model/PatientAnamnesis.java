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
@Table(name = "tb_patient_anamnesis")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PatientAnamnesis implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private Boolean smoker;
	private Boolean consumeAlcohol;
	private Boolean performsPhysicalActivity;
	private Boolean followDiet;
	private Boolean allergies;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@OneToOne(mappedBy = "patientAnamnesis")
	private Patient patient;

	// CONSTRUTORES
	public PatientAnamnesis(Long id, Boolean smoker, Boolean consumeAlcohol, Boolean performsPhysicalActivity,
			Boolean followDiet, Boolean allergies, Patient patient) {
		super();
		this.id = id;
		this.smoker = smoker;
		this.consumeAlcohol = consumeAlcohol;
		this.performsPhysicalActivity = performsPhysicalActivity;
		this.followDiet = followDiet;
		this.allergies = allergies;
		this.patient = patient;
	}

}
