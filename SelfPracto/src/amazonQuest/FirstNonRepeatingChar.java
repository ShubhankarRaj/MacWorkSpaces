package amazonQuest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNonRepeatingChar {
	public static void main(String args[]){
		String str = "assdsdmdsfsdwerewfbnsmdjjhkkasdaddelhrebnrzzwsdwl";
		System.out.println("The first non-repeating character is: "+nonrepeatingChar(str));
	}
	
	public static char nonrepeatingChar(String str){
		char[] charArr = str.toCharArray();
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		List<Character> list = new ArrayList<Character>();
		Integer j;
		for(int i = 0; i<charArr.length; i++){
			j = charMap.get(charArr[i]);
			if(j == null){
				charMap.put(charArr[i], 1);
				list.add(charArr[i]);
			}
			else
				charMap.put(charArr[i], j+1);
		}
		for(int k = 0; k<list.size(); k++){
			char ch = list.get(k);
			
			int noOfRepetion = charMap.containsKey(ch)?charMap.get(ch):0;
			if (noOfRepetion == 1)
				return ch;
			if(k == list.size()-1){
				System.out.println("All Repeated");
			}
			
		}
		return 'a';
		
	}
}
