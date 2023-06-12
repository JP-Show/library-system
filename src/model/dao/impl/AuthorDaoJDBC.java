package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.AuthorDao;
import model.dao.BooksDao;
import model.dao.DaoFactory;
import model.entities.Author;
import model.entities.Books;

import java.sql.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class AuthorDaoJDBC implements AuthorDao {

    private final Connection conn;
    private final BooksDao booksDao = DaoFactory.createBooksDao();

    public AuthorDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Author author) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO author (name, born, died) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, author.getName());
            st.setDate(2, java.sql.Date.valueOf(author.getBorn()));
            if (author.getDied() == null) {
                st.setDate(3, null);
            } else {
                st.setDate(3, java.sql.Date.valueOf(author.getDied()));

            }
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            while (rs.next()) {
                author.setId(rs.getInt(1));
            }
            DB.closeResultSet(rs);
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Author author) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "UPDATE author SET name = ?, born = ?, died = ? WHERE id = ?"
            );
            st.setString(1, author.getName());
            st.setDate(2, java.sql.Date.valueOf(author.getBorn()));
            if (author.getDied() == null) {
                st.setDate(3, null);
            } else {
                st.setDate(3, java.sql.Date.valueOf(author.getDied()));
            }
            st.setInt(4, author.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "DELETE FROM author WHERE id = ?"
            );
            st.setInt(1, id);
            st.executeUpdate();
        }catch(SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public Author findById(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM author WHERE id = ?"
            );
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next())
                return new Author(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("born").toLocalDate(),
                        rs.getDate("died") != null  ? rs.getDate("died").toLocalDate() : null ,
                        booksDao.findByAuthor(id));
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Author> findAll() {
        return null;
    }
}
