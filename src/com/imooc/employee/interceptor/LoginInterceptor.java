package com.imooc.employee.interceptor;


import java.util.Map;

import com.imooc.employee.domain.Employee;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/*
 * 登录验证拦截器
 */
public class LoginInterceptor extends  MethodFilterInterceptor{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> sessionMap=invocation.getInvocationContext().getSession();
		Employee employee=(Employee)sessionMap.get("employee");
		if(employee!=null){
			return invocation.invoke();
		}
		return "input";
		
	}

	
	
}
