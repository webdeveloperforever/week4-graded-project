package com.service;

import java.util.List;

import com.bean.BookStore;
import com.bean.LogTable;
import com.dao.BookStoreDao;

public class BookStoreService {
	public String addBook(BookStore bookstore) {
		BookStoreDao bsd = new BookStoreDao();
		if (bsd.addBooks(bookstore) > 0) {
			return "Book Record inserted successfully";
		} else {
			return "Book Record didn't store";
		}
	}

	public String deleteBook(int id) {
		BookStoreDao bs = new BookStoreDao();
		if (bs.deleteBook(id) > 0) {
			return "Book Deleted!";
		} else {
			return "Book not present";
		}
	}

	public String updateBook(BookStore bookstore) {
		BookStoreDao bs = new BookStoreDao();
		if (bs.updateBook(bookstore) > 0) {
			return "Book Updated!";
		} else {
			return "Book not Updated";
		}
	}

	public void retriveAllBooks() {
		BookStoreDao bs = new BookStoreDao();
		bs.retriveAllBooks();
	}

	public void totalBooksCount() {
		BookStoreDao bs = new BookStoreDao();
		bs.countOfBooks();
	}

	public void findBookByGenere(String genere_type) {
		BookStoreDao bs = new BookStoreDao();
		bs.findBookByGenereType(genere_type);
	}

	public List<BookStore> retriveById(int book_id) {
		BookStoreDao bs = new BookStoreDao();
		return bs.retriveById(book_id);
	}

	public void findBooksByLtoHPrice() {
		BookStoreDao bs = new BookStoreDao();
		bs.findBooksByLtoHPrice();
	}

	public void findBooksByHtoLPrice() {
		BookStoreDao bs = new BookStoreDao();
		bs.findBooksByHtoLPrice();
	}

	public List<String> findMostSellingBook() {
		BookStoreDao bs = new BookStoreDao();
		return bs.findMostSellingBook();
	}

	public List<LogTable> displayLogInformation() {
		BookStoreDao bs = new BookStoreDao();
		return bs.displayLogInformation();
	}
}
