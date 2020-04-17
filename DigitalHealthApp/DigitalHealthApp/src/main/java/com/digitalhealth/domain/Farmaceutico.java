package com.digitalhealth.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.digitalhealth.credenciais.CredenciaisFarmaceutico;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table
public class Farmaceutico {
	
	@Id
	@GeneratedValue
	@Column(name = "idFarmaceutico")
	private Long id;
	
	@Column
	@JsonProperty
	private String nomeFarmacia;
	
	@Column
	@JsonProperty
	private String nomeFarmaceutico;
	
	@JsonProperty
	@Embedded
	private CredenciaisFarmaceutico credenciaisFarmaceutico;
	
	@Column
	@JsonProperty
	private String telefoneFarmaceutico;
	
	@Column
	@JsonProperty
	private String email;
	
	@Column
	@JsonProperty
	private String cpf;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "idFarmacia")
	private Farmacia farmacia;
	 
	
	
	
	
	//construtor vazio
	public Farmaceutico() {
			
	}
	

	public Farmaceutico(String nomeFarmacia, String nomeFarmaceutico, String telefoneFarmaceutico,String email, 
			 String cpf, CredenciaisFarmaceutico credenciaisFarmaceutico) {
		super();
		this.nomeFarmacia = nomeFarmacia;
		this.nomeFarmaceutico = nomeFarmaceutico;
		this.telefoneFarmaceutico = telefoneFarmaceutico;
		this.email = email;
		this.credenciaisFarmaceutico = credenciaisFarmaceutico;
		this.cpf = cpf;
	
	
	}



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


	public String getNomeFarmaceutico() {
		return nomeFarmaceutico;
	}


	public void setNomeFarmaceutico(String nomeFarmaceutico) {
		this.nomeFarmaceutico = nomeFarmaceutico;
	}



	public String gettelefoneFarmaceutico() {
		return telefoneFarmaceutico;
	}

	

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	public void settelefoneFarmaceutico(String telefoneFarmaceutico) {
		this.telefoneFarmaceutico = telefoneFarmaceutico;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public CredenciaisFarmaceutico getCredenciaisFarmaceutico() {
		return credenciaisFarmaceutico;
	}


	public void setCredenciaisFarmaceutico(CredenciaisFarmaceutico credenciaisFarmaceutico) {
		this.credenciaisFarmaceutico = credenciaisFarmaceutico;
	}


	
	
	

//	public void setCrmFarmaceutico(String crmFarmaceutico) {
//		this.crmFarmaceutico = crmFarmaceutico;
//	}




//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
	
	
	
	

	
	
}
