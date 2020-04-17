package com.digitalhealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.digitalhealth.domain.Farmacia;
import com.digitalhealth.repository.TodasFarmacias;

@CrossOrigin
@RestController
public class FarmaciaController {
	
	private TodasFarmacias todasFarmacias;

	
	@Autowired
	public FarmaciaController(TodasFarmacias todasFarmacias) {

		this.todasFarmacias = todasFarmacias;
	}
	
	
	@PostMapping("/cadastroFarmacia")
	public ResponseEntity<Farmacia> cadastro(@RequestBody Farmacia farmacias){
		
	
		Farmacia farmaciaCadastrada = todasFarmacias.save(farmacias);

		return ResponseEntity.ok(farmaciaCadastrada);	
	}
	
	
	
//	@DeleteMapping("/deletarFarmacia/{id}")
//	public ResponseEntity<Farmacia> excluirFarmacia(@RequestBody Farmacia farmacias, @PathVariable("id") Long id){
//		
//		todasFarmacias.deleteById(id);
//
//        boolean isRemoved;
//		if (!isRemoved) {
//            return  ResponseEntity<Farmacia>(HttpStatus.NOT_FOUND);
//        }
//
//        return  ResponseEntity<Farmacia>(id, HttpStatus.OK);
//   }
		
	}
	
	
	


