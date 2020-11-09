package com.vicente.apiprontuarionline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
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
@Table(name = "tb_contato")
@Getter
@Setter
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String email;
	private String telefoneFixo;
	private String telefoneCelular;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@JsonIgnore
	@ManyToMany(mappedBy = "contatos")
	private List<Paciente> pacientes = new ArrayList<>();

	// CONSTRUTORES
	public Contato() {
	}

	public Contato(Long id, String email, String telefoneFixo, String telefoneCelular) {
		super();
		this.id = id;
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
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
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
