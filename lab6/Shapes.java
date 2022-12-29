// 이보경(2015682)
// 2022-12-29
// lab6-1 인터페이스 실습 (Shape.java)

package lab6;

interface Shape {
	final double PI = 3.14;

	void draw();

	double getArea();

	default public void redraw() {
		System.out.print("--- 다시 그립니다.");
		draw();
	}
}

class Circle implements Shape {
	private double radius;

	public Circle(double r) {
		radius = r;
	}

	public void draw() {
		System.out.println("반지름이 " + radius + "인 원입니다.");
	}

	public double getArea() {
		return PI * radius * radius;
	}
}

class Oval implements Shape {
	private double width, height;

	public Oval(double w, double h) {
		width = w;
		height = h;
	}

	public void draw() {
		System.out.println("너비: " + width + ", 높이:" + height + "에 내접하는 타원입니다.");
	}

	public double getArea() {
		return PI * 1 / 2 * width * 1 / 2 * height;
	}

}

class Rect implements Shape {
	private double width, height;

	public Rect(double w, double h) {
		width = w;
		height = h;
	}

	public void draw() {
		System.out.println("너비: " + width + ", 높이:" + height + "의 사각형입니다.");
	}

	public double getArea() {
		return width * height;
	}
}

public class Shapes {

	public static void main(String[] args) {
		Shape[] list = new Shape[3];

		list[0] = new Circle(10);
		list[1] = new Oval(20, 30);
		list[2] = new Rect(10, 40);

		for (int i = 0; i < list.length; i++)
			list[i].redraw();
		for (int i = 0; i < list.length; i++)
			System.out.println("면적은 " + list[i].getArea());
	}

}
