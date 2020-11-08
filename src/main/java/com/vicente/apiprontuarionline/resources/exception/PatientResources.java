package com.vicente.apiprontuarionline.resources.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vicente.apiprontuarionline.model.Paciente;
import com.vicente.apiprontuarionline.services.exceptions.PatientService;

@RestController
@RequestMapping(value = "/pacientes")
public class PatientResources {

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listPatients(@PathVariable Long id) {
		Paciente objPatient = patientService.searchPatientById(id);
		return ResponseEntity.ok().body(objPatient);
	}

}