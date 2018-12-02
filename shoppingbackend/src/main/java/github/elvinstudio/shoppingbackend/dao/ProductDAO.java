package github.elvinstudio.shoppingbackend.dao;

import java.util.List;

import github.elvinstudio.shoppingbackend.dto.Product;

public interface ProductDAO {
	Product get(int id);
	List<Product> list(int categoryId);
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	List<Product> getLatestActiveProdct(int count);
}
