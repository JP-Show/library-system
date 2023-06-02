package model.dao;

import java.util.List;

import model.entities.Books;

public interface BooksDao {
	void insert(Books book);
	void update(Books book);
	void deleteById(Integer id);
	void deleteByName(String name);
	List<Books> findAll();
	List<Books> findByName();
	List<Books> findByAuthor();
	List<Books> findByPublisher();
	List<Books> findByGenre();
	List<Books> findById();
}
