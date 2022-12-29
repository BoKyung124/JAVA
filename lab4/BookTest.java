// 이보경(2015682)
// 2022-12-27
// lab4-5: Book 클래스 작성 (BookTest.java)

package lab4;

import java.util.Scanner;

class Book {
	private String title;
	private int score;
	public static int count;

	public Book(String t, int s) {
		title = t;
		score = s;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Book.count = count;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", score=" + score + "]";
	}

}

public class BookTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Book[] list = new Book[100];
		boolean a = true;
		int i = 0;

		while (a) {
			System.out.println("=====================");
			System.out.println("1. 책 등록");
			System.out.println("2. 책 검색");
			System.out.println("3. 모든 책 출력");
			System.out.println("4. 종료");
			System.out.println("=====================");

			System.out.print("메뉴를 선택하시오: ");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				System.out.print("책 제목: ");
				String title = sc.nextLine();
				System.out.print("책 평점: ");
				int score = sc.nextInt();
				list[i] = new Book(title, score);
				Book.count++;
				break;

			case 2:
				System.out.print("책 제목: ");
				String search = sc.nextLine();

				for (int j = 0; j < Book.count; j++) {
					if (search.equals(list[j].getTitle())) {
						System.out.println(list[j]);
						break;
					}
				}
				break;

			case 3:
				for (int j = 0; j < Book.count; j++)
					System.out.println(list[j]);
				break;

			case 4:
				a = false;
				break;
			}
			i++;
		}

	}

}
