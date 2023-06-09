package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.GenreDao;
import model.entities.Genre;

public class GenreDaoJDBC implements GenreDao {

	private final Connection conn;

	public GenreDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Genre genre) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement("INSERT INTO genre (name) VALUES (?);", Statement.RETURN_GENERATED_KEYS

			);
			st.setString(1, genre.getName());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					genre.setId(rs.getInt(1));
					DB.closeResultSet(rs);
				}
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Genre genre) {
		PreparedStatement st = null;
		try{
			st = conn.prepareStatement(
					"UPDATE genre SET name = ? WHERE id = ?"
			);

			st.setString(1, genre.getName());
			st.setInt(2, genre.getId());
			st.executeUpdate();


		}catch(SQLException e){
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
					"DELETE FROM genre WHERE name = ?"
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
	public List<Genre> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			st = conn.prepareStatement(
					"SELECT * FROM genre;"
			);
			rs = st.executeQuery();
			List<Genre> list = new ArrayList<>();
			while(rs.next()){
				list.add(new Genre(rs.getInt("id"), rs.getString("name")));
			}
			return list;
		}catch (SQLException e){
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
