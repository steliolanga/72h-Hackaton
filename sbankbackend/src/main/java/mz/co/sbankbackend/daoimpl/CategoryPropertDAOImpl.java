package mz.co.sbankbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mz.co.sbankbackend.dao.CategoryProprietDAO;
import mz.co.sbankbackend.entity.Categorypropriet;

@Repository("categoryProprietDAO")
@Transactional
public class CategoryPropertDAOImpl implements CategoryProprietDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorypropriet> list() {

		String selectActiveCategoryPropriet = "FROM Categorypropriet WHERE active = :active";

		Query<Categorypropriet> query = sessionFactory.getCurrentSession().createQuery(selectActiveCategoryPropriet);

		query.setParameter("active", true);

		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Categorypropriet get(int id) {

		return sessionFactory.getCurrentSession().get(Categorypropriet.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(Categorypropriet category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Categorypropriet category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Categorypropriet category) {

		category.setActive(false);

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
