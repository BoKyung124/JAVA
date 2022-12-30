// 이보경 (2015682)
// 2022-12-23
// Lab2-3: 랜덤 배열 생성 (RandomArray.java)

package lab2;

import java.util.Random;

public class RandomArray {

	public static void main(String[] args) {
		Random rnd = new Random();
		int cnt = 0;

		// 3 x 5 2차원 배열 생성

		int[][] s = new int[3][5];

		// 배열 원소 0으로 초기화
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				s[i][j] = 0;
			}
		}

		while (true) {
			// 1의 개수 5라면 반복문 종료
			if (cnt == 5)
				break;
			
			// 배열의 행 인덱스 랜덤하게 생성
			int row = rnd.nextInt(3);

			// 열 인덱스 랜덤하게 생성
			int col = rnd.nextInt(5);

			// 배열 요소가 0이 아니라면 건너뜀
			if (s[row][col] != 0)
				continue;

			// 해당 위치의 요소가 0이라면 1 저장
			if (s[row][col] == 0) {
				s[row][col] = 1;
				cnt++;
			}
		}

		// 2차원 배열 출력
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(s[i][j]);
			}
			System.out.println("");
		}

	}

}
