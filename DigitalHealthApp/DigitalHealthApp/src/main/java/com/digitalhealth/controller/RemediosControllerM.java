package com.digitalhealth.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.digitalhealth.domain.RemediosM;
import com.digitalhealth.Service.RemediosApk;




@CrossOrigin(origins="*")
@RestController
public class RemediosControllerM {

	
	private final RemediosApk remediosApk;

	
	@Autowired
	public RemediosControllerM(RemediosApk remediosApk) {
		this.remediosApk = remediosApk;
	}
	
	
	@CrossOrigin
	@GetMapping("/obter/remedios/{id}")
	public ResponseEntity<List<RemediosM>> obterPorNome(@PathVariable("id") String id) {
		List<RemediosM> remedioPorNome = remediosApk.obterPorNome(id);
		
		return remedioPorNome.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(remedioPorNome);
	}
	
	

	

	

	
}
