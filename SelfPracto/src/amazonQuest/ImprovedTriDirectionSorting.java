package amazonQuest;

public class ImprovedTriDirectionSorting {
	public static void main(String args[]){
		int arr[] = {0,1,0,1,1,2,0,1,0,2,1,0,0,1,0,0,1,0,0,2,0};
		
		//	Setting the first index of 1 and 2 as -1
		int first1 = -1;
		int first2 = -1;
		
		for(int i = 0; i<arr.length; i++){
			// Setting up the indices when either 1 or 2 is found first
			if(arr[i] == 1 && first1 == -1){
				first1 = i;
			}
			else if(arr[i] == 2 && first2 == -1){
				first2 = i;
			}
			
			// Setting up the index if 1 is found after 2
			if(arr[i] == 1 && first2 != -1){
				arr[i] = 2;
				arr[first2] = 1;
				first2++;
			}
			
			//	When a 0 is found after either 1 or 2 or both
			else if(arr[i] == 0){
				//	If both 1 and 2 have appeared before 0
				if(first1 != -1 && first2 != -1){
					arr[i] = 2;
					arr[first2] = 1;
					arr[first1] = 0;
					first1++;
					first2++;
				}
				//	If only 1 has come before
				else if(first1 != -1){
					arr[i] = 1;
					arr[first1] = 0;
					first1++;
				}
				//	If only 2 has come before
				else if(first2 != -1){
					arr[i] = 2;
					arr[first2] = 0;
					first2++;
				}
			}
		}
		for(int j=0; j<arr.length; j++){
			System.out.print(arr[j]+", ");
		}
	}
}
