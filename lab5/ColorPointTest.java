// 이보경(2015682)
// 2022-12-28
// lab5-3: ColorPoint 클래스 만들기 (ColorPointTest.java)

package lab5;

class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String c) {
		super(x, y);
		color = c;
	}

	public void setColor(String c) {
		this.color = c;
	}

	@Override
	public String toString() {
		return color + "색의 (" + getX() + ", " + getY() + ")의 점";
	}

}

public class ColorPointTest {

	public static void main(String[] args) {
		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		cp.setXY(10, 20);
		cp.setColor("RED");
		System.out.println(cp.toString() + "입니다.");
	}

}
