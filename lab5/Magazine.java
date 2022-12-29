// 이보경(2015682)
// 2022-12-28
// lab5-2: Magazine 클래스 만들기 (Magazine.java)

package lab5;

class MyBook {
	private String title;
	private int page;
	private String author;
	public static int count;

	public MyBook(String t, int p, String a) {
		title = t;
		page = p;
		author = a;
		count++;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public static int getCount() {
		return count;
	}

}

class Magazine extends MyBook {
	private String date;

	public Magazine(String title, int page, String author, String d) {
		super(title, page, author);
		date = d;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

public class Magazine {

	public static void main(String[] args) {

	}

}
