// 이보경 (2015682)
// 2022-12-26
// Lab3-5: MyDate 클래스 작성 (DateTest.java)

import java.util.Scanner;

class MyDate {
	// 필드 선언
	private int year;
	private int month;
	private int date;

	String[] a = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	// 생성자 정의
	public MyDate(int y, int m, int d) {
		year = y;
		month = m;
		date = d;
	}

	// printDate1() 정의
	public void printDate1() {
		System.out.println(year + "." + month + "." + date);
	}

	// printDate2() 정의
	public void printDate2() {
		System.out.println(a[month - 1] + " " + date + "," + year);
	}
}

public class DateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("연도: ");
		int y = sc.nextInt();
		System.out.print("월: ");
		int m = sc.nextInt();
		System.out.print("일: ");
		int d = sc.nextInt();

		MyDate date = new MyDate(y, m, d);
		date.printDate1();
		date.printDate2();
	}

}
