package com.nt.service;

import com.nt.model.Employee;

public interface IEmployeeMgmtService 
{

	public Iterable<Employee> getAllEmployees();
	public String registerEmployee(Employee emp);
	public Employee getEmployeebyNo(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployeeById(int eno);
	
}
