package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookStore {
	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int book_id;
	@Column(name = "book_name")
	private String book_name;
	@Column(name = "book_GenereType")
	private String generetype;
	@Column(name = "book_Author")
	private String book_author;
	@Column(name = "book_description")
	private String book_description;
	@Column(name = "book_price")
	private int book_price;
	@Column(name = "sold_copies")
	private int sold_copies;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getGeneretype() {
		return generetype;
	}

	public void setGeneretype(String generetype) {
		this.generetype = generetype;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_description() {
		return book_description;
	}

	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public int getSold_copies() {
		return sold_copies;
	}

	public void setSold_copies(int sold_copies) {
		this.sold_copies = sold_copies;
	}

	@Override
	public String toString() {
		String newline = System.lineSeparator();
		return "Book name:- " + book_name + newline + "Book Genere:- " + generetype + newline + "Book Author:- "
				+ book_author + newline + "Book description:- " + book_description + newline + "Book Price:- "
				+ book_price + newline + "number of copies sold:- " + sold_copies;
	}

	public BookStore(String book_name, String generetype, String book_author, String book_description, int book_price,
			int sold_copies) {
		super();
		this.book_name = book_name;
		this.generetype = generetype;
		this.book_author = book_author;
		this.book_description = book_description;
		this.book_price = book_price;
		this.sold_copies = sold_copies;
	}

}