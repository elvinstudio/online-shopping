package github.elvinstudio.shoppingbackend.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productImage=" + productImage + ", productCode=" + productCode
				+ ", productBrand=" + productBrand + ", productSupplier=" + productSupplier + ", productView="
				+ productView + ", price=" + price + ", categoryid=" + categoryid + ", inventory=" + inventory
				+ ", sold=" + sold + ", productActive=" + productActive + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int productId;
	
	@NotBlank(message="Please enter the Product Name!")
	@Column(name = "name")
	private String productName;
	
	@NotBlank(message="Please enter the description for product!")
	@Column(name = "description")
	private String productDescription;
	
	@Column(name = "image_url")
	private String productImage;
	
	@Column(name = "code")
	private String productCode;
	
	@NotBlank(message="Please enter the Brand Name!")
	@Column(name = "brand")
	private String productBrand;
	
	@Column(name = "supplierid")
	private Integer productSupplier=1;
	
	@Column(name = "view")
	private int productView;
	
	@Min(value=1, message="The min price is 1")
	private Double price;
	private int categoryid;
	
	@Min(value=0, message="Please enter the Inventory!")
	private int inventory;
	private int sold=0;
	
	@JsonIgnore
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
	

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = "PRD" +UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
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

	public int getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(Integer productSupplier) {
		this.productSupplier = productSupplier;
	}

}
