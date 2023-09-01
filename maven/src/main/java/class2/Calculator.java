package class2;

public class Calculator {
	private int a;
	private int b;
	
	public Calculator(int a, int b) {
		this.a = a;
		this.b = b;
		System.out.println("constructor: int");
	}
	
	public Calculator(double a, double b) {
		this.a = (int) a;
		this.b = (int) b;
		System.out.println("constructor: double");
	}
	
	public void sum() {
		System.out.println("a: " + a + " b: " + b);
		System.out.println("sum: " + (a + b));
	}
}
