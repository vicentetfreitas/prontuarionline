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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_emergencyContact")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EmergencyContact implements Serializable {
	private static final long serialVersionUID = 1L;

	// ATRIBUTOS BÁSICOS
	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String fullSurname;
	private String rg;
	private String cpf;
	private String phone;
	private String email;
	private String contactNumber;

	// ASSOCIAÇÕES E RELACIONAMENTOS
	@ManyToMany(mappedBy = "emergencyContacts")
	private List<Patient> patients = new ArrayList<>();

	public EmergencyContact(Long id, String firstName, String fullSurname, String rg, String cpf, String phone,
			String email, String contactNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.fullSurname = fullSurname;
		this.rg = rg;
		this.cpf = cpf;
		this.phone = phone;
		this.email = email;
		this.contactNumber = contactNumber;
	}

}
