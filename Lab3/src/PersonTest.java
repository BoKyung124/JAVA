// 이보경 (2015682)
// 2022-12-26
// Lab3-1: Person 클래스 작성 (PersonTest.java)

class Person {
	// 필드
	private String name;
	private String mobile;
	private String office;
	private String email;

	// 생성자
	public Person(String n, String m, String o, String e) {
		name = n;
		mobile = m;
		office = o;
		email = e;
	}

	// 각 필드에 대해 접근자와 설정자 메소드 작성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", mobile=" + mobile + ", office=" + office + ", email=" + email + "]";
	}

}

public class PersonTest {

	public static void main(String[] args) {
		Person obj = new Person("Kim", "01012345678", "027104567", "a@b.c");
		System.out.println(obj);
	}

}
