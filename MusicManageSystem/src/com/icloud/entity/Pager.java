package com.icloud.entity;

import java.util.List;

public class Pager{
  private int pageIndex;//当前页码
  private int pageTotal;//总页码
  private int dataCount;//总条数
  private int pageSize;//每页显示条数
  private String hql;//分页语句    
  private List<?> list;//返回的数据集合
  
	public int getPageIndex() {
		return pageIndex;
	}
	
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getHql() {
		return hql;
	}
	public void setHql(String hql) {
		this.hql = hql;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Pager [pageIndex=" + pageIndex + ", pageTotal=" + pageTotal + ", dataCount=" + dataCount + ", pageSize="
				+ pageSize + ", hql=" + hql + ", list=" + list + "]";
	}
}
