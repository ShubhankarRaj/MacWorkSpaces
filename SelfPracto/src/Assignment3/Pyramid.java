package Assignment3;

import java.util.Scanner;

public class Pyramid {
	public static void main(String aregs[]){
		Scanner scn = new Scanner(System.in);
		System.out.println("Kindly enter the number for which the pyramid is to be built");
		int pyramid = scn.nextInt();
		for (int i = 1; i <= pyramid; i++){
				printSpace(i, pyramid);
				printValue(i);
				System.out.println();
		}
		
	}
	static void printSpace(int row, int pyramid){
		for(int i= 1; i<= pyramid - row; i++)
		System.out.print(" ");
	}
	static void printValue(int val){
		for(int j=1;j<=val*2-1;j++){
			System.out.print(val);
		}
	}
}
