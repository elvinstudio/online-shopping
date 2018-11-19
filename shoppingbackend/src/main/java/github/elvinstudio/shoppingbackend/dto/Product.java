package github.elvinstudio.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Override
	public String toString() {
		return "Product [id=" + productId + ", name=" + productName + ", description=" + productDescription + ", imageURL=" + productImage
				+ ", price=" + price+ ", active=" + productActive + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int productId;
	
	@Column(name = "name")
	private String productName;
	
	@Column(name = "description")
	private String productDescription;
	
	@Column(name = "image_url")
	private String productImage;
	
	private Double price;
	private int categoryid;
	
	private int inventory;
	private int sold=0;
	
	@Column(name = "is_active")
	private boolean productActive = true;
	
	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public boolean isProductActive() {
		return productActive;
	}

	public void setProductActive(boolean productActive) {
		this.productActive = productActive;
	}

}
