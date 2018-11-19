package github.elvinstudio.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import github.elvinstudio.shoppingbackend.dao.ProductDAO;
import github.elvinstudio.shoppingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("github.elvinstudio.shoppingbackend");
		context.refresh();

		productDAO = (ProductDAO)context.getBean("productDAO");

	}
	
	/*
	@Test
	public void testAddProduct() {

		product = new Product();
		product.setProductName("LEGO 乐高 拼插类 玩具 LEGO Classic 经典系列");
		product.setProductDescription("在花园里，森林中，或在你想象的世界里?不管组装什么作品，这块绿色底座都是作为乐高（R）作品的组装，展示和游戏的基础的不可缺少的部分。");
		product.setProductImage("https://images-cn.ssl-images-amazon.com/images/I/51EUZ-u1d2L._AA200_.jpg");
		product.setPrice(95.00);
		product.setInventory(100);
		assertEquals("Sucessfully added a category inside the table!", true, productDAO.add(product));
		
		product = new Product();
		product.setProductName("WMF 福腾宝 锅具刀具5超值件套");
		product.setProductDescription("WMF福腾宝煎锅炒锅汤锅汤勺锅铲超值5件套。CeraDur Line不粘煎锅24cm*1;星辰系列煎炒锅28cm*1;Quality One汤锅24cm*1;汤勺*1;BLACK LINE炒锅铲*1.");
		product.setProductImage("https://images-cn.ssl-images-amazon.com/images/I/41GiyHDl-hL._AA200_.jpg");
		product.setPrice(599.00);
		product.setInventory(100);
		assertEquals("Sucessfully added a category inside the table!", true, productDAO.add(product));
		
		product = new Product();
		product.setProductName("ASICS 亚瑟士 男 跑步鞋 GEL-KAYANO 25 ");
		product.setProductDescription("鞋头部位更加圆头设计，在大拇趾部位能提供较宽裕的高度与宽度，提升舒适合脚度。鞋面采用双层式提花透气网布， 有着更好的透气效果。中底搭载全新FLYTEFOAM LYTE 和FLYTEFOAM PROPEL科技， 兼具轻量、稳定以及缓冲， 为跑者创造***的跑步体验，升级版的后跟稳定装置也为跑者带来更好的安全保障。");
		product.setProductImage("https://images-cn.ssl-images-amazon.com/images/I/41VWVTwQwGL._AA200_.jpg");
		product.setPrice(95.00);
		product.setInventory(100);
		assertEquals("Sucessfully added a category inside the table!", true, productDAO.add(product));
		
		product = new Product();
		product.setProductName("Casio 卡西欧 石英男士手表 GA-400-1BER");
		product.setProductDescription("立体多功能表盘，高端镜面，耐磨度高，指针与液晶结合，双显设计。防滑时尚表壳，背部刻字清晰可见，手表信息一目了然。");
		product.setProductImage("https://images-cn.ssl-images-amazon.com/images/I/510yP0pVu5L._AA200_.jpg");
		product.setPrice(95.00);
		product.setInventory(100);
		assertEquals("Sucessfully added a category inside the table!", true, productDAO.add(product));
		
		product = new Product();
		product.setProductName("华硕 ASUS VivoBook E502NA3450 15.6英寸");
		product.setProductDescription("尺寸:黑蓝色  |  颜色:500G硬盘 官方标配。整机1年国际联保，主要部件2年全国联保。");
		product.setProductImage("https://images-cn.ssl-images-amazon.com/images/I/310APvhCnAL._AA200_.jpg");
		product.setPrice(95.00);
		product.setInventory(100);
		assertEquals("Sucessfully added a category inside the table!", true, productDAO.add(product));
		
		product = new Product();
		product.setProductName("SWAROVSKI 施华洛世奇 恶魔之眼造型手链 5171991");
		product.setProductDescription("造梦旅程 璀璨开启；施华洛世奇成立于1895年；其影响力经久不衰；亲眼目睹三个世纪的时代变迁；在自我发展的历史上；标注了属于自己的变革历程");
		product.setProductImage("https://images-cn.ssl-images-amazon.com/images/I/41SkAHvDYVL._AA200_.jpg");
		product.setPrice(95.00);
		product.setInventory(100);
		assertEquals("Sucessfully added a category inside the table!", true, productDAO.add(product));
		
		product = new Product();
		product.setProductName("Schiff move free旭福维骨力氨糖软骨素片红瓶经典版 80粒");
		product.setProductDescription("尺寸:红瓶基础款 80粒；Schiff 旭福");
		product.setProductImage("https://images-cn.ssl-images-amazon.com/images/I/51v3cITxplL._AA160_.jpg");
		product.setPrice(95.00);
		product.setInventory(100);
		assertEquals("Sucessfully added a category inside the table!", true, productDAO.add(product));
	}
*/
	
	@Test
	public void testUpdateProduct() {
		product = productDAO.get(1);
		product.setSold(50);
		assertEquals("Sucessfully updated a category in the table!", true, productDAO.update(product));
		
	}

/*
	@Test
	public void testDeleteProduct() {
		product = productDAO.get(4);
		assertEquals("Sucessfully deleted a category in the table!", true, productDAO.delete(product));
	}
	
	@Test
	public void testListProduct() {
		assertEquals("Sucessfully fetched the list of categories from the table!", 7, productDAO.list().size());
	}
	*/

}
