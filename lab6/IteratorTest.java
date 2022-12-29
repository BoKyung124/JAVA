// 이보경(2015682)
// 2022-12-29
// lab6-2 인터페이스 실습 (IteratorTest.java)

package lab6;

import java.util.Iterator;

class CardDeck implements Iterator {
	// 13장의 카드가 저장된 문자열 객체 배열 생성 >> "2" ... "Ace" 까지 저장
	String[] list = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	// 현재 위치를 위한 변수 선언 및 초기화
	static int index = 0;

	public boolean hasNext() {
		// 현재 위치가 카드 배열의 끝까지 봤다면 (= 카드 배열의 길이와 같다면)
		// 더이상 다음 값은 존재하지 않으므로 false
		if (index == list.length)
			return false;
		// 그렇지 않으면 true
		else
			return true;
	}

	public Object next() {
		// 문자열 배열로부터 현재 위치 값을 반환
		return list[index++];
		// 현재 위치값 증가
	}

	public void remove() {

	}
}

public class IteratorTest {

	public static void main(String[] args) {
		CardDeck i = new CardDeck();
		while (i.hasNext()) {
			System.out.println("next()가 반환하는 값: " + i.next());
		}
	}

}
