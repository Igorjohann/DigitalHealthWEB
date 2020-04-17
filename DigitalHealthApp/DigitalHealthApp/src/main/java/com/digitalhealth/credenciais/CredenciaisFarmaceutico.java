package com.digitalhealth.credenciais;

import javax.persistence.Embeddable;

@Embeddable
public class CredenciaisFarmaceutico {

	private String crfFarmaceutico;
	private String senha;
	
	
public  CredenciaisFarmaceutico() {
	
}


public CredenciaisFarmaceutico(String crfFarmaceutico, String senha) {
	super();
	this.crfFarmaceutico = crfFarmaceutico;
	this.senha = senha;
}


public String getCrfFarmaceutico() {
	return crfFarmaceutico;
}


public void setCrfFarmaceutico(String crfFarmaceutico) {
	this.crfFarmaceutico = crfFarmaceutico;
}


public String getSenha() {
	return senha;
}


public void setSenha(String senha) {
	this.senha = senha;
}




}
