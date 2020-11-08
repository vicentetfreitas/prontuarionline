package com.vicente.apiprontuarionline.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_patient_anamnesis_exam")
@Getter
@Setter
public class PacienteExameAnamnese implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@Column(name = "id")
	private Long id;
	private Boolean fuma;
	private Boolean alcool;
	private Boolean atividadeFisica;
	private Boolean dieta;
	private Boolean alergia;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@OneToOne
	@MapsId
	@JsonIgnore
	@JoinColumn(name = "paciente_id", nullable = true, insertable = true, updatable = true)
	private Paciente paciente;

	public PacienteExameAnamnese() {
	}

	public PacienteExameAnamnese(Long id, Boolean fuma, Boolean alcool, Boolean atividadeFisica, Boolean dieta,
			Boolean alergia) {
		super();
		this.id = id;
		this.fuma = fuma;
		this.alcool = alcool;
		this.atividadeFisica = atividadeFisica;
		this.dieta = dieta;
		this.alergia = alergia;
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
		PacienteExameAnamnese other = (PacienteExameAnamnese) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
