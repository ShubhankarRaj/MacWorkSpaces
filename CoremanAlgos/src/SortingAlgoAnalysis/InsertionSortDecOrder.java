package SortingAlgoAnalysis;

import java.util.Arrays;

public class InsertionSortDecOrder {
	public static void main(String args[]){
		int startTime = (int) System.currentTimeMillis();
		int[] unsortedArr = {230, 10, 90, 65, 87, 92, 1, 87, 102, 76, 23, 45,
				12, 64, 87, 24, 900, 876, 234, 12, 31, 46, 744, 53, 25, 3, 23,
				45, 21, 45, 67, 23, 87, 45, 2, 78, 98, 34, 57675, 21321, 12, 6,
				787987, 2, 3435, 435, 12, 4345, 21, 12, 4355, 5656, 78, 12, 87,
				9009, 232, 12, 4545, 673, 2321, 34, 565, 78, 343, 12, 230, 10,
				90, 65, 87, 92, 1, 87, 102, 76, 23, 45, 12, 64, 87, 24, 900,
				876, 234, 12, 31, 46, 744, 53, 25, 3, 23, 45, 21, 45, 67, 23,
				87, 45, 2, 78, 98, 34, 57675, 21321, 12, 6, 787987, 2, 3435,
				435, 12, 4345, 21, 12, 4355, 5656, 78, 12, 87, 9009, 232, 12,
				4545, 673, 2321, 34, 565, 78, 343, 12, 230, 10, 90, 65, 87, 92,
				1, 87, 102, 76, 23, 45, 12, 64, 87, 24, 900, 876, 234, 12, 31,
				46, 744, 53, 25, 3, 23, 45, 21, 45, 67, 23, 87, 45, 2, 78, 98,
				34, 57675, 21321, 12, 6, 787987, 2, 3435, 435, 12, 4345, 21,
				12, 4355, 5656, 78, 12, 87, 9009, 232, 12, 4545, 673, 2321, 34,
				565, 78, 343, 12, 230, 10, 90, 65, 87, 92, 1, 87, 102, 76, 23,
				45, 12, 64, 87, 24, 900, 876, 234, 12, 31, 46, 744, 53, 25, 3,
				23, 45, 21, 45, 67, 23, 87, 45, 2, 78, 98, 34, 57675, 21321,
				12, 6, 787987, 2, 3435, 435, 12, 4345, 21, 12, 4355, 5656, 78,
				12, 87, 9009, 232, 12, 4545, 673, 2321, 34, 565, 78, 343, 12,
				230, 10, 90, 65, 87, 92, 1, 87, 102, 76, 23, 45, 12, 64, 87,
				24, 900, 876, 234, 12, 31, 46, 744, 53, 25, 3, 23, 45, 21, 45,
				67, 23, 87, 45, 2, 78, 98, 34, 57675, 21321, 12, 6, 787987, 2,
				3435, 435, 12, 4345, 21, 12, 4355, 5656, 78, 12, 87, 9009, 232,
				12, 4545, 673, 2321, 34, 565, 78, 343, 12, 230, 10, 90, 65, 87,
				92, 1, 87, 102, 76, 23, 45, 12, 64, 87, 24, 900, 876, 234, 12,
				31, 46, 744, 53, 25, 3, 23, 45, 21, 45, 67, 23, 87, 45, 2, 78,
				98, 34, 57675, 21321, 12, 6, 787987, 2, 3435, 435, 12, 4345,
				21, 12, 4355, 5656, 78, 12, 87, 9009, 232, 12, 4545, 673, 2321,
				34, 565, 78, 343, 12, 230, 10, 90, 65, 87, 92, 1, 87, 102, 76, 23, 45,
				12, 64, 87, 24, 900, 876, 234, 12, 31, 46, 744, 53, 25, 3, 23,
				45, 21, 45, 67, 23, 87, 45, 2, 78, 98, 34, 57675, 21321, 12, 6,
				787987, 2, 3435, 435, 12, 4345, 21, 12, 4355, 5656, 78, 12, 87,
				9009, 232, 12, 4545, 673, 2321, 34, 565, 78, 343, 12, 230, 10,
				90, 65, 87, 92, 1, 87, 102, 76, 23, 45, 12, 64, 87, 24, 900,
				876, 234, 12, 31, 46, 744, 53, 25, 3, 23, 45, 21, 45, 67, 23,
				87, 45, 2, 78, 98, 34, 57675, 21321, 12, 6, 787987, 2, 3435,
				435, 12, 4345, 21, 12, 4355, 5656, 78, 12, 87, 9009, 232, 12,
				4545, 673, 2321, 34, 565, 78, 343, 12, 230, 10, 90, 65, 87, 92,
				1, 87, 102, 76, 23, 45, 12, 64, 87, 24, 900, 876, 234, 12, 31,
				46, 744, 53, 25, 3, 23, 45, 21, 45, 67, 23, 87, 45, 2, 78, 98,
				34, 57675, 21321, 12, 6, 787987, 2, 3435, 435, 12, 4345, 21,
				12, 4355, 5656, 78, 12, 87, 9009, 232, 12, 4545, 673, 2321, 34,
				565, 78, 343, 12, 230, 10, 90, 65, 87, 92, 1, 87, 102, 76, 23,
				45, 12, 64, 87, 24, 900, 876, 234, 12, 31, 46, 744, 53, 25, 3,
				23, 45, 21, 45, 67, 23, 87, 45, 2, 78, 98, 34, 57675, 21321,
				12, 6, 787987, 2, 3435, 435, 12, 4345, 21, 12, 4355, 5656, 78,
				12, 87, 9009, 232, 12, 4545, 673, 2321, 34, 565, 78, 343, 12,
				230, 10, 90, 65, 87, 92, 1, 87, 102, 76, 23, 45, 12, 64, 87,
				24, 900, 876, 234, 12, 31, 46, 744, 53, 25, 3, 23, 45, 21, 45,
				67, 23, 87, 45, 2, 78, 98, 34, 57675, 21321, 12, 6, 787987, 2,
				3435, 435, 12, 4345, 21, 12, 4355, 5656, 78, 12, 87, 9009, 232,
				12, 4545, 673, 2321, 34, 565, 78, 343, 12, 230, 10, 90, 65, 87,
				92, 1, 87, 102, 76, 23, 45, 12, 64, 87, 24, 900, 876, 234, 12,
				31, 46, 744, 53, 25, 3, 23, 45, 21, 45, 67, 23, 87, 45, 2, 78,
				98, 34, 57675, 21321, 12, 6, 787987, 2, 3435, 435, 12, 4345,
				21, 12, 4355, 5656, 78, 12, 87, 9009, 232, 12, 4545, 673, 2321,
				34, 565, 78, 343, 12};
		System.out.println("The sorted array would be: "+insertionSortDecOrder(unsortedArr));
		int endTime = (int) System.currentTimeMillis();
		System.out.println("Total Time taken for Execution is "
				+ (endTime - startTime) + " ms.");
	}
	
	public static String insertionSortDecOrder(int[] arr){
		int len = arr.length;
		for(int i=1; i<len; i++){
			int key = arr[i];
			int j = i-1;
			while(j >= 0 && arr[j] < key){
				arr[j+1] = arr[j];
				arr[j] = key;
				j = j-1;
			}
		}
		return Arrays.toString(arr);
	}

}
