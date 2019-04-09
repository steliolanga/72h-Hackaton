package mz.co.sbankbackend.dao;

import java.util.List;

import mz.co.sbankbackend.entity.Category;

public interface CategoryDAO {

	
	
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}
