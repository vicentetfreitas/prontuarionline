package com.vicente.apiprontuarionline.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vicente.apiprontuarionline.model.Paciente;
import com.vicente.apiprontuarionline.services.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResources {

	@Autowired
	private PacienteService pacienteService;

	// LISTA PACIENTE POR Id {GET}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> findPaciente(@PathVariable Long id) {
		Paciente objPaciente = pacienteService.findPaciente(id);
		return ResponseEntity.ok().body(objPaciente);
	}

	// INSERIR PACIENTE NO BANCO DE DADOS {POST}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insertPaciente(@RequestBody Paciente objPaciente) {
		objPaciente = pacienteService.insertPaciente(objPaciente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objPaciente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	// ALETERAR DADOS DO PACIENTE NO BANCO DE DADOS {PUT}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updatePaciente(@RequestBody Paciente objPaciente, @PathVariable Long id) {
		objPaciente.setId(id);

		objPaciente = pacienteService.updatePaciente(objPaciente);
		return ResponseEntity.noContent().build();

	}

}