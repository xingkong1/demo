package com.imooc.employee.Dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.Employee;

/**
 * 
 * 员工管理的DAO层的实现类
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	/*
	 * 登录方法的DAO层实现
	 * 
	 */
	public Employee login(Employee employee){
		
		String sql="from Employee where username=? and password=?";
		List list=getHibernateTemplate().find(sql,employee.getUsername(),employee.getPassword());
		if(list!=null&&list.size()>0){
			return (Employee)list.get(0);
		}else{
	System.out.println("查询对象为空");
		return null;
		}
	}

	@Override
	public void addEmployee(Employee employee) {
		
		getHibernateTemplate().save(employee);
		
		
	}
	
	@Override
	public List<Employee> findByPage(int begin,int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(Employee.class);
		List<Employee> lists=this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		if(lists!=null&&lists.size()>0){
			return lists;
		}
		
		return null;
	}

	@Override
	public int findCount() {
		
		String sql="select count(*) from Employee";
		List<Long> list=this.getHibernateTemplate().find(sql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}
	
	public Employee findById(Employee employee){
		
		return this.getHibernateTemplate().get(Employee.class, employee.getEid());
	}
	
	public void update(Employee employee){
		
		this.getHibernateTemplate().update(employee);
	}
	
	public void delete(Employee employee){
		employee=findById(employee);
		this.getHibernateTemplate().delete(employee);
	}
	
	
}
