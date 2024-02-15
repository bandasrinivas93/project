package com.kpmg.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.kpmg.DTO.EmployeeDTO;
import com.kpmg.Exception.EmployeeRelatedExceptions;

public interface iEmployeeService {

	
	public abstract EmployeeDTO save(EmployeeDTO edto) ;
	
	public abstract EmployeeDTO update(EmployeeDTO edto) throws EmployeeRelatedExceptions;
	
	public abstract void deletebyId(Integer eid);
	
	public abstract EmployeeDTO getbyId(Integer eid);
	
	public abstract List<EmployeeDTO> getAll();
	
	

}
