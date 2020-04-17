package com.digitalhealth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Remedios {
	
	@Id
	@GeneratedValue
	@Column(name = "idRemedio")
	private Long id;

}
