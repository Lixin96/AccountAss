package util;

import java.util.List;

public class PageData {
	private int totalnum;//总数据
	private int pagecount;//总页数
	private List ListData;//分页数据
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public List getListData() {
		return ListData;
	}
	public void setListData(List listData) {
		ListData = listData;
	}
	
	
}
