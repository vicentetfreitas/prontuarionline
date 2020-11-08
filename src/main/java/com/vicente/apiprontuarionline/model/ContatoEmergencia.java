package com.vicente.apiprontuarionline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_emergencyContact")
@Getter
@Setter
public class ContatoEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String sobrenomeCompleto;
	private String rg;
	private String cpf;
	private String telefoneFixo;
	private String telefoneCelular;
	private String email;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@JsonIgnore
	@ManyToMany(mappedBy = "contatosEmergencia")
	private List<Paciente> pacientes = new ArrayList<>();

	// CONSTRUTORES
	public ContatoEmergencia() {
	}

	public ContatoEmergencia(Long id, String nome, String sobrenomeCompleto, String rg, String cpf, String telefoneFixo,
			String telefoneCelular, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenomeCompleto = sobrenomeCompleto;
		this.rg = rg;
		this.cpf = cpf;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.email = email;
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
		ContatoEmergencia other = (ContatoEmergencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
