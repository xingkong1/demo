package com.imooc.employee.service;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;

/**
 * 
 * 员工管理的业务层接口
 *
 */
public interface EmployeeService {

	public Employee login(Employee employee);
	public boolean addEmployee(Employee employee);
	public PageBean<Employee> findByPage(int currentPage);
	public Employee findById(Employee employee);
	public void update(Employee employee);
	public void delete(Employee employee);
}

