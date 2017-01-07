package com.imooc.employee.service;

import java.util.List;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;

/*
 * 部门管理的业务层
 */
public interface DepartmentService {

	public boolean addDepartment(Department department);
	public PageBean<Department> findByPage(int currentPage);
	public boolean modify(Department department);
	public Department findById(Integer id);
	public boolean delete(Department department);
	public List<Department> findAll();
}
