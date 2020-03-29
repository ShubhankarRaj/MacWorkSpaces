package Assignment3;

import java.util.Scanner;

public class WordAnagrams {
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.println("Kindly enter the word for which you want the ANAGRAMS:");
		String anagramWord = scn.next();
		createAnagram("", anagramWord);
	}
	
	public static void createAnagram(String prefix, String word){
		if(word.length() <= 1){
			System.out.println(prefix+word);
		}
		else{
			for(int i = 0; i<word.length(); i++){
				String cur = word.substring(i, i+1);
				String before = word.substring(0, i);
				String after = word.substring(i+1);
				createAnagram(prefix+cur, before+after);
			}
		}
			
	}
}
