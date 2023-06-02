package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.BooksDao;
import model.entities.Books;

public class BooksDaoJDBC implements BooksDao {
	
	private Connection conn;
	
	public BooksDaoJDBC(Connection conn){
		this.conn = conn;
	}

	@Override
	public void insert(Books book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Books book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Books> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findByAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findByPublisher() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findByGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Books> findById() {
		// TODO Auto-generated method stub
		return null;
	}

}
