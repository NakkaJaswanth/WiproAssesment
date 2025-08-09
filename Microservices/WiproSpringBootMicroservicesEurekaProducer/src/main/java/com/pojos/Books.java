package com.pojos;

public class Books {
	Integer bookid;
	String bookanme;
	Double bookcost;
	public Books(Integer bookid, String bookanme, Double bookcost) {
	super();
	this.bookid = bookid;
	this.bookanme = bookanme;
	this.bookcost = bookcost;
	}
	public Integer getBookid() {
	return bookid;
	}
	public void setBookid(Integer bookid) {
	this.bookid = bookid;
	}
	public String getBookanme() {
	return bookanme;
	}
	public void setBookanme(String bookanme) {
	this.bookanme = bookanme;
	}
	public Double getBookcost() {
	return bookcost;
	}
	public void setBookcost(Double bookcost) {
	this.bookcost = bookcost;
	}
	@Override
	public String toString() {
	return "Books [bookid=" + bookid + ", bookanme=" + bookanme + ", 	bookcost=" + 	bookcost + "]";
	}
}
