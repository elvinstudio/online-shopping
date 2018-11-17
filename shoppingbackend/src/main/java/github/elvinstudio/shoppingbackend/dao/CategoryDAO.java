package github.elvinstudio.shoppingbackend.dao;

import java.util.List;

import github.elvinstudio.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	List<Category> list();
	Category get(int id);

}
