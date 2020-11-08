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
@Table(name = "tb_patient_physical_state")
@Getter
@Setter
public class PacienteEstadoFisico implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@Column(name = "id")
	private Long id;

	private Double peso;
	private Double altura;
	private String tipoSanquineo;
	private Double circuferenciaAbdominal;
	private Double imc;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@OneToOne
	@MapsId
	@JsonIgnore
	@JoinColumn(name = "patient_id", nullable = true, insertable = true, updatable = true)
	private Paciente paciente;

	public PacienteEstadoFisico() {
	}

	// CONSTRUTORES
	public PacienteEstadoFisico(Long id, Double peso, Double altura, String tipoSanquineo,
			Double circuferenciaAbdominal, Double imc) {
		super();
		this.id = id;
		this.peso = peso;
		this.altura = altura;
		this.tipoSanquineo = tipoSanquineo;
		this.circuferenciaAbdominal = circuferenciaAbdominal;
		this.imc = imc;
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
		PacienteEstadoFisico other = (PacienteEstadoFisico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
