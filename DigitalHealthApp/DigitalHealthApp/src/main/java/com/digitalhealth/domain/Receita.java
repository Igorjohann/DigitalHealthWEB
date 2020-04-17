package com.digitalhealth.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Receita {

//---------------------------- RECEITA ------------------------//

	@Id
	@GeneratedValue
	@Column(name = "idReceita")
	private Long id;

	@Column
	@JsonProperty
	private String tipoReceita;

	// data emissão
	@Column
	@JsonProperty
	private String dataReceita;

	// uf receita
	@Column
	@JsonProperty
	private String uf;

	// ---------------------------- MEDICAMENTOS -------------------------//

	@Column
	@JsonProperty
	private String nomeMedicamento;

	@Column
	@JsonProperty
	private String descricaoReceita;

	// ------------------------------- RESPONSAVEIS LEGAIS --------------------//

	@Column
	@JsonProperty
	private String nomeResponsavelUm;

	@Column
	@JsonProperty
	private String cpfResponsavelUm;

	@Column
	@JsonProperty
	private String nomeResponsavelDois;

	@Column
	@JsonProperty
	private String cpfResponsavelDois;

	@Column
	@JsonProperty
	private String nomeResponsavelTres;

	@Column
	@JsonProperty
	private String cpfResponsavelTres;

	@Column
	@JsonProperty
	private String nomeResponsavelQuatro;

	@Column
	@JsonProperty
	private String cpfResponsavelQuatro;


	@ManyToOne(optional = false)
	@JoinColumn(name = "idMedico", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonProperty(required = false)
	private Medico medico;

	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "idPaciente", nullable = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Paciente pacientes;

	
	public Receita() {

	}

	public Receita(Long id, String tipoReceita, String dataReceita, String uf, String nomeMedicamento,
			String descricaoReceita, String nomeResponsavelUm, String cpfResponsavelUm, String nomeResponsavelDois,
			String cpfResponsavelDois, String nomeResponsavelTres, String cpfResponsavelTres,
			String nomeResponsavelQuatro, String cpfResponsavelQuatro, Medico medico, Paciente pacientes) {
		this.id = id;
		this.tipoReceita = tipoReceita;
		this.dataReceita = dataReceita;
		this.uf = uf;
		this.nomeMedicamento = nomeMedicamento;
		this.descricaoReceita = descricaoReceita;
		this.nomeResponsavelUm = nomeResponsavelUm;
		this.cpfResponsavelUm = cpfResponsavelUm;
		this.nomeResponsavelDois = nomeResponsavelDois;
		this.cpfResponsavelDois = cpfResponsavelDois;
		this.nomeResponsavelTres = nomeResponsavelTres;
		this.cpfResponsavelTres = cpfResponsavelTres;
		this.nomeResponsavelQuatro = nomeResponsavelQuatro;
		this.cpfResponsavelQuatro = cpfResponsavelQuatro;
		this.medico = medico;
		this.pacientes = pacientes;
	}

	public Paciente getPacientes() {
		return pacientes;
	}

	public void setPacientes(Paciente pacientes) {
		this.pacientes = pacientes;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDataReceita() {
		return dataReceita;
	}

	public void setDataReceita(String dataReceita) {
		this.dataReceita = dataReceita;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}

	public String getNomeResponsavelUm() {
		return nomeResponsavelUm;
	}

	public void setNomeResponsavelUm(String nomeResponsavelUm) {
		this.nomeResponsavelUm = nomeResponsavelUm;
	}

	public String getCpfResponsavelUm() {
		return cpfResponsavelUm;
	}

	public void setCpfResponsavelUm(String cpfResponsavelUm) {
		this.cpfResponsavelUm = cpfResponsavelUm;
	}

	public String getNomeResponsavelDois() {
		return nomeResponsavelDois;
	}

	public void setNomeResponsavelDois(String nomeResponsavelDois) {
		this.nomeResponsavelDois = nomeResponsavelDois;
	}

	public String getCpfResponsavelDois() {
		return cpfResponsavelDois;
	}

	public void setCpfResponsavelDois(String cpfResponsavelDois) {
		this.cpfResponsavelDois = cpfResponsavelDois;
	}

	public String getNomeResponsavelTres() {
		return nomeResponsavelTres;
	}

	public void setNomeResponsavelTres(String nomeResponsavelTres) {
		this.nomeResponsavelTres = nomeResponsavelTres;
	}

	public String getCpfResponsavelTres() {
		return cpfResponsavelTres;
	}

	public void setCpfResponsavelTres(String cpfResponsavelTres) {
		this.cpfResponsavelTres = cpfResponsavelTres;
	}

	public String getNomeResponsavelQuatro() {
		return nomeResponsavelQuatro;
	}

	public void setNomeResponsavelQuatro(String nomeResponsavelQuatro) {
		this.nomeResponsavelQuatro = nomeResponsavelQuatro;
	}

	public String getCpfResponsavelQuatro() {
		return cpfResponsavelQuatro;
	}

	public void setCpfResponsavelQuatro(String cpfResponsavelQuatro) {
		this.cpfResponsavelQuatro = cpfResponsavelQuatro;
	}


	@Override
	public String toString() {
		return "Receita [id=" + id + ", tipoReceita=" + tipoReceita + ", dataReceita=" + dataReceita + ", uf=" + uf
				+ ", nomeMedicamento=" + nomeMedicamento + ", descricaoReceita=" + descricaoReceita
				+ ", nomeResponsavelUm=" + nomeResponsavelUm + ", cpfResponsavelUm=" + cpfResponsavelUm
				+ ", nomeResponsavelDois=" + nomeResponsavelDois + ", cpfResponsavelDois=" + cpfResponsavelDois
				+ ", nomeResponsavelTres=" + nomeResponsavelTres + ", cpfResponsavelTres=" + cpfResponsavelTres
				+ ", nomeResponsavelQuatro=" + nomeResponsavelQuatro + ", cpfResponsavelQuatro=" + cpfResponsavelQuatro
				+ ", medico=" + medico + ", pacientes=" + pacientes + "]";
	}

}
