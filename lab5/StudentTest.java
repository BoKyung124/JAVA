// 이보경(2015682)
// 2022-12-28
// lab5-4: 학생 만들기 (StudentTest.java)

package lab5;

import java.util.Scanner;

class Human {
	private String name;
	private int age;

	public Human(String n, int a) {
		name = n;
		age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return getName() + getAge();
	}

}

class Student extends Human {
	private String major, sID;

	public Student(String name, int age, String m, String s) {
		super(name, age);
		major = m;
		sID = s;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getsID() {
		return sID;
	}

	public void setsID(String sID) {
		this.sID = sID;
	}

	@Override
	public String toString() {
		return super.toString() + getMajor() + getsID();
	}
}

public class StudentTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Human[] h = new Human[3];
		Student[] s = new Student[3];

		for (int i = 0; i < h.length; i++) {
			System.out.print("Human 입력: ");
			String n = sc.next();
			int a = sc.nextInt();
			h[i] = new Human(n, a);
		}

		for (int j = 0; j < s.length; j++) {
			System.out.print("Student 입력: ");
			String n = sc.next();
			int a = sc.nextInt();
			String m = sc.next();
			String i = sc.next();
			s[j] = new Student(n, a, m, i);
		}

		for (int i = 0; i < h.length; i++) {
			System.out.println("이름: " + h[i].getName() + ", 나이: " + h[i].getAge());
		}

		for (int j = 0; j < s.length; j++) {
			System.out.println("[학생 정보] 이름: " + s[j].getName() + ", 나이: " + s[j].getAge() + ", 전공: " + s[j].getMajor()
					+ ", 학번: " + s[j].getsID());
		}
	}

}
