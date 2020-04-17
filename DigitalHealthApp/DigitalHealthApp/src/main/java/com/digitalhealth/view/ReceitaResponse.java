package com.digitalhealth.view;

import java.util.List;
import java.util.stream.Collectors;

import com.digitalhealth.domain.Receita;

public class ReceitaResponse {
	
	private Long id;

	private String tipoReceita;

	private String dataReceita;

	private String uf;

	private String nomeMedicamento;

	private String descricaoReceita;

	private String nomeResponsavelUm;

	private String cpfResponsavelUm;

	private String nomeResponsavelDois;

	private String cpfResponsavelDois;

	private String nomeResponsavelTres;

	private String cpfResponsavelTres;

	private String nomeResponsavelQuatro;

	private String cpfResponsavelQuatro;
	
	private String crmMedico;
	
	private String nomePaciente;
	
	private String cpfPaciente;
	
	private String endereco;
	
	private String telefone;
	
	private String nomeMedico;
	
	private String idade;
	

	public ReceitaResponse(Receita receita) {
		this.id = receita.getId();
		this.tipoReceita = receita.getTipoReceita();
		this.dataReceita = receita.getDataReceita();
		this.uf = receita.getUf();
		this.nomeMedicamento = receita.getNomeMedicamento();
		this.descricaoReceita = receita.getDescricaoReceita();
		this.nomeResponsavelUm = receita.getNomeResponsavelUm();
		this.cpfResponsavelUm = receita.getCpfResponsavelUm();
		this.nomeResponsavelDois = receita.getNomeResponsavelDois();
		this.cpfResponsavelDois = receita.getCpfResponsavelDois();
		this.nomeResponsavelTres = receita.getNomeResponsavelTres();
		this.cpfResponsavelTres = receita.getCpfResponsavelTres();
		this.nomeResponsavelQuatro = receita.getNomeResponsavelQuatro();
		this.cpfResponsavelQuatro = receita.getCpfResponsavelQuatro();
		this.nomePaciente = receita.getPacientes().getNomePaciente();
		this.cpfPaciente = receita.getPacientes().getcredenciaisPaciente().getCpfPaciente();
		this.endereco = receita.getPacientes().getEndereco();
		this.telefone = receita.getPacientes().getTelefone();
		this.crmMedico = receita.getMedico().getCredenciais().getCrmMedico();
		this.nomeMedico = receita.getMedico().getNomeMedico();
		this.idade = receita.getPacientes().getIdade();
		
	}
	
	public static List<ReceitaResponse> criarLista(List<Receita> receitas) {
		return receitas.stream()
				.map(receita -> new ReceitaResponse(receita))
				.collect(Collectors.toList());
	}
	
	

	public Long getId() {
		return id;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public String getDataReceita() {
		return dataReceita;
	}

	public String getUf() {
		return uf;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public String getDescricaoReceita() {
		return descricaoReceita;
	}

	public String getNomeResponsavelUm() {
		return nomeResponsavelUm;
	}

	public String getCpfResponsavelUm() {
		return cpfResponsavelUm;
	}

	public String getNomeResponsavelDois() {
		return nomeResponsavelDois;
	}

	public String getCpfResponsavelDois() {
		return cpfResponsavelDois;
	}

	public String getNomeResponsavelTres() {
		return nomeResponsavelTres;
	}

	public String getCpfResponsavelTres() {
		return cpfResponsavelTres;
	}

	public String getNomeResponsavelQuatro() {
		return nomeResponsavelQuatro;
	}

	public String getCpfResponsavelQuatro() {
		return cpfResponsavelQuatro;
	}

	public String getCrmMedico() {
		return crmMedico;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public String getIdade() {
		return idade;
	}
	
	
	
	
}
