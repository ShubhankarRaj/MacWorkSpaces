package amazonQuest;

public class LeaderInArray {
	public static void LeaderInArray(int []arr){
//		int arrLen = arr.length;
		System.out.println("The Leaders in array are as follows: ");
		for(int i = 0; i < arr.length-1; i++){
			if (arr[i] >= arr[i+1])
				if	(i==0){
					System.out.println(arr[i]);
					continue;
			}
			if (arr[i] >= arr[i+1])
				if(arr[i] >= arr[i-1]){ 
					System.out.println(arr[i]);
					continue;
				}
			if(i == arr.length-2){
				System.out.println(arr[i+1]);
				continue;
			}
					
		}
	}
	public static void main(String args[]){
		int[] arr1 = {2,14,15,8,2,6};
		LeaderInArray(arr1);
		int[] arr2 = {20,14,5,8,2,0};
		LeaderInArray(arr2);
	}
}
