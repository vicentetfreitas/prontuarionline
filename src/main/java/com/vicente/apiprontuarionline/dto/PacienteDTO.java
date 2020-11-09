package com.vicente.apiprontuarionline.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vicente.apiprontuarionline.model.Paciente;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String sobrenomeCompleto;
	private String sexo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;

	// CONSTRUTORES
	public PacienteDTO() {
	}

	public PacienteDTO(Paciente objPaciente) {

		id = objPaciente.getId();
		nome = objPaciente.getNome();
		sobrenomeCompleto = objPaciente.getSobrenomeCompleto();
		sexo = objPaciente.getSexo();
		dataNascimento = objPaciente.getDataNascimento();
	}

	public PacienteDTO(Long id, String nome, String sobrenomeCompleto, String sexo, Date dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenomeCompleto = sobrenomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
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
		PacienteDTO other = (PacienteDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
