package amazonQuest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayDivisibility {
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int num = scn.nextInt();
		System.out.println("The biggest number which is divisible by, 2, 3 and 5 is: "+ArrayDivisibility(num));
	}
	
	public static int ArrayDivisibility(int num){
		String numStr = Integer.toString(num);
		List<Integer> digList = new ArrayList<Integer>();
		List<Integer> numToRem = new ArrayList<Integer>();
		numToRem.add(Integer.MAX_VALUE);
		int numLen = numStr.length();
		int newNum;
		int temp;
		for(int i = 0; i<numLen; i++){
			newNum = num%10;
			digList.add(newNum);
			num = num/10;
		}
		Collections.reverse(digList);
		//for a number to be divisible by 2, it need to have a even digit at the end
		for (int a = 0; a<digList.size(); a++){
			if (digList.get(a)%2 == 0){
				break;
			}
			if(a == digList.size()-1){
				System.out.println("The number cant be divided by 2");
				return 0;
			}
		}
		
		//For a number to be divisible by 5, it need to have a 5 or 0 in the array, but here it need to be divisble by 2 also,
		//hence it has to be 0.
		if (digList.contains(0)){
			System.out.println("The number can be divided by both 2 and 5");
			for(int a = 0; a<digList.size(); a++){
				if(digList.get(a)==0){
					digList.set(a, digList.get(numLen-1));
					digList.set(numLen-1, 0);
					break;
				}
			}
			}else{
				System.out.println("The number is not divisble by 5.");
				return 0;
		}
		System.out.println(digList.toString());
		
		//For a number to be divisible by three, we need to first check the sum of digits and then we need to check if
		//there is any digit that can be removed to get it divisible by 3.
		int sumOfDigits=0;
		for(int a = 0;a<digList.size()-1; a++){
			sumOfDigits += digList.get(a);
		}
		if(sumOfDigits%3 == 0){
			System.out.println("The number is divisible by 3");
		}
		else{
			
			for(int a=0; a<digList.size()-1; a++){
				if((sumOfDigits-digList.get(a))%3 == 0){
					System.out.println("The number can be divided by 3, when "+digList.get(a)+" is removed.");
					if (digList.get(a) < numToRem.get(0)){
						numToRem.set(0, digList.get(a));
					}
				}
				if(a==digList.size()-2 && (numToRem.get(0)==0)){
					System.out.println("The number is not divisible by 3");
					return 0;
				}
			}
		}
		
		digList.remove(numToRem.get(0));
		//Sorting the remaining digits of the number except the last one
		for(int a=0; a<digList.size()-2; a++){
			for(int b = 1; b<digList.size()-1; b++){
				if(digList.get(a)<digList.get(b)){
					 temp= digList.get(b);
					 digList.set(b, digList.get(a));
					 digList.set(a, temp);
				}
			}
		}
		System.out.println("The final number which need to be arranged is: "+digList.toString());
		int digit, numToRet=0, i=0;
		for(int a=digList.size()-1; a>=0; a--){
			digit = (int) (digList.get(a)*Math.pow(10, i));
			i+=1;
			numToRet=numToRet+digit;
			
		}
		return numToRet;
	}
}
