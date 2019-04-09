package mz.co.sbankbackend.dao;

import java.util.List;

import mz.co.sbankbackend.entity.Propriet;

public interface ProprietDAO {

	Propriet get(int productId);
	List<Propriet> list();	
	boolean add(Propriet product);
	boolean update(Propriet product);
	boolean delete(Propriet product);
	
	// business methods
	List<Propriet> listActivePropriets();
	List<Propriet> listActiveProprietByCategory(int categoryId);
	List<Propriet> getLatestActivePropriets(int count);
	
}
