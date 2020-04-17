package com.digitalhealth.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="tb_Farmacia")
public class Farmacia {
	
	@Id
	@GeneratedValue
	@Column(name = "idFarmacia")
	private Long id;
	
	@Column
	@JsonProperty
	private String nomeFarmacia;
	
	@Column
	@JsonProperty
	private String cpnjFarmacia;
	
	@Column
	@JsonProperty
	private String telefoneFarmacia;
	
	@Column
	@JsonProperty
	private String enderecoFarmacia;
	
	
	

	//construtor vazio
	public Farmacia() {
	
	}
	
	//construtor cheio

	public Farmacia(Long id, String nomeFarmacia, String cpnjFarmacia, String telefoneFarmacia,
			String enderecoFarmacia) {
		super();
		this.id = id;
		this.nomeFarmacia = nomeFarmacia;
		this.cpnjFarmacia = cpnjFarmacia;
		this.telefoneFarmacia = telefoneFarmacia;
		this.enderecoFarmacia = enderecoFarmacia;
	}

	
	//gett and setters 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFarmacia() {
		return nomeFarmacia;
	}

	public void setNomeFarmacia(String nomeFarmacia) {
		this.nomeFarmacia = nomeFarmacia;
	}

	public String getCpnjFarmacia() {
		return cpnjFarmacia;
	}

	public void setCpnjFarmacia(String cpnjFarmacia) {
		this.cpnjFarmacia = cpnjFarmacia;
	}

	public String getTelefoneFarmacia() {
		return telefoneFarmacia;
	}

	public void setTelefoneFarmacia(String telefoneFarmacia) {
		this.telefoneFarmacia = telefoneFarmacia;
	}

	public String getEnderecoFarmacia() {
		return enderecoFarmacia;
	}

	public void setEnderecoFarmacia(String enderecoFarmacia) {
		this.enderecoFarmacia = enderecoFarmacia;
	}
	
	
	
	
	
	
	
	
	

}
