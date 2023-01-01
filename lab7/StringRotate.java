// 이보경(2015682)
// 2022-12-30
// lab7-2: String 클래스 활용 (StringRotate.java)

package lab7;

import java.util.Scanner;

public class StringRotate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력하세요. 빈 칸이나 있어도 되고 영어 한글 모두 됩니다.");
		String s = scanner.nextLine();

		for (int i = 0; i < s.length(); i++) {
			String subString = s.substring(1);
			s = subString + s.charAt(0);
			System.out.println(s);
		}
	}

}
