package model.dao;

import java.util.List;

import model.entities.Genre;

public interface GenreDao {
	void insert(Genre genre);
	void update(Genre genre);
	void deleteByName(String name);
	List<Genre> findAll();
}
