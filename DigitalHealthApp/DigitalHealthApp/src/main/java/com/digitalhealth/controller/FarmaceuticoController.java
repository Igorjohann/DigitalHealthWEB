package com.digitalhealth.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.digitalhealth.credenciais.CredenciaisFarmaceutico;
import com.digitalhealth.domain.Farmaceutico;
import com.digitalhealth.repository.TodosFarmaceuticos;



@CrossOrigin
@RestController
public class FarmaceuticoController {

	
	private TodosFarmaceuticos todosFarmaceuticos;

	@Autowired
	public FarmaceuticoController(TodosFarmaceuticos todosFarmaceuticos) {
		super();
		this.todosFarmaceuticos = todosFarmaceuticos;
	}
	
	
	@PostMapping("/cadastroFarmaceutico")
	public ResponseEntity<Farmaceutico> cadastro(@RequestBody Farmaceutico farmaceuticos){
		
	
		Farmaceutico farmaceuticoCadastrado = todosFarmaceuticos.save(farmaceuticos);

		return ResponseEntity.ok(farmaceuticoCadastrado);	
	}
	
//	@PostMapping("/logoutFarmaceutico")
//	public ResponseEntity<String> logout(@RequestHeader("token") double token)  { 
//		Token.getTokenList().remove((Double) token); 
//		
//		return ResponseEntity.ok("Deslogado com sucesso"); 
//	}
	
	@PostMapping("/loginFarmaceutico")
	public ResponseEntity<Double> validarLogin(@RequestBody CredenciaisFarmaceutico credenciaisFarmaceutico) {
			Farmaceutico farmaceuticos = this.todosFarmaceuticos.buscarUsuario(credenciaisFarmaceutico);
			
				if(farmaceuticos != null) {
					double token  = Token.generateToken();
							Token.addToken(token);
					return ResponseEntity.ok(token);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(401d); 
		}	
	}
	
	@PutMapping("/AtualizarFarmaceutico/{id}")
	public ResponseEntity<Farmaceutico> atualizarFarmaceutico(@RequestBody Farmaceutico farmaceuticos, @PathVariable("id") Long id){
			
		Optional<Farmaceutico> oldFarmaceutico = this.todosFarmaceuticos.findById(id);
		
		if(oldFarmaceutico.isPresent()) {
			
			if(farmaceuticos.getNomeFarmaceutico() == null) {
				farmaceuticos.setNomeFarmaceutico(oldFarmaceutico.get().getNomeFarmaceutico());
			}
			if(farmaceuticos.getNomeFarmacia() == null) {
				farmaceuticos.setNomeFarmacia(oldFarmaceutico.get().getNomeFarmacia());
			}
			if(farmaceuticos.gettelefoneFarmaceutico() == null) {
				farmaceuticos.settelefoneFarmaceutico(oldFarmaceutico.get().gettelefoneFarmaceutico());
			}
			if(farmaceuticos.getEmail() == null) {
				farmaceuticos.setEmail(oldFarmaceutico.get().getEmail());
			}
			if(farmaceuticos.getCpf() == null) {
				farmaceuticos.setCpf(oldFarmaceutico.get().getCpf());
			}
			
			farmaceuticos.setCredenciaisFarmaceutico(oldFarmaceutico.get().getCredenciaisFarmaceutico());
			farmaceuticos.setId(id);
			
			
			Farmaceutico novoFarmaceutico = this.todosFarmaceuticos.save(farmaceuticos);
			return ResponseEntity.ok(novoFarmaceutico);
			
			
		}
		
			return ResponseEntity.badRequest().body(null);
}
		
	
	
//	@DeleteMapping("/deletarFarmaceutico/{id}")
//	public ResponseEntity<Farmaceutico> excluirFarmaceutico(@RequestBody Farmaceutico farmaceuticos, @PathVariable("id") Long id){
//		
//		todosFarmaceuticos.deleteById(id);
//
//        if (!isRemoved) {
//            return  ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return  ResponseEntity<>(id, HttpStatus.OK);
//   }
//		
	}
	
	
	
	
	
