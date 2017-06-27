package com.ooad.bookstore.model;

/***
 * 
 * @author VikneshKumar
 *
 */

public class BookDetails {

	private String ISBN;
	private String book;
	private String type;
	private String availability;
	private String price;
	private boolean wishList;
	private boolean select;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public boolean isWishList() {
		return wishList;
	}

	public void setWishList(boolean wishList) {
		this.wishList = wishList;
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}
}
