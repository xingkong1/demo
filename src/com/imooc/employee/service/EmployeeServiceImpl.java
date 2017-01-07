package com.imooc.employee.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imooc.employee.Dao.EmployeeDao;
import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;

/*
 * 员工管理的业务层实现类
 */
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public Employee login(Employee employee){
		 Employee employee2=employeeDao.login(employee);
		 if(employee2!=null){
			 return employee2;
		 }
		 System.out.println("查询对象为空");
		 return null;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		if(employee!=null){
		employeeDao.addEmployee(employee);
		return true;
		}
		return false;
	}
	
	@Override
	public PageBean<Employee> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		if(currentPage>0){
			PageBean<Employee> pageBean=new PageBean<>();
			pageBean.setCurrentPage(currentPage);
			
			int totalCount=employeeDao.findCount();
			pageBean.setTotalCount(totalCount);
			int begin=(currentPage-1)*pageBean.getPageSize();
			List<Employee> list=employeeDao.findByPage(begin,pageBean.getPageSize());
			Double num=Math.ceil((double)totalCount/(double)pageBean.getPageSize());
			pageBean.setTotalPage(num.intValue());
			pageBean.setList(list);
			return pageBean;
		}
		
		return null;
	}
	
	public Employee findById(Employee employee){
		if(employee.getEid()!=null){
		return employeeDao.findById(employee);
		}
		return null;
	}
	
	public void update(Employee employee){
		
		employeeDao.update(employee);
	}
	
	public void delete(Employee employee){
		employeeDao.delete(employee);
	}
}
