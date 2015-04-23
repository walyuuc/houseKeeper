package com.chy.common;

import java.util.List;

public class Page {

	private Integer pageNo;

	private Integer pageSize;

	private Integer totalPage;

	private Integer totalCount;

	private List list;

	public Page() {
		pageNo = new Integer(1);
		pageSize = new Integer(10);
	}

	public Page(Integer pageNum, Integer pageSize) {
		this.pageNo = pageNum;
		this.pageSize = pageSize;
	}
	
	public Page(Integer pageNum, Integer pageSize, Integer totalCount) {
		this.pageNo = pageNum;
		this.pageSize = pageSize;
		this.totalCount=totalCount;
		init(pageSize, totalCount);
	}

	public Integer getPageNo() {
		if (null == this.pageNo || this.pageNo < 1) {
			return pageNo = 1;
		} else {
			return pageNo;
		}
	}

	public void setPageNo(Integer pageNum) {
		this.pageNo = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Integer getFirstResult() {
		return pageSize * (pageNo - 1);
	}

	public void check() {
		if (pageNo <= 0) {
			pageNo = 1;
		}
		if (pageNo > totalPage) {
			pageNo = totalPage;
		}
	}

	public void init(Integer pageSize, Integer count) {
		this.pageSize = pageSize;
		this.totalCount = count;
		Integer totalPage = (int) Math
				.ceil((double) this.totalCount / pageSize);
		this.totalPage = totalPage;
		check();
	}

}
