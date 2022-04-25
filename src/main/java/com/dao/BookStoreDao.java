package com.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import com.bean.BookStore;
import com.bean.LogTable;
@SuppressWarnings("deprecation")
public class BookStoreDao {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");
	LocalDateTime now = LocalDateTime.now();
	String date = dtf.format(now).toString();
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
	LocalDateTime now1 = LocalDateTime.now();
	String time = dtf1.format(now1).toString();

	public int addBooks(BookStore bookstore) {
		try {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			LogTable log1 = new LogTable("Creation of book record", date, time);
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(bookstore);
			session.save(log1);
			tran.commit();

			return 1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public int deleteBook(int id) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		LogTable log2 = new LogTable("Deletion of book record", date, time);
		BookStore bs = session.get(BookStore.class, id);
		if (bs == null) {
			return 0;
		} else {
			tran.begin();
			session.delete(bs);
			session.save(log2);
			tran.commit();
			return 1;
		}
	}

	public int updateBook(BookStore bookstore) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		LogTable log3 = new LogTable("Updation of book record", date, time);
		BookStore bs = session.get(BookStore.class, bookstore.getBook_id());
		if (bs == null) {
			return 0;
		} else {
			tran.begin();
			bs.setBook_price(bookstore.getBook_price());
			bs.setSold_copies(bookstore.getSold_copies());
			session.update(bs);
			session.save(log3);
			tran.commit();
			return 1;
		}

	}

	public void retriveAllBooks() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Query qry = session.createQuery("select bs.book_id,bs.book_name from BookStore bs");
		Transaction tran = session.getTransaction();
		tran.begin();
		tran.commit();
		List listOfBooks = qry.list();
		Iterator itr = listOfBooks.iterator();
		System.out.println("Book Information");
		while (itr.hasNext()) {
			Object a[] = (Object[]) itr.next();
			System.out.println(a[0] + " " + a[1]);
		}
	}

	public void countOfBooks() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		LogTable log5 = new LogTable("Counting of book records", date, time);
		Query qry = session.createQuery("select count(distinct bs.book_id) from BookStore bs");
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(log5);
		tran.commit();
		Iterator count = qry.iterate();
		System.out.println("Total number of Book:" + count.next());
	}

	public void findBookByGenereType(String genere_type) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		LogTable log6 = new LogTable("Finding the book record by genere type", date, time);
		Query qry = session
				.createQuery("select bs.book_id,bs.book_name from BookStore bs where book_GenereType like:a");
		qry.setParameter("a", genere_type);
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(log6);
		tran.commit();
		List listOfBooksOfGenere = qry.list();
		if (listOfBooksOfGenere.isEmpty()) {
			System.out.println("No Book Found of these Genere Type");
		} else {
			Iterator itr = listOfBooksOfGenere.iterator();
			while (itr.hasNext()) {
				Object a[] = (Object[]) itr.next();
				System.out.println(a[0] + " " + a[1]);
			}
		}
	}

	public List<BookStore> retriveById(int book_id) {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		LogTable log6 = new LogTable("Retriving the book information", date, time);
		Query qry = session.createQuery("from BookStore where book_id like:a");
		qry.setParameter("a", book_id);
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(log6);
		tran.commit();
		// List listOfBooksOfId = qry.list();
		List<BookStore> listOfBooksOfId = qry.list();
		return listOfBooksOfId;
	}

	public void findBooksByLtoHPrice() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		LogTable log7 = new LogTable("Arranging the books from low to high price", date, time);
		Query qry = session.createQuery("select bs.book_name,bs.book_price from BookStore bs order by book_price ASC");
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(log7);
		tran.commit();
		List booksByLToH = qry.list();
		if (booksByLToH.isEmpty()) {
			System.out.println("No Book Available");
		} else {
			Iterator itr = booksByLToH.iterator();
			while (itr.hasNext()) {
				Object a[] = (Object[]) itr.next();
				for (int i = 0; i < a.length; i++) {
					for (int j = i + 1; j < a.length; j++) {
						System.out.println(a[i] + " " + "price " + a[j]);
					}
				}
			}
		}
	}

	public void findBooksByHtoLPrice() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		LogTable log8 = new LogTable("Arranging the books from high price to low price", date, time);
		Query qry = session.createQuery("select bs.book_name,bs.book_price from BookStore bs order by book_price DESC");

		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(log8);
		tran.commit();
		List booksByHToL = qry.list();
		if (booksByHToL.isEmpty()) {
			System.out.println("No Book Available");
		} else {
			Iterator itr = booksByHToL.iterator();
			while (itr.hasNext()) {
				Object a[] = (Object[]) itr.next();
				for (int i = 0; i < a.length; i++) {
					for (int j = i + 1; j < a.length; j++) {
						System.out.println(a[i] + " " + "price " + a[j]);
					}
				}
			}

		}
	}

	public List<String> findMostSellingBook() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		LogTable log9 = new LogTable("Finding the most selling book", date, time);
		Query qry = session.createQuery(
				"select bs.book_name from BookStore bs where sold_copies in(select MAX(sold_copies) from BookStore bs)");
		List<String> mostselling = qry.list();
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(log9);
		tran.commit();
		return mostselling;
	}

	public List<LogTable> displayLogInformation() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		LogTable log10 = new LogTable("Displaying the log Information", date, time);
		Query qry = session.createQuery("from LogTable");
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(log10);
		tran.commit();
		List<LogTable> listOfLogs = qry.list();
		return listOfLogs;
	}
}
