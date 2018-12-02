package github.elvinstudio.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "code")
	private String productCode;
	
	@Column(name = "brand")
	private String productBrand;
	@JsonIgnore
	@Column(name = "supplierid")
	private String productSupplier;
	
	@Column(name = "view")
	private int productView;
	
	private Double price;
	private int categoryid;
	
	private int inventory;
	private int sold=0;
	@JsonIgnore
	@Column(name = "is_active")
	private boolean productActive = true;
	
	public Product() {
		this.productCode = "PRD" +UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
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

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(String productSupplier) {
		this.productSupplier = productSupplier;
	}

	public int getProductView() {
		return productView;
	}

	public void setProductView(int productView) {
		this.productView = productView;
	}
	
	public int getRemains() {
		return (inventory-sold);
	}

}
