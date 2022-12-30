// 이보경 (2015682)
// 2022-12-26
// Lab3-2: Song 클래스 작성 (SongTest.java)

class Song {
	private String title;
	private String artist;
	private int length;

	// 생성자 중복 정의

	public Song() {
		title = "제목 없음";
		artist = "정보 없음";
		length = 0;
	}

	public Song(String t, String a, int l) {
		this();
		title = t;
		artist = a;
		length = l;
	}

	public Song(String t, String a) {
		this();
		title = t;
		artist = a;
	}

	public Song(String t) {
		this();
		title = t;
	}

	@Override
	public String toString() {
		return "Song [제목:" + title + ", 가수:" + artist + ", 곡의 길이:" + length + "]";
	}

}

public class SongTest {

	public static void main(String[] args) {
		Song s1 = new Song("Outward Bound", "Nana", 180);
		Song s2 = new Song("Jambalya", "Carpenters");
		Song s3 = new Song("Yesterday");
		Song s4 = new Song();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
	}

}
