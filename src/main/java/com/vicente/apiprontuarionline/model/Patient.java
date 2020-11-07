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
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_patient")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private String firstName;
	private String fullSurname;
	private String genre;
	private Date dateOfBirth;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_patient_address", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
	private List<Address> adresses = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_patient_contact", joinColumns = @JoinColumn(name = "patient_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
	private List<Contact> contacts = new ArrayList<>();

	public Patient(Long id, String firstName, String fullSurname, String genre, Date dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.fullSurname = fullSurname;
		this.genre = genre;
		this.dateOfBirth = dateOfBirth;
	}

}
