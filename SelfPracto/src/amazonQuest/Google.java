package amazonQuest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Google {

	/**
	 * @param args the command line arguments
	 */

	int numofdig;
	String usernumber;
	int number;
	Scanner input=new Scanner(System.in); 
	int inddig[]; 
	int numofswap;
	int max;
	int flag;
	int swap=0;
	int noLength;


	int input()
	{

		System.out.println("Enter the number");
		usernumber=input.next();
		System.out.println("Enter the number of swaps");
		numofswap=input.nextInt();

		getnum(usernumber);        
		return 0;

	}
	public static void main(String[] args) {

		new Google().input();
		// TODO code application logic here
	}
	int getnum(String strNum){
		noLength = strNum.length();
		int noToSwap = Integer.parseInt(strNum);
		List<Integer> arrOfDigits= new ArrayList<Integer>();
		List<Integer> sortedDigits = new ArrayList<Integer>();
		int sortedArrSize = sortedDigits.size();
		for(int i=0; i< noLength; i++){
			arrOfDigits.add(i, noToSwap%10);
			noToSwap = noToSwap/10;
			if (sortedArrSize == 0)
				sortedDigits.add(i, noToSwap%10);
			else
				for(int j = 0; j<sortedArrSize; j++){
					if (sortedDigits.get(j)<sortedDigits.get(i)){
						int temp = sortedDigits.get(i);
						sortedDigits.add(i, sortedDigits.get(j));
						sortedDigits.add(j, temp);
					}
				}
		}
		Collections.reverse(arrOfDigits);
		if (numofswap>0){
			for(int a = 0; a<numofswap; a++){
				if (arrOfDigits.get(a)>sortedDigits.get(a)){
					int indexOfarr = arrOfDigits.indexOf(sortedDigits.get(a));
					int temp1 = arrOfDigits.get(indexOfarr);
					arrOfDigits.set(indexOfarr, arrOfDigits.get(a));
					arrOfDigits.set(a, temp1);
				}
			}
		}
		System.out.println(arrOfDigits.toString());
		System.out.println(sortedDigits.toString());
		return 0;
	}
	
}
