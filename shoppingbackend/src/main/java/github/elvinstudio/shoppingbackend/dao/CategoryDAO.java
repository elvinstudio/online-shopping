package github.elvinstudio.shoppingbackend.dao;

import java.util.List;

import github.elvinstudio.shoppingbackend.dto.Category;

public interface CategoryDAO {
	Category get(int id);
	List<Category> list();
	boolean add(Category category);
}
