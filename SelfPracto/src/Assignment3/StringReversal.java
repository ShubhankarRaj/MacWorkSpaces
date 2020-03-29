package Assignment3;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringReversal {
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.println("Kindly enter the STRING: ");
		String str = scn.nextLine();
		
		/* We would be trying to split the string and reverse it without using any inbuilt function*/
		/* For that we would be using STRING tokenizer */
		String delims = " ";
		StringTokenizer st = new StringTokenizer(str);
		// The number of tokens need to be saved in a variable first and then used, otherwise the count of tokens get 
		// refreshed in each for loop, resulting in incomplete iteration of the string.
		int noOfTokens = st.countTokens();
		String[] wordArray = new String[noOfTokens];
		for(int i=0; i<noOfTokens; i++){
			//System.out.println(st.nextToken());
			wordArray[i] = st.nextToken();
			//System.out.println(wordArray[i]);
		}
		
		for(int j = noOfTokens-1; j>=0; j--){
			System.out.print(wordArray[j]+" ");
		}
	}
}
