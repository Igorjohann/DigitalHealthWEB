package com.digitalhealth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digitalhealth.domain.Farmacia;

@Repository
public interface TodasFarmacias extends JpaRepository<Farmacia, Long> {

}
