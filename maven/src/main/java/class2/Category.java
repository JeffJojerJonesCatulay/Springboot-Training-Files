package class2;

public class Category {
	private int catId;
	private String catName;
	
	public Category(int catId, String catName) {
		super();
		this.catId = catId;
		this.catName = catName;
	}

	@Override
	public String toString() {
		return "Category [catId=" + catId + ", catName=" + catName + "]";
	}
}
