package SortingAlgoAnalysis;

public class InsertionSortWithRecursion {
	public static void main(String[] args){
		int[] unsortedArr = {12,23,1,23,45,10,4,52};
		insertionSort(unsortedArr, 0, unsortedArr.length);
		System.out.println("Sorting the array using the Insertion Sort(RECURSIVELY):");
	}
	
	static void insertionSort(int [] Arr, int posTillSorted, int lengthOfArray){
		for(int i = 1; i<lengthOfArray; i++){
			if(i < (lengthOfArray-1)){
				insertionSort(Arr, i, i);
				mergeIntoSortedArr(Arr[i]);
			}
		}
	}
	
}

// Why the worst case running time of Binary Search is O(nlogn)?
// What is the order of sorting in Insertion Sort? While inserting the new element in the sorted sub-array
// what if Binary search is used? When using binary serach, it means that we would be taking the element 
// at the centre of the array