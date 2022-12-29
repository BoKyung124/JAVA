// 이보경(2015682)
// 2022-12-28
// lab5-1: Pizza 클래스 만들기 (PizzaTest.java)

package lab5;

class Circle {
	protected int radius;

	public Circle(int r) {
		radius = r;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}

class Pizza extends Circle {
	private String name;

	public Pizza(String n, int radius) {
		super(radius);
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "피자의 종류: " + name + ", 피자의 크기: " + radius;
	}
}

public class PizzaTest {

	public static void main(String[] args) {
		Pizza obj = new Pizza("Pepperoni", 20);
		System.out.println(obj);
	}

}
