package Generic;

/**
 * @author Rishabh
 * 
 * @date 01-Jul-2018
 */

public class Car implements Comparable<Car> {

	int speed;
	int price;
	String color;

	public Car(int price, int speed, String color) {
		this.speed = speed;
		this.price = price;
		this.color = color;
	}

	@Override
	public String toString() {
		return "P: " + this.price + " S: " + this.speed + " C: " + this.color;
	}

	@Override
	public int compareTo(Car o) {
		// return this.speed - o.speed;
		return o.price - this.price;
		// return this.color.compareTo(o.color);
	}

}
