package mz.co.sbankbackend.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mz.co.sbankbackend.entity.Propriet;


@Repository("proprietDAO")
@Transactional
public class ProprietDAOImpl implements ProprietDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE
	 * */
	
	@Override
	public Propriet get(int productId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Propriet.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST
	 * */
	
	@Override
	public List<Propriet> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Propriet" , Propriet.class)
						.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Propriet product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Propriet product) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Propriet product) {
		try {
			
			product.setActive(false);
			// call the update method
			return this.update(product);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	@Override
	public List<Propriet> listActivePropriets() {
		String selectActivePropriets = "FROM Propriet WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActivePropriets, Propriet.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Propriet> listActiveProprietByCategory(int categoryId) {
		String selectActiveProprietsByCategory = "FROM Propriet WHERE active = :active AND categoryproprietId = :categoryproprietId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProprietsByCategory, Propriet.class)
						.setParameter("active", true)
						.setParameter("categoryproprietId",categoryId)
							.getResultList();
	}

	@Override
	public List<Propriet> getLatestActivePropriets(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Propriet WHERE active = :active ORDER BY id", Propriet.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();					
	}

}
