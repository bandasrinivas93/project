package com.kpmg.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.DTO.CustomerDTO;
import com.kpmg.Service.iCustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("custcon")
@Slf4j
public class CustomerController {
	
	@Autowired
	private iCustomerService customerserviceimpl;
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerController.class);
	@Operation(parameters = {@Parameter(name = "CustomerContrroller",description = "to save the data in db",style = ParameterStyle.FORM)})
	@PostMapping("save")
	public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO cdto) {
		
		logger.trace("entered into CustomerController save method--started");
		customerserviceimpl.save(cdto);
		logger.info("saved to data base");
		logger.trace("entered into CustomerController save method--completed");

		return new ResponseEntity<CustomerDTO>(cdto, HttpStatus.OK) ;	
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponseEntity<CustomerDTO>> findbylocationid(@PathVariable Integer id)
	{
		             ResponseEntity<CustomerDTO> cus = customerserviceimpl.getbyid(id);
		       
		       return ResponseEntity.status(HttpStatus.OK).body(cus);
	}
	
	
	@DeleteMapping("deletebyid/{id}")
	public ResponseEntity<ResponseEntity<CustomerDTO>> deletebyid(@PathVariable Integer id)
	{
		ResponseEntity<CustomerDTO> cus1 =  customerserviceimpl.deleteByall();
		    return ResponseEntity.status(HttpStatus.OK).body(cus1);
		    		
	}

	@PutMapping("update")
	public ResponseEntity<CustomerDTO> update(@Valid @RequestBody CustomerDTO cdto) {
		logger.trace("entered into update method, --started--");
		ResponseEntity<CustomerDTO> customerdto=customerserviceimpl.update(cdto);
		logger.info("entered into update method,---ended--");
		return new ResponseEntity<	CustomerDTO>(cdto, HttpStatus.OK);	
	
	
	}
	
	
	
	
	
	
}
	

