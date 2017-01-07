package com.imooc.employee.Dao;

import java.util.List;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;

/*
 * ���Ź����Dao��ӿ�
 */
public interface DepartmentDao {

	public void addDepartment(Department department);
	public List<Department> findByPage(int begin,int pageSize);
	public int findCount();
	public void modify(Department department);
	public Department findById(Integer id);
	public void delete(Department department);
	public List<Department> findAll();
}
