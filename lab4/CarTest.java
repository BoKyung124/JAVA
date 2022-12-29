// 이보경(2015682)
// 2022-12-27
// lab4-2: Car 클래스 작성 (CarTest.java)

package lab4;

class Car {
	private String model;
	private String make;
	static int count;
	
	public Car(String model, String make) {
		this.model = model;
		this.make = make;
		count++;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	public static int getNumberOfCars() {
		return Car.count;
	}
}

public class CarTest {

	public static void main(String[] args) {
		new Car("3SERIES", "BENZ");
		new Car("3SERIES", "BENZ");
		new Car("3SERIES", "BENZ");
		System.out.println("총 " + Car.getNumberOfCars() + "대의 자동차가 생산되었습니다.");
	}

}
