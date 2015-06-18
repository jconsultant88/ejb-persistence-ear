package org.practise.ejb.service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibraryPersistentBeanRemote {

	void addBook(String bookName);

	List<String> getBooks();

}
