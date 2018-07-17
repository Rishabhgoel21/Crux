package Generic;

import java.util.Comparator;

/**
 * @author Rishabh
 * 
 * @date 01-Jul-2018
 */

public class GenericDemo {

	public static void main(String[] args) {

		Integer[] iarr = { 10, 20, 30, 40, 50 };
		String[] sarr = { "abc, cde, efg, ghi" };

		// display(iarr);
		// display(sarr);
		Car[] cars = new Car[5];
		cars[0] = new Car(100, 200, "black");
		cars[1] = new Car(300, 80, "red");
		cars[2] = new Car(200, 230, "grey");
		cars[3] = new Car(800, 110, "white");
		cars[4] = new Car(350, 250, "blue");

//		bubbleSort(cars);
		bubbleSort(cars,new CarSpeedComparator());
		display(cars);

	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.println(val + " ");
		}
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int n = arr.length;

		for (int counter = 0; counter < n - 1; counter++) {
			for (int j = 0; j < n - counter - 1; j++) {
				if ((arr[j].compareTo(arr[j + 1]) > 0)) {

					T temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> o) {
		int n = arr.length;

		for (int counter = 0; counter < n - 1; counter++) {
			for (int j = 0; j < n - counter - 1; j++) {
				if ((o.compare(arr[j],arr[j + 1]) > 0)) {

					T temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
