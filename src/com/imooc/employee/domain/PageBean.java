package com.imooc.employee.domain;

import java.util.List;

/*
 * 分页封装类
 */

public class PageBean<T> {

	
	private int currentPage;
	private int pageSize=5;
	private int totalCount;
	private int totalPage;
	private List<T> list;
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

	/*
	 * 根据当前对象中属性值计算并设置相关属性值
	 */
	public void count(){
		//计算总页数
		int totalPageTemp=this.totalCount/this.pageSize;
		int plus=(this.totalCount%this.pageSize)==0?0:1;
		totalPageTemp=totalPageTemp+plus;
		if(totalPageTemp<=0){
			totalPageTemp=1;
		}
		this.totalPage=totalPageTemp;
		
		//当前页数
		//总页数小于当前页数，应将当前页数设置为总页数
		if(this.totalPage<this.currentPage){
			this.currentPage=this.totalPage;
		}
		//当前页数小于1设置为1
		if(this.currentPage<1){
			this.currentPage=1;
		}
		
		
	}
	
	
}
