package SortingAlgoAnalysis;

import java.util.Arrays;


public class SelectionSort {
	public static void main(String args[]){
		int[] unsortedArr = {10,2,34,12,35};
		System.out.println("Sorting the array using Selection Sort; Output is: "+selectionSort(unsortedArr));
	}
	
	static String selectionSort(int[] arr){
		int len = arr.length;
		for(int i=0; i<len-1; i++){
			int key = arr[i];
			for(int j=i+1; j<len; j++){
				if(arr[j] < key){
					
					arr[i] = arr[j];
					arr[j] = key;
					key = arr[i];
				}
			}
		}
		return Arrays.toString(arr);
	}
}
