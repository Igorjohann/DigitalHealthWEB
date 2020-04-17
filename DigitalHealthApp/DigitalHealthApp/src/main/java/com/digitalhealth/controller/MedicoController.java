package com.digitalhealth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.digitalhealth.credenciais.CredenciaisMedicos;
import com.digitalhealth.domain.HistoricoDeAcessoMedico;
import com.digitalhealth.domain.Medico;
import com.digitalhealth.repository.TodosMedicos;


@CrossOrigin
@RestController
public class MedicoController {

	private TodosMedicos todosMedicos;
	private ArrayList<Medico> medicos;

	
	@Autowired
	public MedicoController(TodosMedicos todosMedicos) {
		
		this.todosMedicos = todosMedicos;
		this.medicos =  new ArrayList<>();
	}
	
	
	@PostMapping("/cadastroMedico")
	public ResponseEntity<Medico> cadastro(@RequestBody Medico medicos){
	
		Medico medicoCadastrado = todosMedicos.save(medicos);
		this.medicos.add(medicoCadastrado);

		return ResponseEntity.ok(medicoCadastrado);	
	}
	
	
	@PostMapping("/logoutMedico")
	public ResponseEntity<String> logout(@RequestHeader("token") double token)  { 
		Token.getTokenList().remove((Double) token); 
		
		return ResponseEntity.ok("Deslogado com sucesso"); 
	}
	
	
	@PostMapping("/loginMedico")
	public ResponseEntity<Long> validarLogin(@RequestBody CredenciaisMedicos credenciais) {
		Medico medicos = this.todosMedicos.buscarUsuario(credenciais);
			
		if(medicos != null) {
			double token  = Token.generateToken();
			Token.addToken(token);
					
			HistoricoDeAcessoMedico.gravaLista(this.medicos, false);
			return ResponseEntity.ok(medicos.getId());			
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(401L); 
		}	
	}
	


	@PutMapping("/AtualizarMedico/{id}")
	public ResponseEntity<Medico> atualizarMedico(@RequestBody Medico medicos, @PathVariable("id") Long id){
			
		Optional<Medico> oldMedico = this.todosMedicos.findById(id);
		
		if(oldMedico.isPresent()) {
			
			if(medicos.getNomeMedico() == null) {
				medicos.setNomeMedico(oldMedico.get().getNomeMedico());
			}
			if(medicos.getEmail() == null) {
				medicos.setEmail(oldMedico.get().getEmail());
			}
			if(medicos.getNomeMedico() == null) {
				medicos.setNomeMedico(oldMedico.get().getNomeMedico());
			}
			if(medicos.getTelefone() == null) {
				medicos.setTelefone(oldMedico.get().getTelefone());
			}
			
			if(medicos.getCpf().equals(null)) {
				medicos.setCpf(oldMedico.get().getCpf());
			}
			if(medicos.getEspecialidade() == null) {
				medicos.setEspecialidade(oldMedico.get().getEspecialidade());
			}
			
			//fazer if para outras informações basicas ATRIBUTOS
			
			medicos.setCredenciais(oldMedico.get().getCredenciais());
			medicos.setId(id);
			
			Medico novoMedico = this.todosMedicos.save(medicos);
			
			return ResponseEntity.ok(novoMedico);
		}
		
		return ResponseEntity.badRequest().body(null);
		
	}
	
	//-----------------------------------------
	//PROCURAR MÉDICO POR NOME


	@GetMapping("/medicos/nome/{nomeDoMedico}")
	public ResponseEntity<List<Medico>> obterPorNome(@PathVariable("nomeDoMedico")String nome){
		List<Medico> medicoEncontrado =  new ArrayList<Medico>();
		for(Medico u: medicos) {
			if(u.getNomeMedico().equals(nome)) {
				medicoEncontrado.add(u);
				//return ResponseEntity.status(HttpStatus.OK).body(u);
			}
		}
		if(medicoEncontrado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 

		}else {
			return ResponseEntity.status(HttpStatus.OK).body(medicoEncontrado);
		}
	}
	
	@DeleteMapping("/deleteMedico/{id}")
	public ResponseEntity<String> excluirFarmaceutico(@RequestParam("id") Long id){
		
		Optional<Medico> deletMedico = this.todosMedicos.findById(id);
		
		if(deletMedico.isPresent()) {
			this.todosMedicos.delete(deletMedico.get());
			return ResponseEntity.ok("funcionou");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Medico não existe");
		}	
	}
}
