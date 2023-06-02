package model.dao;

import java.util.List;

import model.entities.Author;

public interface AuthorDao {
	void Insert(Author author);
	void update(Author author);
	void deleteById(Integer id);
	Author findById(Integer id);
	List<Author> findAll();
}
