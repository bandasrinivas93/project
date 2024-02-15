package com.kpmg.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.kpmg.DTO.EmployeeDTO;
import com.kpmg.Dao.EmployeeRepository;
import com.kpmg.Entity.Employee;
import com.kpmg.Exception.EmployeeRelatedExceptions;
import com.kpmg.Service.iEmployeeService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements iEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger logger=LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public EmployeeDTO save(EmployeeDTO edto)  {
		
		logger.trace("entered into save method");
		Employee emp=modelMapper.map(edto, Employee.class);
		logger.info("converted from DTO to Entity");
		
		try {
			
			employeeRepository.save(emp);
			logger.info("successfully saved to data base");
			
		}catch (DataAccessException e) {
			logger.info("entered into catch block");
			logger.error("database issue, please check the connection");
			try {
			EmployeeRelatedExceptions empexc = new EmployeeRelatedExceptions("could not connect to database, please try again after some time");
			throw empexc;
			}catch(EmployeeRelatedExceptions ere){
				logger.info("entered into catch block of EmployeeRelatedExceptions");
				
				logger.error(ere.getMessage());
				ere.printStackTrace();
			}
		}
		logger.trace("iam out of catch block");
		return edto;
	}

	@Override
	public EmployeeDTO update(EmployeeDTO edto) throws EmployeeRelatedExceptions {
		
		logger.trace("entered into update method");
		logger.debug("entered into update method="+edto);
		Employee emp=modelMapper.map(edto, Employee.class);
		logger.trace("converted from DTO to Entity");

		Optional<Employee> data=null;
		
		try {
			
			//data=employeeRepository.findById(null);
			
			logger.debug("eid value is=="+emp.getEid());
			
			data = employeeRepository.findById(emp.getEid());
			logger.info("data fetched from data base");
		} catch (DataAccessException e) {
			logger.warn("couldn't not connect to data base");
			//EmployeeRelatedExceptions exp = new EmployeeRelatedExceptions("could not connect to database, please try again after some time");
			//throw exp;
		}
		 
		if(data.isPresent()) {
			logger.info("trying to updating the data");
			try {
			Employee em=employeeRepository.save(emp);
			
			logger.info("successfully updated the data");

			}catch(DataAccessException e) {
				logger.warn("couldn't not connect to data base");
				EmployeeRelatedExceptions exp = new EmployeeRelatedExceptions("could not connect to database, please try again after some time");
				throw exp;
			}
			return edto;
		}else {
			logger.info("trying to save the data");
			try {
			employeeRepository.save(emp);
			logger.info("successfully saved the data");
			}catch(DataAccessException e) {
				logger.warn("couldn't not connect to data base");
				EmployeeRelatedExceptions exp = new EmployeeRelatedExceptions("could not connect to database, please try again after some time");
				throw exp;
			}
			return edto;
		}
	}

	@Override
	public void deletebyId(Integer eid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeDTO getbyId(Integer eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
