package com.imooc.employee.Dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;


public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public void addDepartment(Department department) {
		
		getHibernateTemplate().save(department);
		
		
	}

	@Override
	public List<Department> findByPage(int begin,int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		List<Department> lists=this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		if(lists!=null&&lists.size()>0){
			return lists;
		}
		
		return null;
	}

	@Override
	public int findCount() {
		
		String sql="select count(*) from Department";
		List<Long> list=this.getHibernateTemplate().find(sql);
		if(list!=null&&list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public void modify(Department department) {
		
		
		this.getHibernateTemplate().update(department);
		
	}

	@Override
	public Department findById(Integer id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, id);
	}

	@Override
	public void delete(Department department) {

		Department department2=findById(department.getDid());

		this.getHibernateTemplate().delete(department2);
		
	}

	public List<Department> findAll(){
		String sql="from Department";
		@SuppressWarnings("unchecked")
		List<Department> lists=this.getHibernateTemplate().find(sql);
		return lists;
	}
	
	
}
