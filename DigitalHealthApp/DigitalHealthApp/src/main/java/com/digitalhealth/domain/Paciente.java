package com.digitalhealth.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.digitalhealth.credenciais.CredenciaisPaciente;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table
public class Paciente {

	@Id
	@GeneratedValue
	@Column(name = "idPaciente")
	private Long id;
	
	
	//Paciente
	@Column
	@JsonProperty
	private String nomePaciente;
	
	@JsonProperty
	@Embedded
	private CredenciaisPaciente credenciaisPaciente;
	
	@Column
	@JsonProperty
	private Date dataNascimento;
	
	@Column
	@JsonProperty
	private String endereco;
	
	@Column
	@JsonProperty
	private String telefone;
	
	@Column
	@JsonProperty
	private String idade;
	
	@Column
	@JsonProperty
	private String sexo;
	
	@OneToMany(mappedBy ="pacientes", cascade = CascadeType.ALL)
	  private List<Receita> receitas;
	
	
	//construtor vazio 
	public Paciente() {
		
		
	}

	//construtor preenchido
	public Paciente(Long id, String nomePaciente, Date dataNascimento,
			String endereco, String telefone, String idade, String sexo, CredenciaisPaciente credenciaisPaciente) {
		this.id = id;
		this.nomePaciente = nomePaciente;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
		this.idade = idade;
		this.sexo = sexo;
		this.credenciaisPaciente = credenciaisPaciente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public CredenciaisPaciente getcredenciaisPaciente() {
		return credenciaisPaciente;
	}

	public void setcredenciaisPaciente(CredenciaisPaciente credenciaisPaciente) {
		this.credenciaisPaciente = credenciaisPaciente;
	}
	
	public List<Receita> getReceitas(){
		return receitas;
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nomePaciente=" + nomePaciente + ", credenciaisPaciente=" + credenciaisPaciente
				+ ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", idade=" + idade + ", sexo=" + sexo + "]";
	}
	
	
	
	
	
	
	
	
	
}
