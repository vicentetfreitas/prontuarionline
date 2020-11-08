package com.vicente.apiprontuarionline.services.exceptions;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicente.apiprontuarionline.model.Paciente;
import com.vicente.apiprontuarionline.repositories.PacienteRepository;

@Service
public class PatientService {
	@Autowired
	private PacienteRepository pacienteRepository;

	// BUSCAR PACIENTE POR {id}
	public Paciente searchPatientById(Long id) {
		Optional<Paciente> objPatientRepository = pacienteRepository.findById(id);
		return objPatientRepository.orElse(null);

	}

}
