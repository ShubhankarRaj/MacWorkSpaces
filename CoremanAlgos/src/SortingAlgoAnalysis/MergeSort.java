package SortingAlgoAnalysis;

import java.lang.reflect.Array;

public class MergeSort {
	public static void main(String args[]){
		int[] unsortedArr = {1000,2,341,34,10,12,9,35,999};
		MergeSort(unsortedArr, 1, unsortedArr.length);
		System.out.println("Sorting the array using Merge Sort; Output is: ");
		for(int i=0; i<unsortedArr.length; i++){
			System.out.print(" "+unsortedArr[i]+";");
		}
	}
	
	static void MergeSort(int[] unsortedArray, int indexTillSorted, int indexLastElemArr){
		int midPointArr = 0;
		//	First splitting the Unsorted Array into halves, till we get the single elements
		//	after which we are going to merge them.
		if(indexTillSorted < indexLastElemArr){
			midPointArr = (indexTillSorted + indexLastElemArr)/2;
			MergeSort(unsortedArray, indexTillSorted, midPointArr);
			MergeSort(unsortedArray, midPointArr+1, indexLastElemArr);
			Merge(unsortedArray, indexTillSorted, midPointArr, indexLastElemArr);
		}		
	}
	
	static void Merge(int[] Arr, int sortingStartPos, int midPointOfSortingArr, int endPointOfArr){
		System.out.println("Start Position: "+sortingStartPos+" Mid Position: "+midPointOfSortingArr+" End Position: "+endPointOfArr);
		int n1 = midPointOfSortingArr - sortingStartPos + 1;
		int n2 = endPointOfArr - midPointOfSortingArr;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for(int i = 0; i<n1; i++){
			L[i] = Arr[sortingStartPos + i -1];
		}
		for(int j = 0; j<n2; j++){
			R[j] = Arr[midPointOfSortingArr + j];
		}
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;
		for(int k = sortingStartPos-1; k < endPointOfArr; k++){
			if (L[a] <= R[b]){
					Arr[k] = L[a];
					a=a+1;
			}else{
				Arr[k] = R[b];
				b = b+1;
			}
		}
	}
}
