package StackOverFlow;

import java.util.Scanner;

public class largestSymmetricalSumofNum {
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.println("Kindly enter the string of digits: ");
		String digits = scn.next();
		System.out.println("The biggest substring with highest sum SYMMETRICALLY is :"+findSymmetricSum(digits));
	}
	
	private static String findSymmetricSum(String str){
		String testStr = str;
		char[] charsinStr = testStr.toCharArray();
		int lenOfStr = charsinStr.length;
		int[] numArr = new int[lenOfStr];
		for(int j =0; j<lenOfStr; j++){
			numArr[j] = charsinStr[j] - '0';
		}
		for(int i = 0; i<lenOfStr-1; i++){
			int sizeOfSub = i+1;
			int sumofDigits=0;
			if(sizeOfSub>lenOfStr/2)
				break;
			for(int k = i;k<=lenOfStr/i;){
				sumofDigits =+ numArr[k]; 
			}
		}
		return testStr;
	}
}
