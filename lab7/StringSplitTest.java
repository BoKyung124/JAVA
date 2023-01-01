// 이보경(2015682)
// 2022-12-30
// lab7-3: StringSplitTest (StringSplitTest.java)

package lab7;

import java.util.Scanner;

public class StringSplitTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;

		System.out.print("문자열 입력: ");
		String s = sc.nextLine();

		String[] tokens = s.split(" ");
		for (String token : tokens) {
			System.out.print(token + " / ");
			cnt++;
		}
		System.out.print("\n");
		System.out.print("단어 갯수: " + cnt);
	}

}
