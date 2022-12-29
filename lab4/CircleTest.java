// 이보경(2015682)
// 2022-12-27
// lab4-3: Circle 클래스 작성 (CircleTest.java)

package lab4;
import java.util.Random;

class Circle {
	private int radius;
	
	public Circle(int d) {
		radius = d;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
}

public class CircleTest {

	public static void main(String[] args) {
		Random random = new Random();
		Circle[] list;
		list = new Circle[3];
		
		for (int i = 0; i < list.length; i++)
			list[i] = new Circle(random.nextInt(100));
		
		for (int j = 0; j < list.length; j++)
			System.out.println(list[j]);
	}

}
