package github.elvinstudio.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import github.elvinstudio.shoppingbackend.dao.CategoryDAO;
import github.elvinstudio.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("github.elvinstudio.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");

	}
	
/*
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Mobile");
		category.setDescription("This is some decsription for mobile");
		category.setImageURL("CAT_2.png");
		assertEquals("Sucessfully added a category inside the table!", true, categoryDAO.add(category));
	}
	/*
	@Test
	public void testGetCategory() {
		category = categoryDAO.get(1);
		
		assertEquals("Sucessfully fetched a single category from the table!", "Television", category.getName());  //test if the result equals to "Television"

	}
	
	@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(1);
		category.setName("TV");
		assertEquals("Sucessfully updated a category in the table!", true, categoryDAO.update(category));
	}
	
	@Test
	public void testDeleteCategory() {
		category = categoryDAO.get(1);
		assertEquals("Sucessfully deleted a category in the table!", true, categoryDAO.delete(category));
	}
	
	@Test
	public void testListCategory() {
		assertEquals("Sucessfully fetched the list of categories from the table!", 1, categoryDAO.list().size());
	}
	*/
	
	@Test
	public void testCRUDCategory() {
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some decsription for laptop");
		category.setImageURL("CAT_1.png");
		assertEquals("Sucessfully added a category inside the table!", true, categoryDAO.add(category));
		
		category = categoryDAO.get(2);
		category.setName("Cell Phone");
		assertEquals("Sucessfully updated a category in the table!", true, categoryDAO.update(category));
		
		category = categoryDAO.get(2);
		assertEquals("Sucessfully deleted a category in the table!", true, categoryDAO.delete(category));
		
		assertEquals("Sucessfully fetched the list of categories from the table!", 1, categoryDAO.list().size());

	}

}
