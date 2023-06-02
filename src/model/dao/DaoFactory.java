package model.dao;

import db.DB;
import model.dao.impl.BooksDaoJDBC;
import model.dao.impl.GenreDaoJDBC;

public class DaoFactory {
	public static BooksDao createBooksDao() {
		return new BooksDaoJDBC(DB.getConnection());
	}
	public static GenreDao createGenreDao() {
		return new GenreDaoJDBC(DB.getConnection());
	}
}
