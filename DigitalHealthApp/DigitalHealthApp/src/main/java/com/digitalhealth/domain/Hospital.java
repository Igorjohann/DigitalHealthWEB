package com.digitalhealth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tb_instituicao")
public class Hospital {
	
	
	@Id
	@GeneratedValue
	@Column(name = "idInstituicao")
	private Long id;

	@Column
	@JsonProperty
	private String nomeInstituicao;
	
	@Column
	@JsonProperty
	private String enderecoInstituicao;
	
	
	public Hospital() {
		
	}

	public Hospital(Long id, String nomeInstituicao, String enderecoInstituicao) {
		this.id = id;
		this.nomeInstituicao = nomeInstituicao;
		this.enderecoInstituicao = enderecoInstituicao;
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public String getEnderecoInstituicao() {
		return enderecoInstituicao;
	}

	public void setEnderecoInstituicao(String enderecoInstituicao) {
		this.enderecoInstituicao = enderecoInstituicao;
	}
	
	
	
	
	
	
	
	
	
}
