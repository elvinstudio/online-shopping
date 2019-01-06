package github.elvinstudio.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import github.elvinstudio.onlineshopping.model.RegisterModel;
import github.elvinstudio.shoppingbackend.dao.UserDAO;
import github.elvinstudio.shoppingbackend.dto.Address;
import github.elvinstudio.shoppingbackend.dto.Cart;
import github.elvinstudio.shoppingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDAO;

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}

	public String validateUser(User user, MessageContext error) {
		String transitionValue = "success";

		if (!user.getPassword().equals(user.getConfirmPassword())) {

			error.addMessage(new MessageBuilder().error().source("confirmPassword")
					.defaultText("password does not match the confirm password").build());
			transitionValue = "failure";
		}
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
			
			error.addMessage(new MessageBuilder().error().source("email")
					.defaultText("email address is already used").build());
			transitionValue = "failure";
		}

		return transitionValue;
	}

	public String saveAll(RegisterModel model) {
		String transitionValue = "success";

		User user = model.getUser();
		if (user.getRole().equals("USER")) {

			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}

		userDAO.addUser(user);

		Address billing = model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);

		userDAO.addAddress(billing);

		return transitionValue;
	}
}
