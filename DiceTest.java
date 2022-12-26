// 이보경 (2015682)
// 2022-12-26
// Lab3-6: Dice 클래스 작성 (DiceTest.java)

import java.util.Random;

class Dice {
	private int value;

	public Dice() {
		value = 0;
	}

	Random random = new Random();

	void roll() {
		// 랜덤함수를 사용하여 1~6 사이의 값을 저장
		value = random.nextInt(6) + 1;
	}

	int getValue() {
		// 주사위 변의 값을 반환
		return value;
	}
}

public class DiceTest {

	public static void main(String[] args) {
		// 주사위 2개 객체 생성
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();

		// 주사위 굴린 횟수를 세는 변수 선언 및 초기화
		int count = 0;

		do {
			// 주사위 2개 각각 굴리는 메소드 호출
			dice1.roll();
			dice2.roll();

			int one = dice1.getValue();
			int two = dice2.getValue();

			// 실행 결과와 같이 주사위의 각 면 값을 출력
			System.out.println("주사위1=" + one + " 주사위2=" + two);

			// 실행 횟수 증가
			count += 1;

			if ((one + two) == 2)
				break;

		} while (true); // 종료 조건 작성

		System.out.println("(1,1)이 나오는데 걸린 횟수 = " + count);
	}

}
