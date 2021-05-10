package com.tulun.library;

public class Book {
	private String bookName;
	private String bookPublish;
	private int  bookPrice;
	private int  bookNum;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookPublish() {
		return bookPublish;
	}
	public void setBookPublish(String bookPublish) {
		this.bookPublish = bookPublish;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public int getBookNum() {
		return bookNum;
	}
	
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	
	
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookPublish=" + bookPublish + ", bookPrice=" + bookPrice + ", bookNum="
				+ bookNum + "]";
	}
	
	public Book(String bookName, String bookPublish, int bookPrice, int bookNum) {
		this.bookName = bookName;
		this.bookPublish = bookPublish;
		this.bookPrice = bookPrice;
		this.bookNum = bookNum;
	}
	
}
