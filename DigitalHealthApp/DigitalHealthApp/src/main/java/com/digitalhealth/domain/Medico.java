package com.digitalhealth.domain;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.digitalhealth.credenciais.CredenciaisMedicos;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Medico {

	//medico
	
	@Id
	@GeneratedValue
	@Column(name = "idMedico")
	private Long id;
	
	
	@Column
	@JsonProperty
	private String nomeMedico;
	
	@JsonProperty
	@Embedded
	private CredenciaisMedicos credenciais;
	
	@Column
	@JsonProperty
	private String telefone;

	
	@Column
	@JsonProperty
	private String email;
	
	@Column
	@JsonProperty
	private String cpf;
	
	@Column
	@JsonProperty
	private String especialidade;
	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@ManyToOne
	@JoinColumn(name = "idInstituicao")
	@JsonProperty(required = false)
	private Hospital hospital;
	
	
	  @OneToMany(mappedBy ="medico", cascade = CascadeType.ALL)
	  private List<Receita> receitas;
	
	
private List<Medico> historicoDeAcessoMedico(){
		
		List<Medico> acessosMedico = new ArrayList<>();
		return acessosMedico;
	}
	
	
	

	//constutor vazio
	public Medico() {
		
	}

	//constutor cheio
	
	
	public Medico(String nomeMedico, String telefone, String email, String especialidade, String cpf, CredenciaisMedicos credenciais ) {
		super();
		this.nomeMedico = nomeMedico;
		this.telefone = telefone;
		this.email = email;
		this.especialidade = especialidade;
		this.cpf = cpf;
		this.credenciais = credenciais;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CredenciaisMedicos getCredenciais() {
		return credenciais;
	}
	
	public void setCredenciais(CredenciaisMedicos credenciais) {
		this.credenciais = credenciais;
	}




	@Override
	public String toString() {
		return "Medico [id=" + id + ", nomeMedico=" + nomeMedico + ", credenciais=" + credenciais + ", telefone="
				+ telefone + ", email=" + email + ", cpf=" + cpf + ", especialidade=" + especialidade + ", hospital="
				+ hospital + ", receitas=" + receitas + "]";
	}


	
	
	
}
