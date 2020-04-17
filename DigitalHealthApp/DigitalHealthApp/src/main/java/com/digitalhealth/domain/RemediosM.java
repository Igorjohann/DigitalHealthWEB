package com.digitalhealth.domain;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


public class RemediosM {

	
	@Id
	private String id;
	
	
	@JsonProperty
	private String nomeRemedio;
	
	@JsonProperty
	private String nomeLaboratorio;


	
	
	
}
