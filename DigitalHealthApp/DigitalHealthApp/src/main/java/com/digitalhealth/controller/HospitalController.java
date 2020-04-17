package com.digitalhealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.digitalhealth.domain.Hospital;
import com.digitalhealth.repository.TodosHospitais;



@CrossOrigin
@RestController
public class HospitalController {
	
	private TodosHospitais todosHospitais;

	
	@Autowired
	public HospitalController(TodosHospitais todosHospitais) {

		this.todosHospitais = todosHospitais;
	}
	
	@PostMapping("/cadastroHospital")
	public ResponseEntity<Hospital> cadastro(@RequestBody Hospital hospitais){
		
	
		Hospital hospitalCadastrado = todosHospitais.save(hospitais);

		return ResponseEntity.ok(hospitalCadastrado);	
	}

}
