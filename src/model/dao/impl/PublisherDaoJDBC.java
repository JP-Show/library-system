package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.PublisherDao;
import model.entities.Publisher;

import javax.xml.transform.sax.TransformerHandler;
import java.sql.*;
import java.util.List;

public class PublisherDaoJDBC implements PublisherDao {
    private Connection conn = DB.getConnection();
    @Override
    public void insert(Publisher pub) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO publisher (name) VALUES (?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            st.setString(1, pub.getName());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()) {
                pub.setId(rs.getInt(1));
                DB.closeResultSet(rs);
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Publisher pub) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public List<Publisher> findAll() {
        return null;
    }
}
