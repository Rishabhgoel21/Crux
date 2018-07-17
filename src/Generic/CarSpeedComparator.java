package Generic;

import java.util.Comparator;

/**
 * @author Rishabh
 * 
 * @date 01-Jul-2018
*/

public class CarSpeedComparator implements Comparator<Car> {

	@Override
	public int compare(Car t, Car o) {
	return t.speed - o.speed;
	}

		
}
