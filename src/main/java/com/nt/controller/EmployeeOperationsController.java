package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeMgmtService empService;
	
	@GetMapping("/")
	public String showHome()
	{
		return "home";
	}
	@GetMapping("/emp_report")
	public String showEmployeeReport(Map<String,Object> map)
	{
		//use service 
		Iterable<Employee> itEmps=empService.getAllEmployees();
		//put the result in model attribute
		map.put("empList", itEmps);
		//return LVN
		return "Show_Employee_Report";
	}
	
	@GetMapping("/emp_add")
	public String showFormForsaveEmployee(@ModelAttribute("emp") Employee emp)
	{
		return "register_employee";
	}
	
	@PostMapping("/emp_add")
	public String saveEmployee(@ModelAttribute("emp") Employee emp,Map<String,Object> map)
	{
		//use Service
		String msg=empService.registerEmployee(emp);
		Iterable<Employee> itEmps=empService.getAllEmployees();
		//keep the result in the Model Attribute
		map.put("resultmsg", msg);
		map.put("empList", itEmps);
		
		//return LVN
		return "Show_Employee_Report";
		
	}
	
	@GetMapping("emp_edit")
	public String showEditEmployeeFormPage(@RequestParam("no") int no,@ModelAttribute("emp") Employee emp)
	{
		//use service
		Employee emp1=empService.getEmployeebyNo(no);
		//copy data
		BeanUtils.copyProperties(emp, emp1);
		//return LVN
		return "update_employee";
	}
	
	@PostMapping("/emp_edit")
	public String editEmployee(RedirectAttributes attrs,@ModelAttribute("emp") Employee emp)
	{
		//use service
		String msg=empService.updateEmployee(emp);
		//add the result message as Flash Attribute
		attrs.addFlashAttribute("resultMsg",msg);
		//redirect the redirect 
	    return "redirect:emp_report";
	}
	
	@GetMapping("/emp_delete")
	public String deleteEmployee(RedirectAttributes attrs,@RequestParam int no)
	{
		//use service 
		String msg=empService.deleteEmployeeById(no);
		//keep the result in FlashAttribute
		attrs.addAttribute("resultMsg", msg);
		//redirect the request
		return "redirect:emp_report";
	}
}
