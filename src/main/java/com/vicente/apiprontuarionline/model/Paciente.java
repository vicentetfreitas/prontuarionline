package com.vicente.apiprontuarionline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Paciente implements Serializable {
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

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pacientes_enderecos", joinColumns = @JoinColumn(name = "id_paciente"), inverseJoinColumns = @JoinColumn(name = "id_endereco"))
	private List<Endereco> enderecos = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_pacientes_contatos", joinColumns = @JoinColumn(name = "id_paciente"), inverseJoinColumns = @JoinColumn(name = "id_contato"))
	private List<Contato> contatos = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_pacientes_contatos_emergencias", joinColumns = @JoinColumn(name = "id_paciente"), inverseJoinColumns = @JoinColumn(name = "id_contato_emergencia"))
	private List<ContatoEmergencia> contatosEmergencias = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_documentoIdentificacao", referencedColumnName = "id")
	private DocumentoIdentificacao documentoIdentificacao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pacienteEstadoFisico", referencedColumnName = "id")
	private PacienteEstadoFisico pacienteEstadoFisico;

	@JoinColumn(name = "id_pacienteEstadoFisico", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "paciente")
	private PacienteExameAnamnese pacienteExameAnamnese;

	// CONSTRUTORES
	public Paciente() {
	}

	public Paciente(String nome, String sobrenomeCompleto, String sexo, Date dataNascimento) {
		super();
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
