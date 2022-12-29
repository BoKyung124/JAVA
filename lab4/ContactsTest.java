// 이보경(2015682)
// 2022-12-27
// lab4-4: Contacts 클래스 작성 (ContactsTest.java)

package lab4;

import java.util.Scanner;

class Contacts {
	private String name;
	private String tel;
	private String email;
	public static int count;

	public Contacts(String n, String t, String e) {
		name = n;
		tel = t;
		email = e;
		count++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Contacts.count = count;
	}

	@Override
	public String toString() {
		return name + "의 전화번호: " + tel + " 이메일: " + email;
	}

}

public class ContactsTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Contacts[] list = new Contacts[100];
		int i = 0;

		System.out.println("연락처를 입력하시오 (종료 -1)");
		while (true) {
			System.out.print("이름과 전화번호, 이메일을 입력하시오: ");
			String name = sc.next();
			// 종료조건
			if (name.equals("-1"))
				break;
			String tel = sc.next();
			String email = sc.next();
			list[i] = new Contacts(name, tel, email);
			i++;
		}

		System.out.println("지인들의 수는 " + Contacts.count + "입니다.");

		System.out.print("검색할 이름을 입력하시오: ");
		String search = sc.next();
		for (int j = 0; j < Contacts.count; j++) {
			if (search.equals(list[j].getName())) {
				System.out.println(list[j]);
				break;
			}
		}

	}

}
