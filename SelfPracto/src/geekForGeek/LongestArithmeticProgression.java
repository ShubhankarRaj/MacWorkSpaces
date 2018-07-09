package geekForGeek;

public class LongestArithmeticProgression {
	public static void main(String args[]){
		System.out.println("Lets assume for the start that we do already have the Array with us");
		int inputArray[] = {1,2,4,7,8,12,20};
		findLengthOfLongestAP(inputArray, inputArray.length);
	}
	
	static int findLengthOfLongestAP(int[] array, int sizeOfArray){
		if (sizeOfArray <= 2)
				return sizeOfArray;
		int[][] our2DArray = new int[sizeOfArray][sizeOfArray];
		
		// By default fill the values for the last column in the 2D array with 2
		for(int i=0;i<sizeOfArray;i++){
			our2DArray[i][sizeOfArray-1] = 2;
		}
		for(int j=sizeOfArray-2; j>=1; j--){
			
			// Search for i and k for j
			int i = j-1, k = j+1;
			while(i >= 0 && k <= sizeOfArray-1){
				if (array[i] + array[k] < 2*array[j])
					k++;
				else if (array[i] + array[k] > 2*array[j])
					i--;
				else{
					//	This would mean that we have got some elements which are in AP
				}
			}
		}
		return 0;
		
	}
}
