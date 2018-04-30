package recurrence;

/*
 *  To give an idea of this problem, we need to find the sub-array within an array that sums up to the maximum value.
 *  For eg., if the entire array has positive values, then the max-sub array would be the entire array and the sum of all
 *  the elements.
 *  But if there are a few negative elements, then we would have a smaller sub-array that will provide us with the max-sub
 *  array. 
 *  Here we are using recurrence for solving this problem. The first approach is although brute force.
 *  ALGO 1:
 *  FIND MAX-CROSSING SUBARRAY(A, low, mid, high)
 *  	left-sum = -INFINITY
 *  	sum = 0
 *  	for i = mid DOWNTO low
 *  		sum = sum + A[i]
 *  		if sum > left-sum
 *  			left-sum = sum
 *  			max-left = i
 *  	right-sum = - INFINITY
 *  	sum = 0
 *  	for j = mid+1 to high
 *  		sum = sum + A[j]
 *  		if sum > right-sum
 *  			right-sum = sum
 *  	 		max-right = j
 *  	RETURN (max-left, max-right, left-sum+right-sum)
 */
public class MaxSumSubArray {
	public int MaxSumSubArrayCross(int[] A, int arrayStartIndex, int arrayLastIndex) {
		// TODO Auto-generated constructor stub
		int midOfArray = (arrayStartIndex+arrayLastIndex)/2;
		int maxLeftIndex = 0, maxRightIndex = 0;
		int left_sum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = midOfArray; i >= arrayStartIndex; i--){
			sum = sum + A[i];
			if (sum > left_sum){
				left_sum = sum;
				maxLeftIndex = i;				
			}else{
				sum = sum - A[i];
			}
		}
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int j = midOfArray+1; j <= arrayLastIndex; j++){
			sum = sum + A[j];
			if(sum > right_sum){
				right_sum = sum;
				maxRightIndex = j;
			}else{
				sum = sum - A[j];
			}
		}
		
		if(left_sum < 0){
			left_sum = 0;
			maxLeftIndex = midOfArray + 1;
		}
		if(right_sum < 0){
			right_sum = 0;
			maxRightIndex = midOfArray;
		}
		
		while (A[maxLeftIndex] < 0){
			left_sum = left_sum - A[maxLeftIndex];
			maxLeftIndex += 1;
		}
		while (A[maxRightIndex] < 0){
			right_sum = right_sum - A[maxRightIndex];
			maxRightIndex -= 1;
		}
		System.out.println("MaxLeftPosition: "+maxLeftIndex+" and MaxRightPosition: "+maxRightIndex);
		System.out.print("The MAXIMUM SUM Sub-Array is: ");
		for (int k = maxLeftIndex; k <= maxRightIndex; k++){
			System.out.print(A[k]+" ");
		}
		System.out.println("\nMax Sum is :"+(left_sum+right_sum));
		return left_sum+right_sum;
	}
	
	public int FindMaxSubArrayLeft(int A[], int startIndex, int endIndex){
		
		int midOfArray = (startIndex+endIndex)/2;
		int maxLeftIndex = 0, maxRightIndex = midOfArray;
		int left_sum = Integer.MIN_VALUE;
		
		int sum = 0;
		for (int i = maxLeftIndex; i <= maxRightIndex; i++){
			sum = sum + A[i];
			if (sum > left_sum){
				left_sum = sum;
				maxLeftIndex = i;				
			}else{
				sum = sum - A[i];
			}
		}
		return sum;
	}
	
	public int FindMaxSubArrayRight(int A[], int startIndex, int endIndex){

		int midOfArray = (startIndex+endIndex)/2;
		int maxLeftIndex = midOfArray+1, maxRightIndex = endIndex;
		int right_sum = Integer.MIN_VALUE;
		
		int sum = 0;
		for (int i = maxLeftIndex; i <= maxRightIndex; i++){
			sum = sum + A[i];
			if (sum > right_sum){
				right_sum = sum;
				maxLeftIndex = i;				
			}else{
				sum = sum - A[i];
			}
		}
		return sum;
	}
	
	public static void main(String args[]){
		int testArray[] = {10,90,-23,-1,3,4};
		MaxSumSubArray test1 = new MaxSumSubArray();
		int highestCrossValue = test1.MaxSumSubArrayCross(testArray, 0, testArray.length-1);
		int highestLeftValue = test1.FindMaxSubArrayLeft(testArray, 0, testArray.length-1);
		int highestRightValue = test1.FindMaxSubArrayRight(testArray, 0, testArray.length-1);
		
		if(highestCrossValue > highestLeftValue & highestCrossValue > highestRightValue){
			System.out.println("Highest value is across the array: "+highestCrossValue);
		}else if(highestLeftValue > highestRightValue){
			System.out.println("Highest Value is from Left Sub Array: "+highestLeftValue);
		}else{
			System.out.println("Highest value is from Right Sub Array: "+highestRightValue);
		}
	}
}
