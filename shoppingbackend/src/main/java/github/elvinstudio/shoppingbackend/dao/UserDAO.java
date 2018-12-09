package github.elvinstudio.shoppingbackend.dao;

import java.util.List;

import github.elvinstudio.shoppingbackend.dto.Address;
import github.elvinstudio.shoppingbackend.dto.Cart;
import github.elvinstudio.shoppingbackend.dto.User;

public interface UserDAO {
	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(int userid);
	List<Address> listShippingAddress(int userid);
	
	boolean updateCart(Cart cart);
}
