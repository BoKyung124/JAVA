// 이보경(2015682)
// 2023-01-09
// lab12-3 : 영화 정보 프로그램 (MovieTest.java)

package lab12;

public class Movie {
	private String title;
	private String director;
	private String genre;
	private String year;
	
	// 생성자
	public Movie(String title, String director, String genre, String year) {
		super();
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.year = year;
	}
	
	// get, set 메소드
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	// toString
	@Override
	public String toString() {   
		return "[제목: " + title + "/ 감독: " + director + "/ 장르: " + genre + "/ 개봉년도: " + year + "]";
	}
}