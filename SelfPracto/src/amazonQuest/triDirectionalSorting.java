package amazonQuest;

import java.util.Arrays;

public class triDirectionalSorting {
	public static int startLocationofZeroinSortedArray = -1;
	public static int startLocationofOneinSortedArray = -1;
	public static int startLocationofTwoinSortedArray = -1;

	public static void main(String args[]) {
		int array[] = { 1, 2, 1, 2, 1, 2, 1};

		int[] sortedArray = new int[array.length];
		int i = 0;
		for (i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				its0(i, array, sortedArray);
			} else if (array[i] == 1) {
				its1(i, array, sortedArray);
			} else if (array[i] == 2) {
				its2(i, array, sortedArray);
			}
		}
		System.out.println(Arrays.toString(sortedArray));
	}

	public static void its0(int j, int[] unsortedArr, int[] sortedArr) {
		if ((startLocationofZeroinSortedArray == -1) && (startLocationofOneinSortedArray == -1) && (startLocationofTwoinSortedArray == -1)){
			sortedArr[j] = 0;
			startLocationofZeroinSortedArray = 0;
		}
		else if ((startLocationofZeroinSortedArray == -1) && (startLocationofOneinSortedArray != -1) && (startLocationofTwoinSortedArray == -1)) {
			sortedArr[j] = 1;
			startLocationofZeroinSortedArray++;
			sortedArr[startLocationofOneinSortedArray] = 0;
			startLocationofOneinSortedArray++;
		}
		else if ((startLocationofZeroinSortedArray == -1) && (startLocationofOneinSortedArray == -1) && (startLocationofTwoinSortedArray != -1)) {
			sortedArr[j] = 2;
			startLocationofZeroinSortedArray++;
			sortedArr[startLocationofTwoinSortedArray] = 0;
			startLocationofTwoinSortedArray++;
		}
		else if ((startLocationofZeroinSortedArray == -1) && (startLocationofOneinSortedArray != -1) && (startLocationofTwoinSortedArray != -1)) {
			sortedArr[j] = 2;
			startLocationofZeroinSortedArray++;
			sortedArr[startLocationofTwoinSortedArray] = 1;
			sortedArr[startLocationofOneinSortedArray] = 0;
			startLocationofTwoinSortedArray++;
			startLocationofOneinSortedArray++;
		}
		else if(startLocationofZeroinSortedArray != -1){
			sortedArr[j] = sortedArr[j-1];
			if(startLocationofTwoinSortedArray != -1 && startLocationofOneinSortedArray == -1){
				sortedArr[startLocationofTwoinSortedArray] = 0;
				startLocationofTwoinSortedArray++;
			}else if(startLocationofTwoinSortedArray != -1 && startLocationofOneinSortedArray != -1){
				sortedArr[startLocationofTwoinSortedArray] = 1;
				sortedArr[startLocationofOneinSortedArray] = 0;
				startLocationofOneinSortedArray++;
				startLocationofTwoinSortedArray++;
			}else if(startLocationofTwoinSortedArray == -1 && startLocationofOneinSortedArray != -1){
				sortedArr[startLocationofOneinSortedArray] = 0;
				startLocationofOneinSortedArray++;
			}
		}
	}

	public static void its1(int j, int[] unsortedArr, int[] sortedArr) {
		if((startLocationofZeroinSortedArray == -1) && (startLocationofTwoinSortedArray == -1))
		{
			sortedArr[j] = 1;
			if(startLocationofOneinSortedArray == -1)
				startLocationofOneinSortedArray = j;
			
				
		}
		else if(((startLocationofZeroinSortedArray == -1) && (startLocationofTwoinSortedArray != -1)) || ((startLocationofZeroinSortedArray != -1) && (startLocationofTwoinSortedArray != -1)))
		{
			sortedArr[j] = sortedArr[j-1];
			sortedArr[startLocationofTwoinSortedArray] = 1;
			startLocationofTwoinSortedArray++;
			if(startLocationofOneinSortedArray == -1)
				startLocationofOneinSortedArray = j-1;
		}
		else if((startLocationofZeroinSortedArray != -1) && (startLocationofTwoinSortedArray == -1))
		{
			sortedArr[j] = 1;
			if(startLocationofOneinSortedArray == -1){
				startLocationofOneinSortedArray = j;
			}else{
				startLocationofOneinSortedArray++;
			}
		}
		
	}

	public static void its2(int j, int[] unsortedArr, int[] sortedArr) {
		if((startLocationofZeroinSortedArray == -1) && (startLocationofOneinSortedArray == -1)){
			sortedArr[j] = 2;
			startLocationofTwoinSortedArray = j;
		}
		else if((startLocationofZeroinSortedArray != -1) && (startLocationofOneinSortedArray == -1)){
			sortedArr[j] = 2;
			if(startLocationofTwoinSortedArray == -1)
				startLocationofTwoinSortedArray = j;
		}
		else if((startLocationofZeroinSortedArray == -1) && (startLocationofOneinSortedArray != -1)){
			sortedArr[j] = 2;
			if(startLocationofTwoinSortedArray == -1)
				startLocationofTwoinSortedArray = j;
		}
		else if((startLocationofZeroinSortedArray != -1) && (startLocationofOneinSortedArray != -1)){
			sortedArr[j] = 2;
			if(startLocationofTwoinSortedArray == -1)
				startLocationofTwoinSortedArray = j;
		}
	}
}