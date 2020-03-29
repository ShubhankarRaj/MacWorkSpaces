package Assignment3;

import java.util.Scanner;

public class inputDenomination {
	int countOfDenomination;
	int[] denominations = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
	void createDenomination(int input){
		
		for(int i = 0; i < denominations.length; i++){
			countOfDenomination = input/denominations[i];
			if(countOfDenomination == 0)
				continue;
			input = input - denominations[i]*countOfDenomination;
			printDenominations(denominations[i], countOfDenomination);
		}
	}
	void printDenominations(int denom, int count){
		System.out.println(denom+" * "+count+" = "+denom*count);
		}
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the value for which you need the denominations:");
		int value = scn.nextInt();
		inputDenomination ind = new inputDenomination();
		ind.createDenomination(value);
	}
}
