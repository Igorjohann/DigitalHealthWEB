package com.digitalhealth.credenciais;

import javax.persistence.Embeddable;

@Embeddable
public class CredenciaisMedicos {
	
	private String crmMedico;
	private String senha;
	

	public CredenciaisMedicos() {}

	public CredenciaisMedicos(String crmMedico, String senha) {
		super();
		this.crmMedico = crmMedico;
		this.senha = senha;
	}




//	public CredenciaisMedicos(String crmMedico2) {
//		crmMedico = crmMedico2;
//	}

	public String getCrmMedico() {
		return crmMedico;
	}

	public void setCrmMedico(String crmMedico) {
		this.crmMedico = crmMedico;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}
	
	

	
	
	

}
