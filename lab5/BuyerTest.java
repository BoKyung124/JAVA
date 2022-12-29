// 이보경(2015682)
// 2022-12-28
// lab5-5: BuyerTest 클래스 만들기 (BuyerTest.java)

package lab5;

class Item {
	private int price;
	private String name;

	public Item(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

}

class Food extends Item {
	public Food(String name, int price) {
		super(price, name);
	}

	public String toString() {
		return "[Food]" + getName();
	}
}

class Book extends Item {
	private String author;

	public Book(String name, int price, String a) {
		super(price, name);
		author = a;
	}

	public String getAuthor() {
		return author;
	}

	public String toString() {
		return "[Book]" + getName() + ", 저자: " + getAuthor();
	}
}

class Movie extends Item {
	private String director;

	public Movie(String name, int price, String d) {
		super(price, name);
		director = d;
	}

	public String getDirector() {
		return director;
	}

	public String toString() {
		return "[Movie]" + getName() + ", 감독: " + getDirector();
	}
}

class Buyer {
	private int money;

	public Buyer(int m) {
		money = m;
	}

	public void buy(Item t, int n) {
		System.out.println(t.toString() + " => " + n + "개 구매");
		if (t.getPrice() * n < money) {
			money -= t.getPrice() * n;
			System.out.println("구매 완료 후 잔액: " + money);
		} else {
			System.out.println("** 잔액 부족으로 구매 불가능 **");
			System.out.println("잔액: " + money);
		}
	}
}

public class BuyerTest {

	public static void main(String[] args) {
		Buyer m = new Buyer(50000);
		m.buy((new Food("비빔밥", 7000)), 3);
		m.buy((new Food("라면", 5000)), 2);
		m.buy((new Book("Java Programming", 12000, "이설명")), 1);
		m.buy((new Movie("부산행", 9000, "연상호")), 1);
		m.buy((new Food("김밥", 2000)), 3);
	}

}
