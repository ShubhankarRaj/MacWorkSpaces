package class2;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetLearning {
	public static void main(String[] args) {
		// Set<String> set = new HashSet<String>();
		Set<String> set = new LinkedHashSet<String>();

		for (int i = 0; i < 5; i++) {
			set.add("Temp_" + i);
		}
		// System.out.println(set.size());

		// for (String xyz : set) {
		// System.out.println(xyz);
		// }

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
		}

		set.remove("Temp_0");

		iterator = set.iterator();
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);
		}
	}
}
