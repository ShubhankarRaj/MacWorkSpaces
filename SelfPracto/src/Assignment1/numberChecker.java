package Assignment1;

import java.util.Scanner;

public class numberChecker {
	
	public static void main(String[] args){
		long num;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number that you want to Check for Even or Odd:");
		num = scn.nextInt();
		if(num%2 == 0)
			System.out.println("The number is Even");
		else
			System.out.println("The number is Odd");
	}
}
