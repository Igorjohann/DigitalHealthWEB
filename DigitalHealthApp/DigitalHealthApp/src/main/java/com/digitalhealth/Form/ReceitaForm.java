package com.digitalhealth.Form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReceitaForm {
	
	@JsonProperty
	private String cpfPaciente;
	
	@JsonProperty
	private String crmMedico;
	
	
	public ReceitaForm() {
		
	}
	
	public ReceitaForm(String cpfPaciente, String crmMedico) {
		this.cpfPaciente = cpfPaciente;
		this.crmMedico = crmMedico;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getCrmMedicoe() {
		return crmMedico;
	}

	public void crmMedico(String crmMedico) {
		this.crmMedico = crmMedico;
	}
	
	
	
	
	
	
	

}
