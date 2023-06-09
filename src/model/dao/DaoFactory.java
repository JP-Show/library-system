package model.dao;

import db.DB;
import model.dao.impl.AuthorDaoJDBC;
import model.dao.impl.BooksDaoJDBC;
import model.dao.impl.GenreDaoJDBC;
import model.dao.impl.PublisherDaoJDBC;

public class DaoFactory {
    public static BooksDao createBooksDao() {
        return new BooksDaoJDBC(DB.getConnection());
    }

    public static GenreDao createGenreDao() {
        return new GenreDaoJDBC(DB.getConnection());
    }

    public static PublisherDao createPublisherDao() {

        return new PublisherDaoJDBC(DB.getConnection());
    }
    public static AuthorDao createAuthorDao() {
        return new AuthorDaoJDBC(DB.getConnection());
    }

}
