package mz.co.sbankbackend.dao;

import java.util.List;

import mz.co.sbankbackend.entity.Categorypropriet;

public interface CategoryProprietDAO {

	
	
	Categorypropriet get(int id);
	List<Categorypropriet> list();
	boolean add(Categorypropriet category);
	boolean update(Categorypropriet category);
	boolean delete(Categorypropriet category);
	
	
}
