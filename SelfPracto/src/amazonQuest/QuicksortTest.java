package amazonQuest;



public class QuicksortTest {
	private int[] numbers;
	public static void main(String[] args){
		Quicksort sorter = new Quicksort();
		int[] test = {34,12,651,56,34,78,592,232,13,52,1,100};
		sorter.sort(test);
		if(!valiDate(test)){
			System.out.println("This SORTING is wrongly done");
		}
		printResult(test);
	}
	private static void printResult(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
		System.out.println();
	}
	private static boolean valiDate(int[] numbers){
		for(int i = 0; i<numbers.length-1; i++){
			if (numbers[i] > numbers[i+1]){
				return false;
			}
		}
		return true;
	}
}

class Quicksort{
	private int[] numbrs;
	private int numbr;
	public void sort(int[] values){
		if(values == null || values.length == 0){
			return;
		}
		this.numbrs = values;
		numbr = values.length;
		quicksort(0, numbr-1);
	}
	private void quicksort(int low, int high){
		int i = low, j = high;
		System.out.println("i = "+i+" and j = "+j);
		int pivot = numbrs[low + (high-low)/2];

		while(i<=j){
			while(numbrs[i]<pivot)
				i++;
			while(numbrs[j]>pivot)
				j--;
			if(i<=j){
				exchange(i,j);
				i++;
				j--;
			}
		}
		if(low<j){
			System.out.println("Prinitng the values of low: "+low+" and j: "+j);
			quicksort(low, j);
		}
		if(i<high){
			System.out.println("Prinitng the values of i: "+i+" and high: "+high);
			quicksort(i, high);
		}
	}      

	private void exchange(int a, int b){
		int temp = numbrs[a];
		numbrs[a] = numbrs[b];
		numbrs[b] = temp;
	}

}



