package com.imooc.employee.action;

import java.util.List;

import com.imooc.employee.domain.Department;
import com.imooc.employee.domain.Employee;
import com.imooc.employee.domain.PageBean;
import com.imooc.employee.service.DepartmentService;
import com.imooc.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/*
 * 员工管理的Action类
 * 
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Employee employee=new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	private EmployeeService employeeService;
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	/*
	 * 登录执行的方法；
	 */
	public String login(){
		
		System.out.println("login运行了");
		Employee employee1=employeeService.login(employee);
		if(employee1!=null){
			ActionContext ctx=ActionContext.getContext();
			ctx.getSession().put("employee", employee1);
			return "success";
		}else{
			this.addActionError("用户名或密码错误");
			return "input";
		}
		
	}
	
	private Integer currentPage=1;
	
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//提供一个查询的方法
		public String findAll(){
			
			PageBean<Employee> pageBean=employeeService.findByPage(currentPage);
			
			if(pageBean!=null){
				ActionContext atx=ActionContext.getContext();
				atx.getValueStack().push(pageBean);
				return "listEmployee";
			}
			
			return "false";
		}

		private DepartmentService departmentService;
		
		public void setDepartmentService(DepartmentService departmentService) {
			this.departmentService = departmentService;
		}

		/*
		 * 提供一个返回添加页面的方法
		 */
		public String saveUi(){
			List<Department> departments=departmentService.findAll();
			ActionContext atx=ActionContext.getContext();
			atx.getSession().put("departments", departments);
			return "save";
			
		}
		
		/*
		 * 添加员工信息方法
		 */
		public String add(){
			
			employeeService.addEmployee(employee);
				return findAll();
			
		}

		/*
		 * 修改员工信息的返回方法
		 */
		public String modify(){
			
			Employee employee1=employeeService.findById(employee);
			List<Department> departments=departmentService.findAll();
			if(employee1!=null){
			ActionContext atx=ActionContext.getContext();
			atx.getSession().put("employee", employee1);
			atx.getSession().put("departments", departments);
			return "modify";
			}
			return "listEmployee";
		}
	
		/*
		 * 修改员工
		 */
		public String update(){
			
			employeeService.update(employee);
			return findAll();
		}
		
		public String delete(){
			
			employeeService.delete(employee);
			return findAll();
		}
	

	
}
