// 이보경(2015682)
// 2023-01-09
// lab12-1 : HashMap 활용 예제 (HashMap.java)

package lab12;

import java.util.*;

public class HashMap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> map = Map.of("USA", "Washington", "Japan", "Tokyo", "China", "Beijing", "UK", "London",
				"Korea", "Seoul");
		for (String key : map.keySet()) {
			String value = map.get(key);
			System.out.println("key: " + key + ", value: " + value);
		}
		System.out.print("국가 이름을 입력하시오: ");
		String cty = sc.nextLine();
		for (String key : map.keySet()) {
			if (key.equals(cty))
				System.out.println(cty + "의 수도: " + map.get(key));
		}
	}
}