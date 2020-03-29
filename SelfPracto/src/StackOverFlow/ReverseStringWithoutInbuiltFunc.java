package StackOverFlow;

import java.util.Scanner;

public class ReverseStringWithoutInbuiltFunc {
	public static void main(String args[]){
		System.out.println("Kindly enter the String which you want to reverse");
		Scanner scn = new Scanner(System.in);
		String toReverse = scn.nextLine();
		reverseString(toReverse);
	}
	private static void reverseString(String str){
		char[] ch = new char[str.length()];
		for(int i = 0; i < str.length(); i++){
			ch[i] = str.charAt(i);
		}
		
		for(int i = str.length()-1; i >= 0; i--){
			System.out.print(ch[i]);
		}
	}
}
