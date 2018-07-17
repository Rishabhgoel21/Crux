package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Rishabh
 * 
 * @date 01-Jul-2018
 */

public class Hashmapdemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put
		map.put("UK", 10);
		System.out.println(map);
		map.put("SL", 30);
		map.put("India", 20);
		System.out.println(map);
		map.put("India", 15);
		System.out.println(map);

		// get
		System.out.println(map.get("India"));
		System.out.println(map.get("A"));

		// Contains key -- boolean type
		System.out.println(map.containsKey("SL"));
		System.out.println(map.containsKey("B"));

		// remove
		System.out.println(map.remove("India"));
		System.out.println(map);

		// key set
		ArrayList<String> list = new ArrayList<>(map.keySet());
		System.out.println(list);

		// or use Set(it didn't print duplicates)
		Set<String> list1 = map.keySet();
		System.out.println(list1);

	}
}
