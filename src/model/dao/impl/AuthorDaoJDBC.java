package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.AuthorDao;
import model.entities.Author;

import java.sql.*;
import java.util.List;

public class AuthorDaoJDBC implements AuthorDao {

    private final Connection conn;

    public AuthorDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Author author) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO author (name, born, died) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1,author.getName());
            st.setDate(2, java.sql.Date.valueOf(author.getBorn()));
            st.setDate(3, java.sql.Date.valueOf(author.getDied()));
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            while(rs.next()){
                author.setId(rs.getInt(1));
            }
            DB.closeResultSet(rs);
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally{
        DB.closeStatement(st);
        }
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Author findById(Integer id) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return null;
    }
}
