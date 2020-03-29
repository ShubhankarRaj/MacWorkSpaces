package StackOverFlow;

import java.util.Scanner;

public class ReverseKSizedSequence {
	public static void main(String args[]){
		int[] valsInArr = {1,2,3,4,5,6,7,8,9};
		Scanner scn = new Scanner(System.in);
		System.out.println("Kindly enter the group size that you want to reverse:");
		int grpSize = scn.nextInt();
		int iterationSize = 0;
		double noOfGrps = Math.ceil(valsInArr.length/grpSize);
		for(int i = 0; i < valsInArr.length; i++){
			if(iterationSize/2>grpSize/2){
				iterationSize = 0;
				i=i+iterationSize/2;
				continue;
			}
			int temp = valsInArr[i];
			valsInArr[i] = valsInArr[i+(grpSize-i)];
			valsInArr[i+(grpSize-i)] = temp;
			iterationSize++;
			
		}
		
		System.out.println(""+valsInArr);
	}
}
