package com.vicente.apiprontuarionline.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_contact")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;
	// ATRIBUTOS BÁSICOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@ElementCollection
	@CollectionTable(name = "tb_email")
	private List<String> emails = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name = "tb_phone")
	private List<String> phones = new ArrayList<>();
	@ElementCollection
	@CollectionTable(name = "tb_contact_number")
	private List<String> contactNumbers = new ArrayList<>();

	@ManyToMany(mappedBy = "contacts")
	private List<Patient> patients = new ArrayList<>();

	// CONSTRUTORES
	public Contact(Long id) {
		super();
		this.id = id;
	}

}