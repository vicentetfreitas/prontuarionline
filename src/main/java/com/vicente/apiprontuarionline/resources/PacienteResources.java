package com.vicente.apiprontuarionline.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vicente.apiprontuarionline.dto.PacienteDTO;
import com.vicente.apiprontuarionline.model.Paciente;
import com.vicente.apiprontuarionline.services.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResources {

	@Autowired
	private PacienteService pacienteService;

	// FIND PACIENTE POR ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> findPaciente(@PathVariable Long id) {
		Paciente objPaciente = pacienteService.findPaciente(id);
		return ResponseEntity.ok().body(objPaciente);
	}

	// INSERT PACIENTE
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertPaciente(@RequestBody Paciente objPaciente) {
		objPaciente = pacienteService.insertPaciente(objPaciente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objPaciente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	// UPDATE PACIENTE
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePaciente(@RequestBody Paciente objPaciente, @PathVariable Long id) {
		objPaciente.setId(id);
		objPaciente = pacienteService.updatePaciente(objPaciente);
		return ResponseEntity.noContent().build();
	}

	// DELETE PACIENTE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePaciente(@PathVariable Long id) {
		pacienteService.deletePaciente(id);
		return ResponseEntity.noContent().build();
	}

	// LISTAR PACIENTES
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PacienteDTO>> findAllPaciente() {
		List<Paciente> listObjPaciente = pacienteService.findAllPaciente();
		List<PacienteDTO> listObjPacienteDTO = listObjPaciente.stream().map(objPaciente -> new PacienteDTO(objPaciente))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listObjPacienteDTO);
	}
}