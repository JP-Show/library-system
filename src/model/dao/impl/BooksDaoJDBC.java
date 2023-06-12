package model.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import db.DbException;
import model.dao.BooksDao;
import model.entities.Books;

public class BooksDaoJDBC implements BooksDao {
	
	private Connection conn;

	
	public BooksDaoJDBC(Connection conn){
		this.conn = conn;
	}


	@Override
	public void insert(Books book) {

	}

	@Override
	public void update(Books book) {

	}

	@Override
	public void deleteById(Integer id) {

	}

	@Override
	public void deleteByName(String name) {

	}

	@Override
	public List<Books> findAll() {
		return null;
	}

	@Override
	public List<Books> findByName(String name) {
		return null;
	}

	@Override
	public List<Books> findByAuthor(int id) {
		return null;
	}

	@Override
	public List<Books> findByPublisher(int id) {
		return null;
	}

	@Override
	public List<Books> findByGenre(String name) {
		return null;
	}

	@Override
	public Books findById(int id) {
		return null;
	}
}
