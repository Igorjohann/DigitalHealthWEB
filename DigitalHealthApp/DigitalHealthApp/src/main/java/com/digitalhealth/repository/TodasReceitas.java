package com.digitalhealth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalhealth.domain.Paciente;
import com.digitalhealth.domain.Receita;



@Repository
public interface TodasReceitas extends JpaRepository<Receita,Long> {

	
	@Query("select o from Receita o where o.id =:id")
	public  Receita buscarReceita(@Param("id") Long id);

	

	@Query("select o from Receita o where o.pacientes.id = :id")
	public  List<Receita> buscarReceitaPorPaciente(@Param("id") Long id);



//	public List<Receita> buscarReceitaPorCpf(String cpfPaciente);



//	@Query("Select o from Receita o where o.Pacientes.credenciaispaciente.cpfPaciente = :cpfPaciente")
//	 List<Receita> buscarReceitaPorCpf(@Param("cpfPaciente") String cpfpaciente);
//	
	
}
