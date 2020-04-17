package com.digitalhealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalhealth.credenciais.CredenciaisMedicos;
import com.digitalhealth.domain.Medico;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface TodosMedicos extends JpaRepository<Medico,Long> {
	
	@Query ("from Medico where credenciais =:credenciais")
	Medico buscarUsuario(@Param("credenciais")CredenciaisMedicos credenciais);
	


	//Medico findByCredenciais(CredenciaisMedicos credenciaisMedicos);

}
