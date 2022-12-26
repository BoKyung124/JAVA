// 이보경 (2015682)
// 2022-12-26
// Lab3-3: Movie 클래스 작성 (MovieTest.java)

import java.util.Scanner;

class Movie {
	// 필드
	private String title;
	private String director;
	private int year;
	private double rating;

	// 생성자 정의
	public Movie(String s, double rating, String d, int year) {
		title = s;
		this.rating = rating;
		director = d;
		this.year = year;
	}

	@Override
	// toString 메소드 작성
	public String toString() {
		return "Movie [title=" + title + ", rating=" + rating + ", director=" + director + ", year=" + year + "]";
	}

}

public class MovieTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("제목: ");
		String s = sc.nextLine();
		System.out.print("감독: ");
		String d = sc.nextLine();
		System.out.print("연도: ");
		int year = sc.nextInt();
		System.out.print("평점: ");
		double rating = sc.nextDouble();

		Movie m = new Movie(s, rating, d, year);
		System.out.println(m);
	}

}
