package com.imooc.employee.Dao;

import java.util.List;

import com.imooc.employee.domain.Employee;

/*
 * 员工管理的DAO层的接口
 */
public interface EmployeeDao {

	public Employee login(Employee employee);
	public void addEmployee(Employee employee);
	public List<Employee> findByPage(int begin,int pageSize);
	public int findCount();
	public Employee findById(Employee employee);
	public void update(Employee employee);
	public void delete(Employee employee);
}
