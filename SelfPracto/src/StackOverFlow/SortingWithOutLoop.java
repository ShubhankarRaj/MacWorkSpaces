package StackOverFlow;

import java.util.ArrayList;
import java.util.TreeSet;

public class SortingWithOutLoop {
	public static void main(String args[]){
		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(24);
		intList.add(32);
		intList.add(21);
		intList.add(10);
		intList.add(2013);
		intList.add(5);
		
		System.out.println("The sorted set of the Arraylist is : "+sortArrayList(intList));
	}
	
	public static TreeSet sortArrayList(ArrayList<Integer> list){
		TreeSet set = new TreeSet(list);
		return set;
	}
}
