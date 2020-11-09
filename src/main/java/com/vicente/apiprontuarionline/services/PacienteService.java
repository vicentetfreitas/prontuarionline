package com.vicente.apiprontuarionline.services;

import java.util.List;
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

	// BUSCAR PACIENTE NO BD POR ID
	public Paciente findPaciente(Long id) {
		Optional<Paciente> objPaciente = pacienteRepository.findById(id);
		return objPaciente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}

	// INSERIR PACIENTE NO BANCO DE DADOS
	public Paciente insertPaciente(Paciente objPaciente) {
		objPaciente.setId(null);
		return pacienteRepository.save(objPaciente);
	}

	// ATUALIZAR PACIENTE NO BANCO DE DADOS
	public Paciente updatePaciente(Paciente objPaciente) {
		findPaciente(objPaciente.getId());
		return pacienteRepository.save(objPaciente);
	}

	// DELETE PACIENTE NO BANCO DE DADOS
	public void deletePaciente(Long id) {
		findPaciente(id);
		pacienteRepository.deleteById(id);
	}

	// LISTANDO PACIENTE NO BANCO DE DADOS

	public List<Paciente> findAllPaciente() {
		return pacienteRepository.findAll();
	}
}
