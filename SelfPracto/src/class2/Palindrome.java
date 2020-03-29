package class2;

import java.util.ArrayList;

public class Palindrome {

	public static int PalindromeLengthPuzzle(String[] input1)
	{
		int studentLength = input1.length;
		ArrayList<String> arr = new ArrayList<String>();

		for(int i=0; i<studentLength; i++){
			arr.add(i, input1[i].substring(0, 1));
		}
		int lenOfMaxPalindrome=0;
		int lenOfThisPalindrome=0;
		for(int j =0;j<arr.size()-1; j++){
			for(int k=1; k<arr.size(); k++){
				if(arr.get(j).equals(arr.get(k))){
					arr.remove(j);
					arr.remove(k-1);
					j=-1;k=1;
					lenOfMaxPalindrome=lenOfMaxPalindrome+1;
					break;
				}
			}
		}
		
		
		return lenOfMaxPalindrome*2+1;
	}
	
	public static void main(String args[]){
		Palindrome p = new Palindrome();
		String[] arr = {"bharti","bharat","akash","bhavya","chand","brijesh","chetak","arv","bhav"};
		System.out.println(p.PalindromeLengthPuzzle(arr));
		
	}
}


