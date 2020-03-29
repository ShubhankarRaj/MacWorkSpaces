package class2;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class ListLearning {
	public static void main(String[] args) {

		List<List<String>> list = new ArrayList<List<String>>();
		List<String> innerList = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			innerList.add("Temp_" + i);
		}
		list.add(innerList);
		//
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// }
		//
		// for (String xyz : innerList) {
		// System.out.println(xyz);
		// }
		
		Iterator<String> iterator = innerList.iterator();
		while(iterator.hasNext()){
			String value = iterator.next();
			System.out.println(value);
		}
		
		innerList.remove(10);
		innerList.remove("Test_0");

		// for (int i = 0; i < 5; i++) {
		// list.add("Temp_" + i);
		// }
		//
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(list.get(i));
		// }

	}
}
