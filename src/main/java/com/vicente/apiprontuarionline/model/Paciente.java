package com.vicente.apiprontuarionline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_paciente")
@Getter
@Setter
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String nome;
	private String sobrenomeCompleto;
	private String sexo;
	private Date dataNascimento;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_pacientes_enderecos", joinColumns = @JoinColumn(name = "paciente_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> enderecos = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_paciente_contato", joinColumns = @JoinColumn(name = "paciente_id"), inverseJoinColumns = @JoinColumn(name = "contato_id"))
	private List<Contato> contatos = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_contato_emergencia", joinColumns = @JoinColumn(name = "paciente_id"), inverseJoinColumns = @JoinColumn(name = "contato_emergencia_id"))
	private List<ContatoEmergencia> contatosEmergencia = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
	@PrimaryKeyJoinColumn
	private DocumentoIdentificacao documentoIdentificacao;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
	@PrimaryKeyJoinColumn
	private PacienteEstadoFisico pacienteEstadoFisico;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
	@PrimaryKeyJoinColumn
	private PacienteExameAnamnese pacienteExameAnamnese;

	// CONSTRUTORES
	public Paciente() {
	}

	public Paciente(Long id, String nome, String sobrenomeCompleto, String sexo, Date dataNascimento) {
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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
