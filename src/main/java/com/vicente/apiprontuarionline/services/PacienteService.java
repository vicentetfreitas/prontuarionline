package com.vicente.apiprontuarionline.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicente.apiprontuarionline.model.Paciente;
import com.vicente.apiprontuarionline.repositories.PacienteRepository;
import com.vicente.apiprontuarionline.services.exception.ObjectNotFoundException;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository pacienteRepository;

	// BUSCAR PACIENTE POR {id}
	public Paciente buscarPacienteId(Long id) {
		Optional<Paciente> objPaciente = pacienteRepository.findById(id);
		return objPaciente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}

	// INSERIR PACIENTE NO BANCO DE DADOS
	public Paciente inserirPaciente(Paciente objPaciente) {
		objPaciente.setId(null);
		return pacienteRepository.save(objPaciente);
	}

}
