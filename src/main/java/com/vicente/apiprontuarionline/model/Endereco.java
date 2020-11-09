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
@Table(name = "tb_endereco")
@Getter
@Setter
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String pais;
	private String estado;
	private String cidade;
	private String rua;
	private String numero;
	private String bairro;
	private String complemento;
	private String codigoPostal;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@JsonIgnore
	@ManyToMany(mappedBy = "enderecos")
	private List<Paciente> pacientes = new ArrayList<>();

	// CONSTRUTORES
	public Endereco() {
	}

	public Endereco(Long id, String pais, String estado, String cidade, String rua, String numero, String bairro,
			String complemento, String codigoPostal) {
		super();
		this.id = id;
		this.pais = pais;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.codigoPostal = codigoPostal;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
