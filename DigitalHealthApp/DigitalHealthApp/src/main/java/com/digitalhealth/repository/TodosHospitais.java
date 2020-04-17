package com.digitalhealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalhealth.domain.Hospital;

public interface TodosHospitais  extends JpaRepository<Hospital, Long>{

}
