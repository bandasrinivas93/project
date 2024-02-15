package com.kpmg.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.kpmg.DTO.CustomerDTO;

import jakarta.validation.Valid;



public interface iCustomerService {

	public abstract ResponseEntity<CustomerDTO> save(CustomerDTO cdto);
	public ResponseEntity<CustomerDTO> getbyid(Integer id);
	public ResponseEntity<CustomerDTO> getByall();
	public ResponseEntity<CustomerDTO> deleteByall();
	public  ResponseEntity<CustomerDTO> update(@Valid CustomerDTO cdto);
	
}