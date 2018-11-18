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
	

	@Test
	public void testAddCategory() {
		try {
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some decsription for television");
		category.setImageURL("CAT_1.png");
		assertEquals("Sucessfully added a category inside the table!", true, categoryDAO.add(category));
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
