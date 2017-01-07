package com.imooc.employee.action;


import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 部门管理的Action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	private Department department = new Department();

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}

	private DepartmentService departmentService;

	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	private Integer currentPage=1;
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	/*
	 * 添加部门Action层的方法
	 */
	public String add() {

		if(departmentService.addDepartment(department)){
			
			return findAll();
		}
		   return "false";
	}
	
	//提供一个查询的方法
	public String findAll(){
		
		PageBean<Department> departments=departmentService.findByPage(currentPage);
		
		if(departments!=null){
			ActionContext atx=ActionContext.getContext();
			atx.getValueStack().push(departments);
			return "success";
		}
		
		return "false";
	}
	
	public String modify(){
		System.out.println("执行了");
		if(departmentService.modify(department)){
			return findAll();
		}
		return "false";
	}
	
	public String edit(){
		
		department=departmentService.findById(department.getDid());
		
		ActionContext atx=ActionContext.getContext();
		atx.getSession().put("department", department);
		return "editSuccess";
	}
	
	public String delete(){
		
		if(departmentService.delete(department)){
			return findAll();
		}
		return "false";
	}
	
	

}
