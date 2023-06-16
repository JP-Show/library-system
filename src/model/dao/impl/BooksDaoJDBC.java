package model.dao.impl;

import java.io.PipedReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.BooksDao;
import model.dao.utils.BooksDaoUtils;
import model.entities.Author;
import model.entities.Books;
import model.entities.Publisher;

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
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"UPDATE `library_bd`.`books` " +
							"SET `name` = ?, `description` =?, `genre` = ?, `id_publisher` =?, `publication_date` = ?, `id_author` = ? WHERE `id` = ?;"
			);
			st.setString(1, book.getName());
			st.setString(2, book.getDes());
			st.setString(3, book.getGenre());
			st.setInt(4, book.getPublisher().getId());
			st.setDate(5, java.sql.Date.valueOf(book.getPublication_date()));
			st.setInt(6, book.getAuthor().getId());
			st.setInt(7, book.getId());

			st.executeUpdate();
		}catch(SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"DELETE FROM books WHERE id = ?"
			);
			st.setInt(1, id);
			st.executeUpdate();
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteByName(String name) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"DELETE FROM books WHERE name = ?"
			);
			st.setString(1, name);
			st.executeUpdate();
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Books> findAll() {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"SELECT * FROM books JOIN publisher AS pub ON pub.id = id_publisher JOIN author ON id_author = author.id;"
			);
			ResultSet rs = st.executeQuery();
			List<Books> list = new ArrayList<>();
			while(rs.next())
				list.add(new Books(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getString("genre"),
						new Publisher(
								rs.getInt("id_publisher"),
								rs.getString("pub.name")),
						rs.getDate("publication_date").toLocalDate(),
						new Author(
								rs.getInt("id_author"),
								rs.getString("author.name"),
								rs.getDate("author.born").toLocalDate(),
								rs.getDate("author.died") != null  ? rs.getDate("author.died").toLocalDate() : null,
								null
						)
				));
			DB.closeResultSet(rs);
			return list;
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
		DB.closeStatement(st);
		}
	}

	@Override
	public List<Books> findByName(String name) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"SELECT * FROM books JOIN publisher AS pub ON pub.id = id_publisher JOIN author ON id_author = author.id WHERE books.name = ?;"
			);
			st.setString(1, name);
			ResultSet rs = st.executeQuery();
			List<Books> list = new ArrayList<>();
			while(rs.next())
				list.add(new Books(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getString("genre"),
						new Publisher(
								rs.getInt("id_publisher"),
								rs.getString("pub.name")),
						rs.getDate("publication_date").toLocalDate(),
						new Author(
								rs.getInt("id_author"),
								rs.getString("author.name"),
								rs.getDate("author.born").toLocalDate(),
								rs.getDate("author.died") != null  ? rs.getDate("author.died").toLocalDate() : null,
								null
						)
				));
			DB.closeResultSet(rs);
			return list;
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Books> findByAuthor(int id) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"SELECT * FROM books JOIN publisher AS pub ON id_publisher = pub.id JOIN author ON id_author = author.id WHERE author.id = ?;"
			);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			List<Books> list = new ArrayList<>();
			while(rs.next())
				list.add(new Books(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getString("genre"),
						new Publisher(
								rs.getInt("id_publisher"),
								rs.getString("pub.name")),
						rs.getDate("publication_date").toLocalDate(),
						new Author(
								rs.getInt("id_author"),
								rs.getString("author.name"),
								rs.getDate("author.born").toLocalDate(),
								rs.getDate("author.died") != null  ? rs.getDate("author.died").toLocalDate() : null,
								null
						)
				));
			DB.closeResultSet(rs);
			return list;
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Books> findByPublisher(int id) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"SELECT * FROM books JOIN publisher AS pub ON pub.id = id_publisher JOIN author ON id_author = author.id WHERE books.id_publisher = ?;"
			);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			List<Books> list = new ArrayList<>();
			while(rs.next())
				list.add(new Books(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getString("genre"),
						new Publisher(
								rs.getInt("id_publisher"),
								rs.getString("pub.name")),
						rs.getDate("publication_date").toLocalDate(),
						new Author(
								rs.getInt("id_author"),
								rs.getString("author.name"),
								rs.getDate("author.born").toLocalDate(),
								rs.getDate("author.died") != null  ? rs.getDate("author.died").toLocalDate() : null,
								null
						)
				));
			DB.closeResultSet(rs);
			return list;
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Books> findByGenre(String name) {
		PreparedStatement st = null;
		try{
			String genre = BooksDaoUtils.refactorGenreStringToStringForSQL(name);
			st = conn.prepareStatement(
					"SELECT * FROM books JOIN publisher AS pub ON pub.id = id_publisher JOIN author ON id_author = author.id WHERE books.genre LIKE " + genre +" ;"
			);
			ResultSet rs = st.executeQuery();
			List<Books> list = new ArrayList<>();
			while(rs.next())
				list.add(new Books(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getString("genre"),
						new Publisher(
								rs.getInt("id_publisher"),
								rs.getString("pub.name")),
						rs.getDate("publication_date").toLocalDate(),
						new Author(
								rs.getInt("id_author"),
								rs.getString("author.name"),
								rs.getDate("author.born").toLocalDate(),
								rs.getDate("author.died") != null  ? rs.getDate("author.died").toLocalDate() : null,
								null
						)
				));
			DB.closeResultSet(rs);
			return list;
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Books findById(int id) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"SELECT * FROM books JOIN publisher AS pub ON pub.id = id_publisher JOIN author ON id_author = author.id WHERE books.id = ?;"
			);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			Books book = null;
			if(rs.next())
				book = new Books(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getString("description"),
						rs.getString("genre"),
						new Publisher(
								rs.getInt("id_publisher"),
								rs.getString("pub.name")),
						rs.getDate("publication_date").toLocalDate(),
						new Author(
								rs.getInt("id_author"),
								rs.getString("author.name"),
								rs.getDate("author.born").toLocalDate(),
								rs.getDate("author.died") != null  ? rs.getDate("author.died").toLocalDate() : null,
								null
						)
					);
			DB.closeResultSet(rs);
			return book;
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}
}
