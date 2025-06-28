package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nt.model.Employee;
import com.nt.repo.IEmployeeRepository;

@Service("empService")
public class IEmployeeMgmtServiceImpl implements IEmployeeMgmtService 
{

	@Autowired
	private IEmployeeRepository empRepo;
	
	@Override
	public Iterable<Employee> getAllEmployees()
	{
		return empRepo.findAll();
	}
	
	@Override
	public String registerEmployee(Employee emp)
	{
		return "employee is saved with the id value:"+empRepo.save(emp).getEmpno();
	}
	
	@Override
	public Employee getEmployeebyNo(int eno)
	{
		Employee emp=empRepo.findById(eno).orElseThrow(()->new IllegalArgumentException());
	    return emp;
	}
	
	@Override
	public String updateEmployee(Employee emp)
	{
		return "Employee is updated with having  id value::"+empRepo.save(emp).getEmpno();
	}
	
	@Override
	public String deleteEmployeeById(int eno)
	{
		empRepo.deleteById(eno);
		return eno+" Employee is deleted successfully";
	}
}
