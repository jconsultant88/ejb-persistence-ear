package org.practise.ejb.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.practise.ejb.service.LibraryPersistentBeanRemote;

@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

	public LibraryPersistentBean() {
	}

	@PersistenceContext(unitName = "EjbComponentPU")
	private EntityManager entityManager;

	public void addBook(String bookName) {
		Book book = new Book();
		book.setName(bookName);
		entityManager.persist(book);
	}

	public List<String> getBooks() {

		List<Book> books = entityManager.createQuery("From Book")
				.getResultList();
		List<String> bookList = new ArrayList<String>();
		for (Book book : books) {
			bookList.add(book.getName());
		}
		return bookList;
	}
}
