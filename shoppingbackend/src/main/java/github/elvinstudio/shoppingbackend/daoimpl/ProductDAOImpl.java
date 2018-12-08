package github.elvinstudio.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import github.elvinstudio.shoppingbackend.dao.ProductDAO;
import github.elvinstudio.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list(int categoryId) {
		String selectActiveProduct = "FROM Product WHERE productActive=:active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		query.setParameter("active", true);
		if (categoryId != 0) {
			selectActiveProduct = "FROM Product WHERE productActive=:active and categoryid=:categoryid";
			query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
			query.setParameter("active", true);
			query.setParameter("categoryid", categoryId);
		}
		return query.getResultList();
	}
	
	@Override
	public List<Product> listAllProduct() {
		String selectActiveProduct = "FROM Product";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		
		return query.getResultList();
	}


	@Override
	public Product get(int id) {
		try {
			return sessionFactory
					.getCurrentSession()
						.get(Product.class, Integer.valueOf(id));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setProductActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> getLatestActiveProdct(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM PRODUCT WHERE active=:active order by id",Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
							.getResultList();
	}
}
