package com.imooc.employee.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.imooc.employee.Dao.DepartmentDao;
import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	
	private DepartmentDao departmentDao;
	
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}


	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}


	@Override
	public boolean addDepartment(Department department) {
		if(department!=null){
		departmentDao.addDepartment(department);
		return true;
		}
		return false;
	}


	@Override
	public PageBean<Department> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		if(currentPage>0){
			PageBean<Department> pageBean=new PageBean<>();
			pageBean.setCurrentPage(currentPage);
			
			int totalCount=departmentDao.findCount();
			pageBean.setTotalCount(totalCount);
			int begin=(currentPage-1)*pageBean.getPageSize();
			List<Department> list=departmentDao.findByPage(begin,pageBean.getPageSize());
			Double num=Math.ceil((double)totalCount/(double)pageBean.getPageSize());
			pageBean.setTotalPage(num.intValue());
			pageBean.setList(list);
			return pageBean;
		}
		
		return null;
	}


	@Override
	public boolean modify(Department department) {
		
		if(department!=null){
			if(department.getDid()==null){
				System.out.println("id为空");
				return false;
			}
			departmentDao.modify(department);
			return true;
		}
		return false;
	}


	@Override
	public Department findById(Integer id) {
		if(id!=null){
			return departmentDao.findById(id);
		}
		return null;
	}


	@Override
	public boolean delete(Department department) {

		if(department.getDid()!=null){
			departmentDao.delete(department);
			return true;
		}
		return false;
	}
	
	public List<Department> findAll(){
		List<Department> list=departmentDao.findAll();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

}
