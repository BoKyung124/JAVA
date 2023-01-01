// 이보경(2015682)
// 2022-12-30
// lab7-1: Object의 toString, equals 재정의 (CircleApp.java)

package lab7;

class Circle {
	private int x, y, radius;

	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public String toString() {
		return "Circle(" + x + ", " + y + ") 반지름" + radius;
	}

	public boolean equals(Circle c) {
		if ((x == c.x) & (y == c.y))
			return true;
		else
			return false;
	}
}

public class CircleApp {

	public static void main(String[] args) {
		Circle a = new Circle(2, 3, 5);
		Circle b = new Circle(2, 3, 30);
		System.out.println("원 a : " + a);
		System.out.println("원 b : " + b);
		if (a.equals(b))
			System.out.println("같은 원");
		else
			System.out.println("서로 다른 원");
	}

}
