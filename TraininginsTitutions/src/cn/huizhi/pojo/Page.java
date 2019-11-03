package cn.huizhi.pojo;

public class Page<T> {
	public Page() {
		super();
	}
	
	public Page(T t) {
		this.t = t;
	}
	
	private int currPage = 1;
	private int pageSize = 20;
	private int totalCount;
	private int totalPageCount;

	private T t;
	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
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
		if (totalCount > 0) {
			this.totalCount = totalCount;

			totalPageCount = totalCount % pageSize == 0 ? totalCount / pageSize
					: (totalCount / pageSize) + 1;
		}
	}
	
	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
