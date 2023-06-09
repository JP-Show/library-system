package model.dao;

import java.util.List;

import model.entities.Books;

public interface BooksDao {
	void insert(Books book);
	void update(Books book);
	void deleteById(Integer id);
	void deleteByName(String name);
	List<Books> findAll();
	List<Books> findByName(String name);
	List<Books> findByAuthor( int id);
	List<Books> findByPublisher(int id);
	List<Books> findByGenre(String name);
	Books findById(int id);
}
