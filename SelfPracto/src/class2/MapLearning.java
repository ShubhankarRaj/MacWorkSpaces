package class2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapLearning {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		map.put(1, 50);

		map.put(2, 100);

		map.put(3, 150);

		map.put(4, 800);

		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("md", 50);
		map2.put("sd", 60);
		map2.put("tw", 50);
		System.out.println(map2.keySet());
		for (String key : map2.keySet()) {
			System.out.println(map2.get(key));
		}

		Set<Entry<String, Integer>> entrySet = map2.entrySet();
		Iterator<Entry<String, Integer>> iterator = entrySet.iterator();

		while (iterator.hasNext()) {
			Entry<String, Integer> next = iterator.next();
			System.out.println(next.getKey());
			System.out.println(next.getValue());
		}

		// System.out.println(map.get(1));
		// System.out.println(map2.get("md"));

		Map<Integer, Map<String, Integer>> map3 = new HashMap<Integer, Map<String, Integer>>();

		map3.put(1, map2);

	}
}
