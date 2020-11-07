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
@Table(name = "tb_address")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	private String state;
	private String city;
	private String street;
	private String number;
	private String neighborhood;
	private String complement;
	private String postalCode;
	// ASSOCIAÇÕES E RELACIONAMENTOS

	@ManyToMany(mappedBy = "adresses")
	private List<Patient> patients = new ArrayList<>();

	// CONSTRUTORES
	public Address(Long id, String country, String state, String city, String street, String number,
			String neighborhood, String complement, String postalCode) {
		super();
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.complement = complement;
		this.postalCode = postalCode;
	}

}
