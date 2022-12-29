// 이보경(2015682)
// 2022-12-29
// lab6-3 추상 클래스 실습 (DictionaryApp.java)

package lab6;

abstract class PairMap {
	protected String keyArray[]; // key 저장
	protected String valueArray[]; // value 저장
	abstract String get(String key); // key 값으로 value 검색
	abstract void put(String key, String value); // key와 value 쌍으로 저장
	abstract String delete(String key); // key 값을 가진 아이템(value와 함께) 삭제, 삭제된 value값 리턴
	abstract int length(); // 현재 저장된 아이템 개수 리턴
}

class Dictionary extends PairMap {
	static int count = 0;

	public Dictionary(int capacity) {
		this.keyArray = new String[capacity];
		this.valueArray = new String[capacity];
//		PairMap[] keyArray = new PairMap[capacity];
//		PairMap[] valueArray = new PairMap[capacity];
	}

	String get(String key) {
		// 현재 배열에 저장된 원소 개수만큼 반복하면서
		// key와 같은 값이 있는지 key 배열에서 찾아서
		// 해당 value 값 반환
		for (int i = 0; i < count; i++) {
			if (key.equals(this.keyArray[i]))
				return this.valueArray[i];
		}
		// key를 발견할 수 없다면 Null 리턴
		return null;
	}

	void put(String key, String value) {
		// 현재 배열에 저장된 원소 개수만큼 반복하면서
		// key 값이 이미 배열에 저장되어 있는 경우
		// 그 위치에 value값 저장
		// key 값이 배열에 저장되어 있지 않는 경우
		// 현재 배열에 마지막으로 저장된 원소 다음에 key 값과 value 값 저장
		for (int i = 0; i < count; i++) {
			if (key.equals(this.keyArray[i])) {
				this.valueArray[i] = value;
			}
		}
		this.keyArray[count] = key;
		this.valueArray[count] = value;
		count++;
	}

	String delete(String key) {
		// 현재 배열에 저장된 원소 개수만큼 반복하면서
		// key 값이 이미 배열에 저장되어 있는 경우
		// 그 위치의 key, value 값 삭제
		// 삭제된 위치의 뒤에 있는 원소들을 앞으로 한칸씩 이동해야 함
		// value 값 반환
		// key 값이 배열에 저장되어 있지 않는 경우 null 리턴
		for (int i = 0; i < count; i++) {
			if (key.equals(keyArray[i])) {
				keyArray[i] = keyArray[i + 1];
				valueArray[i] = valueArray[i + 1];
				return valueArray[i];
			}
			count--;
		}
		return null;
	}

	int length() {
		return count;
	}
}

public class DictionaryApp {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("김숙명", "자바");
		dic.put("이순헌", "파이썬");
		dic.put("이순헌", "C++");
		dic.put("정명신", "react");
		System.out.println("이순헌의 값은 " + dic.get("이순헌"));
		System.out.println("김숙명의 값은 " + dic.get("김숙명"));
		dic.delete("김숙명");
		System.out.println("김숙명의 값은 " + dic.get("김숙명"));
		System.out.println("정명신의 값은 " + dic.get("정명신"));
	}

}
