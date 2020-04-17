package com.digitalhealth.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.digitalhealth.domain.RemediosM;



@Service
public class RemediosApk {
	
	private final RestTemplate restTemplate;
	private final String url;

	
	
	public RemediosApk() {
		restTemplate = new RestTemplate();
		url = "http://localhost:8081/remedios";
	}

	
	public List<RemediosM> obterPorNome(@PathVariable("id") String id) {
		String urlBusca = url + "/id/" + id;
		ResponseEntity<List> resposta = restTemplate
				.getForEntity(urlBusca, List.class);
		return resposta.getBody();
	}


}
