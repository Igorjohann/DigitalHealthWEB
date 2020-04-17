package com.digitalhealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalhealth.credenciais.CredenciaisFarmaceutico;
import com.digitalhealth.domain.Farmaceutico;

@Repository
public interface TodosFarmaceuticos extends JpaRepository<Farmaceutico, Long>{

	
	@Query ("from Farmaceutico where credenciaisFarmaceutico =:credenciaisFarmaceutico")
	Farmaceutico buscarUsuario(@Param("credenciaisFarmaceutico")CredenciaisFarmaceutico credenciaisFarmaceutico);

}
