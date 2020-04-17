package com.digitalhealth.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.digitalhealth.domain.Paciente;
import com.digitalhealth.domain.Receita;
import com.digitalhealth.repository.TodasReceitas;
import com.digitalhealth.repository.TodosMedicos;
import com.digitalhealth.repository.TodosPacientes;
import com.digitalhealth.view.ReceitaResponse;

@CrossOrigin
@RestController
public class ReceitasController {

	private TodasReceitas todasReceitas;
	private TodosMedicos todosmedicos;
	private TodosPacientes todospacientes;

	@Autowired
	public ReceitasController(TodasReceitas todasReceitas, TodosMedicos todosmedicos, TodosPacientes todospacientes) {
		super();
		this.todasReceitas = todasReceitas;
		this.todosmedicos = todosmedicos;
		this.todospacientes = todospacientes;
	}

	@PostMapping("/cadastroReceita")
	public ResponseEntity cadastro(@RequestBody Receita receita) {

		String cpfPaciente = receita.getPacientes().getcredenciaisPaciente().getCpfPaciente();
		Optional<Paciente> paciente = todospacientes.encontrarPacienteCpf(cpfPaciente);

		if (paciente.isPresent()) {
			receita.setPacientes(paciente.get());
			todasReceitas.save(receita);
			
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().header("msg", "Paciente com CPF "+cpfPaciente+" não encontrado").build();
		}

		// receita.setMedico(todosmedicos.getOne(receita.getMedico().getId()));

	}

	@GetMapping("/obterReceita/{id}")
	public ResponseEntity<Receita> obterReceitaPorId(@PathVariable("id") Long id) {
		// list
		Optional<Receita> receitaCadastrada = todasReceitas.findById(id);
		if (receitaCadastrada.isPresent()) {

			return ResponseEntity.ok(receitaCadastrada.get());
		}

		return ResponseEntity.noContent().build();

	}

	///////// ---------------- OBTER RECEITA POR CPF

	@GetMapping("/receitas/cpf/{cpfPaciente}")
	public ResponseEntity<List<ReceitaResponse>> getReceitaByCpf(@PathVariable("cpfPaciente") String cpfPaciente) {
		List<Paciente> pacientesProcurados = todospacientes.encontrarPorCpf(cpfPaciente);

		if (pacientesProcurados != null && pacientesProcurados.size() > 0) {
			Paciente pacienteProcurado = pacientesProcurados.get(0);

			System.out.println("\n\n\n\nQtdReceitas: " + pacienteProcurado.getReceitas().size() + "\n\n\n\n");

			// return ResponseEntity.ok(null);
			return ResponseEntity.ok(ReceitaResponse.criarLista(pacienteProcurado.getReceitas()));
		}

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
	}
	// -----------------------------------------------------------------------------------------

}
