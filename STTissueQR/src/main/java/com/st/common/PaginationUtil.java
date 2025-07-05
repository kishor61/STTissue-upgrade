package com.st.common;

public class PaginationUtil {
	private int next;
	private int prev;
	private int last;
	private int first;
	private int total;


	public int getNext() {
		return next;
	}

	public int getPrev() {
		return prev;
	}

	public int getLast() {
		return last;
	}

	public int getFirst() {
		return first;
	}

	public int getTotal() {
		return total;
	}



	public void count(int pageNo, int totalRecord) {
		
		
		
		if (totalRecord > CommonProperties.DATA_PER_PAGE) {
			if (totalRecord % CommonProperties.DATA_PER_PAGE == 0) {
				total = totalRecord / CommonProperties.DATA_PER_PAGE;
			} else {
				total = (totalRecord / CommonProperties.DATA_PER_PAGE) + 1;
			}
		} else {
			total = 1;
		}
		
		if(pageNo!=total){
			next=pageNo+1;
			prev=pageNo-1;
		}else{
			next=total;
			prev=pageNo-1;
		}
		if(prev<1){
			prev=1;
		}
		if(next>total){
			next=total;
		}
		
		
		last=total;
		first=1;
	}
}
