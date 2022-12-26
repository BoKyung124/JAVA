// 이보경 (2015682)
// 2022-12-23
// Lab2-2: 피타고라스의 정리 (Pythagoras.java)

package lab2;

public class Pythagoras {

	public static void main(String[] args) {
		int a, b, c;

		for (a = 1; a <= 20; a++) {
			for (b = 1; b <= 20; b++) {
				for (c = 1; c <= 20; c++) {
					if (a * a + b * b == c * c) {
						System.out.println(a + " " + b + " " + c);
					} else
						continue;
				}
			}
		}
	}

}
