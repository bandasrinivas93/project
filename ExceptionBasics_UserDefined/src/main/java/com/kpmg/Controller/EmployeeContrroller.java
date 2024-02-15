package com.kpmg.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kpmg.DTO.EmployeeDTO;
import com.kpmg.Exception.EmployeeRelatedExceptions;
import com.kpmg.Service.iEmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterStyle;
import jakarta.validation.Valid;

@RestController
@RequestMapping("empcon")
public class EmployeeContrroller {
	
	@Autowired
	private iEmployeeService employeeServiceimpl;
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeContrroller.class);

	
	@PostMapping("save")
	@Operation(parameters = {@Parameter(name = "EmployeeContrroller",description = "to save the data in db",style = ParameterStyle.FORM)})
	public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO edto)  {
		logger.trace("entered into save method, started");
		EmployeeDTO ed=employeeServiceimpl.save(edto);
		logger.info("entered into save method, ended--");
		return new ResponseEntity<EmployeeDTO>(ed, HttpStatus.OK);
	}
	
	
	@PutMapping("update")
	public ResponseEntity<EmployeeDTO> update(@Valid @RequestBody EmployeeDTO edto) throws EmployeeRelatedExceptions {
		logger.trace("entered into update method, --started--");
		EmployeeDTO empdto=employeeServiceimpl.update(edto);
		logger.info("entered into update method,---ended--");
		return new ResponseEntity<EmployeeDTO>(empdto, HttpStatus.OK);	
	}
	
}
