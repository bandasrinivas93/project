package com.kpmg.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	private Integer cid;
	private String cname;
	private Double camount;
	private String clocation;
	
	
	
}
