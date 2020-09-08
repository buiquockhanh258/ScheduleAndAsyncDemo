/**
 * 
 */
package com.schedule.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author KhanhBQ3
 *
 */
@Component
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private String name;
	private double price;

	public Book() {
	}

	public Book(String isbn, String name, double price) {
		this.isbn = isbn;
		this.name = name;
		this.price = price;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + ", price=" + price + "]" + "\n";
	}

}
