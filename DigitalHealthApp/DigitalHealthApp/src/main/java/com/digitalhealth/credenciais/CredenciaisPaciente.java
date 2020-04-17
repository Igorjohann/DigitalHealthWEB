package com.digitalhealth.credenciais;

import javax.persistence.Embeddable;

@Embeddable
public class CredenciaisPaciente {
	
	
	
	private String cpfPaciente;
	private String senha;
	
	
public CredenciaisPaciente() {}


public CredenciaisPaciente(String cpfPaciente, String senha) {
	super();
	this.cpfPaciente = cpfPaciente;
	this.senha = senha;
}


public String getCpfPaciente() {
	return cpfPaciente;
}


public void setCpfPaciente(String cpfPaciente) {
	this.cpfPaciente = cpfPaciente;
}


public String getSenha() {
	return senha;
}


public void setSenha(String senha) {
	this.senha = senha;
}



	
}
