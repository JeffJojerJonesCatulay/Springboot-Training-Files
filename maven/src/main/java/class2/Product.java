package class2;

public class Product {
	private int productId;
	private String productName;
	private Category category;
	
	public Product(int productId, String productName, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category + "]";
	}
	
	
}
