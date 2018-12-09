package github.elvinstudio.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import github.elvinstudio.shoppingbackend.dao.UserDAO;
import github.elvinstudio.shoppingbackend.dto.Address;
import github.elvinstudio.shoppingbackend.dto.Cart;
import github.elvinstudio.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "From User WHERE email=:email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(int userId) {
		String selectQuery = "FROM Address WHERE user_id=:userid AND billing=:billing";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class).setParameter("userid", userId)
					.setParameter("billing", true).getSingleResult();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddress(int userId) {
		String selectQuery = "FROM Address WHERE user_id=:userid AND shipping=:shipping";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, Address.class).setParameter("userid", userId)
					.setParameter("shipping", true).getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
