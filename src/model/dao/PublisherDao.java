package model.dao;

import java.util.List;

import model.entities.Publisher;

public interface PublisherDao {
	void insert(Publisher pub);
	void update(Publisher pub);
	void deleteByName(String name);
	List<Publisher> findAll();
	Publisher findById(Integer id);
}
