package Assignment3;

import java.util.Arrays;



public class SortMergeArray {
	private String[] strArray;
	private int arrLen;
	private String[] tempArr;

	public static void main(String args[]){
		String[] array1 = {"Raj","Delhi","Jhansi","Bangalore"};
		String[] array2 = {"Swapnil", "Ratnesh", "EMC", "Hadoop", "Hudibaba", "Kaminey"};
		SortMergeArray sma = new SortMergeArray();
		sma.mergeArray(array1, array2);
	}
	public void mergeArray(String[] arr1, String[] arr2){
		int arr3Len = arr1.length + arr2.length;
		String[] arr3 = new String[arr3Len];
		int j = 0;
		for(int i = 0; i<arr3Len; i++){

			if(i<arr1.length){
				arr3[i] = arr1[i];
			}
			else{
				arr3[i]=arr2[j];
				j++;
			}
		}
		//Arrays.sort(arr3);
		mergeSortArray(arr3);
		for(int k=0; k<arr3.length; k++){
			System.out.println(arr3[k]);
		}
	}
	public void mergeSortArray(String[] arr){
		this.strArray = arr;
		this.arrLen = arr.length;
		this.tempArr = new String[arrLen];
		doMergeSort(0, arrLen-1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex){
		if(lowerIndex < higherIndex){
			int middle = lowerIndex+(higherIndex - lowerIndex)/2;
			// Sort the left side of the array
			doMergeSort(lowerIndex, middle);
			// Sort the right side of the array
			doMergeSort(middle+1, higherIndex);
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerInd, int middleInd, int higherInd){
		for(int i = lowerInd; i <= higherInd; i++)
			tempArr[i] = strArray[i];

		int i = lowerInd, j = middleInd+1, k = lowerInd;
		while (i <= middleInd && j <= higherInd) {
			if (tempArr[i].compareTo(tempArr[j])<0) {
				strArray[k] = tempArr[i];
				i++;
			} else {
				strArray[k] = tempArr[j];
				j++;
			}
			k++;
		}
		while (i <= middleInd) {
			strArray[k] = tempArr[i];
			k++;
			i++;
		}
	}
}


