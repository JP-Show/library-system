package model.dao.impl;

import java.io.PipedReader;
import java.sql.*;
import java.util.List;

import db.DB;
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
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"INSERT INTO books (name, description, genre, id_publisher, publication_date, id_author) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS
			);
			st.setString(1, book.getName());
			st.setString(2, book.getDes());
			st.setString(3, book.getGenre());
			st.setInt(4, book.getPublisher().getId());
			st.setDate(5, java.sql.Date.valueOf(book.getPublication_date()));
			st.setInt(6, book.getAuthor().getId());

			st.executeUpdate();
			ResultSet rs = st.getGeneratedKeys();
			while(rs.next())
				book.setId(rs.getInt(1));
			DB.closeResultSet(rs);
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
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
