// 이보경(2015682)
// 2023-01-09
// lab12-3 : 영화 정보 프로그램 (MovieTest.java)

package lab12;

import java.util.*;

public class MovieTest {
	Scanner sc = new Scanner(System.in);
	ArrayList<Movie> mList = new ArrayList<>();

	void addMovie() { // 추가
		// 사용자로부터 정보 입력받아서
		System.out.print("제목: ");
		String t = sc.nextLine();
		System.out.print("감독: ");
		String d = sc.nextLine();
		System.out.print("장르: ");
		String g = sc.nextLine();
		System.out.print("연도: ");
		String y = sc.nextLine();
		// 영화 객체 생성 후
		Movie m = new Movie(t, d, g, y);
		mList.add(m);
	}

	void printMovie() {
		mList.forEach(m -> System.out.println(m));
	}

	void searchMovie() {
		System.out.print("검색 제목 입력: ");
		String s = sc.nextLine();
		for (Movie m : mList) {
			if (m.getTitle().equals(s))
				System.out.println("검색 결과 " + m);
		}
	}

	void changeMovie() {
		System.out.print("수정할 제목 입력: ");
		String s = sc.nextLine();
		for (Movie m : mList) {
			if (m.getTitle().equals(s)) {
				System.out.println(m);
				System.out.print("제목: ");
				String t = sc.nextLine();
				m.setTitle(t);
				System.out.print("감독: ");
				String d = sc.nextLine();
				m.setDirector(d);
				System.out.print("장르: ");
				String g = sc.nextLine();
				m.setGenre(g);
				System.out.print("연도: ");
				String y = sc.nextLine();
				m.setYear(y);
				System.out.println(m + "로 수정되었습니다.");
			}
		}
	}

	void removeMovie() {
		System.out.print("삭제할 제목 입력: ");
		String s = sc.nextLine();
		Iterator<Movie> itr = mList.iterator();
		if (itr.hasNext()) {
			Movie m1 = itr.next();
			if (m1.getTitle().equals(s)) {
				itr.remove();
			}
			System.out.println(m1 + "이 삭제되었습니다.");
		}
	}

	void printMenu() {
		System.out.println("==========영화 정보 관리==========");
		System.out.println("1.입력/2.출력/3.검색/4.수정/5.삭제/6.종료");
		System.out.print("메뉴입력>>");
	}

	int inputMenu() {
		int menu = Integer.parseInt(sc.nextLine()); // nextline 씹히는 문제 해결
		return menu;
	}

	public static void main(String[] args) {
		MovieTest mt = new MovieTest();
		while (true) {
			mt.printMenu();
			int me = mt.inputMenu();
			if (me == 6) {
				System.out.println("종료되었습니다.");
				break;
			}
			switch (me) {
			case 1:
				mt.addMovie();
				break;
			case 2:
				mt.printMovie();
				break;
			case 3:
				mt.searchMovie();
				break;
			case 4:
				mt.changeMovie();
				break;
			case 5:
				mt.removeMovie();
				break;
			default:
				System.out.println("메뉴 잘못 입력");
			}
		}
	}

}
