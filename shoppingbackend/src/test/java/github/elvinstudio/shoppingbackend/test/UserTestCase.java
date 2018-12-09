package github.elvinstudio.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import github.elvinstudio.shoppingbackend.dao.UserDAO;
import github.elvinstudio.shoppingbackend.dto.Address;
import github.elvinstudio.shoppingbackend.dto.Cart;
import github.elvinstudio.shoppingbackend.dto.User;

public class UserTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address =null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("github.elvinstudio.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAddressLineOne("Jadoo society");
//		address.setAddressLineTwo("Near Kaabil store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//		
//		if(user.getRole().equals("USER")) {
//			
//			cart = new Cart();
//			cart.setUser(user);
//			
//			assertEquals("Failed to add cart!", true, userDAO.updateCart(cart));
//			
//			address = new Address();
//			address.setAddressLineOne("Jadoo society");
//			address.setAddressLineTwo("Near Kaabil store");
//			address.setCity("Mumbai");
//			address.setState("Maharashtra");
//			address.setCountry("India");
//			address.setPostalCode("400001");
//			address.setShipping(true);
//			
//			address.setUser(user);
//			
//			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//		}
//		
//	}
	
//	@Test
////	public void testUpdateCart() {
////		user = userDAO.getByEmail("hr@gmail.com");
////		cart = user.getCart();
////		cart.setGrandTotal(5555);
////		cart.setCartLines(2);
////		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
////	}

	
//	@Test
//	public void testAddAddress() {
//		
//		user = new User();
//		user.setFirstName("Hrithik");
//		user.setLastName("Roshan");
//		user.setEmail("hr@gmail.com");
//		user.setContactNumber("1234512345");
//		user.setRole("USER");
//		user.setPassword("123456");
//		
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		
//		address = new Address();
//		address.setAddressLineOne("Jadoo society");
//		address.setAddressLineTwo("Near Kaabil store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//		
//		address = new Address();
//		address.setAddressLineOne("Jadoo society");
//		address.setAddressLineTwo("Near Kaabil store");
//		address.setCity("Mumbai");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setShipping(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//		
//		
//	}
	
//	@Test
//	public void testAddAddress() {
//		
//		user = userDAO.getByEmail("hr@gmail.com");
//		
//		address = new Address();
//		address.setAddressLineOne("Jadoo society");
//		address.setAddressLineTwo("Near Kaabil store");
//		address.setCity("Bangalore");
//		address.setState("Maharashtra");
//		address.setCountry("India");
//		address.setPostalCode("400001");
//		address.setBilling(true);
//		
//		address.setUser(user);
//		
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//		
//	}
	
	@Test
	public void testGetAddress() {
		user = userDAO.getByEmail("hr@gmail.com");
		
		assertEquals("Failed to fetch the list of address and size doesn not match!",1,userDAO.listShippingAddress(user.getId()).size());
		assertEquals("Failed to fetch the list of billing address and size doesn not match!","Mumbai",userDAO.getBillingAddress(user.getId()).getCity());
	}

}
