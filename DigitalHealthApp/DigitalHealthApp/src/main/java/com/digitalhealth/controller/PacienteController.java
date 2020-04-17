package com.digitalhealth.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.digitalhealth.credenciais.CredenciaisPaciente;
import com.digitalhealth.domain.Medico;
import com.digitalhealth.domain.Paciente;
import com.digitalhealth.repository.TodosPacientes;


@CrossOrigin
@RestController
public class PacienteController {

	
	private TodosPacientes todosPacientes;
	private ArrayList<Paciente> pacientes;

	@Autowired
	public PacienteController(TodosPacientes todosPacientes) {
		this.todosPacientes = todosPacientes;
		this.pacientes = new ArrayList<>();
	}
	
	@PostMapping("/cadastroPaciente")
public ResponseEntity<Paciente> cadastro(@RequestBody Paciente pacientes){
		
		Paciente pacienteCadastrado = todosPacientes.save(pacientes);
		this.pacientes.add(pacienteCadastrado);
		
		return  ResponseEntity.ok(pacienteCadastrado);
				
	}
	
	@PostMapping("/logoutPaciente")
	public ResponseEntity<String> logout(@RequestHeader("token") double token)  { 
		Token.getTokenList().remove((Double) token); 
		
		return ResponseEntity.ok("Deslogado com sucesso"); 
	}
	
	@PostMapping("/loginPaciente")
	public ResponseEntity<Double> validarLogin(@RequestBody CredenciaisPaciente credenciaisPaciente) {
			Paciente pacientes = this.todosPacientes.buscarUsuario(credenciaisPaciente);
			
				if(pacientes != null) {
					double token  = Token.generateToken();
							Token.addToken(token);
					return ResponseEntity.ok(token);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(401d); 
		}
				
	}
	
	@PutMapping("/atualizarPaciente/{id}")
	public ResponseEntity<Paciente> atualizarPaciente(@RequestBody Paciente pacientes, @PathVariable("id") Long id){
			
		Optional<Paciente> oldPaciente = this.todosPacientes.findById(id);
		
		if(oldPaciente.isPresent()) {
			if(pacientes.getNomePaciente() == null) {
				pacientes.setNomePaciente(oldPaciente.get().getNomePaciente());
			}
			if(pacientes.getIdade() == null) {
				pacientes.setIdade(oldPaciente.get().getIdade());
			}
			if(pacientes.getSexo() == null) {
				pacientes.setSexo(oldPaciente.get().getSexo());
			}
			if(pacientes.getDataNascimento() == null) {
				pacientes.setDataNascimento(oldPaciente.get().getDataNascimento());
			}
			if(pacientes.getTelefone() == null) {
				pacientes.setTelefone(oldPaciente.get().getTelefone());
			}
			if(pacientes.getEndereco() == null) {
				pacientes.setEndereco(oldPaciente.get().getEndereco());
			}
			
			
			pacientes.setcredenciaisPaciente(oldPaciente.get().getcredenciaisPaciente());
			pacientes.setId(id);
			
			Paciente novoPaciente = this.todosPacientes.save(pacientes);
			return ResponseEntity.ok(novoPaciente);
			
			}
		return ResponseEntity.badRequest().body(null);
		
		}
	
	//@GetMapping("/deleteFarmaceutico/{id}")
		
	
	@GetMapping("/Buscapacientes/cpf/{cpf}")
	public ResponseEntity<List<Paciente>> obterPorCpf(@PathVariable("cpf")String cpf){
		List<Paciente> pacienteEncontrado =  todosPacientes.encontrarPorCpf(cpf);
		for(Paciente u: pacientes) {
			if(u.getcredenciaisPaciente().equals(cpf)) {
				pacienteEncontrado.add(u);
			
			}
		}
		if(pacienteEncontrado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 

		}else {
			return ResponseEntity.status(HttpStatus.OK).body(pacienteEncontrado);
		}
	}
	
	
	
}
