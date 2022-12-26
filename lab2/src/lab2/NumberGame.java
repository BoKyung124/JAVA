// 이보경 (2015682)
// 2022-12-23
// Lab2-1: 숫자 추측 게임 (NumberGame.java)

package lab2;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		int answer = random.nextInt(100);
		int i = 0;

		while (true) {
			i += 1;
			System.out.print("정답을 추측하여 보시오: ");
			int num = sc.nextInt();

			if (num == answer) {
				System.out.println("축하합니다. 시도횟수 = " + i);
				break;
			}

			else if (num < answer) {
				System.out.println("더 높아요.");
			}

			else if (num > answer) {
				System.out.println("더 낮아요.");
			}

		}
	}

}
