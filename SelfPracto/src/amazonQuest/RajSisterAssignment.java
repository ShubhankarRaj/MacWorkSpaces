package amazonQuest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RajSisterAssignment {
	public static void main(String args[]){
		//	Creating a hashmap where we can save the number of days in a month
		Map<String, Integer> daysInMonthMap = new LinkedHashMap();
		daysInMonthMap.put("Jan", 31);
		daysInMonthMap.put("Feb", 28);
		daysInMonthMap.put("Mar", 31);
		daysInMonthMap.put("Apr", 30);
		daysInMonthMap.put("May", 31);
		daysInMonthMap.put("Jun", 30);
		daysInMonthMap.put("Jul", 31);
		daysInMonthMap.put("Aug", 31);
		daysInMonthMap.put("Sep", 30);
		daysInMonthMap.put("Oct", 31);
		daysInMonthMap.put("Nov", 30);
		daysInMonthMap.put("Dec", 31);
		
		//	This hashmap would be required to get the count of the day in a particular year
		//	starting from the first day of the month.
		Map<String, Integer> monthsSeqMap = new LinkedHashMap();
		monthsSeqMap.put("Jan", 1);
		monthsSeqMap.put("Feb", 2);
		monthsSeqMap.put("Mar", 3);
		monthsSeqMap.put("Apr", 4);
		monthsSeqMap.put("May", 5);
		monthsSeqMap.put("Jun", 6);
		monthsSeqMap.put("Jul", 7);
		monthsSeqMap.put("Aug", 8);
		monthsSeqMap.put("Sep", 9);
		monthsSeqMap.put("Oct", 10);
		monthsSeqMap.put("Nov", 11);
		monthsSeqMap.put("Dec", 12);
		
		//	Create a hashmap for Zodiacs. The range for each Zodiac is approximate and it is not absolute.
		//	Kindly tweak it to give perfect results.
		Map<String, Integer> zodiacMap = new LinkedHashMap();
		zodiacMap.put("Capricon-NewYear", 23);
		zodiacMap.put("Aquarius", 53);
		zodiacMap.put("Pisces", 83);
		zodiacMap.put("Aries", 113);
		zodiacMap.put("Taurus", 143);
		zodiacMap.put("Gemini", 173);
		zodiacMap.put("Leo", 203);
		zodiacMap.put("Virgo", 233);
		zodiacMap.put("Libra", 263);
		zodiacMap.put("Scorpio", 293);
		zodiacMap.put("Saggitarius", 323);
		zodiacMap.put("Capricon", 365);
		
		System.out.println("Please enter your birth day in \"Mmm\" \"dd\" format");
		
		Scanner scn = new Scanner(System.in);
		String inputStr = scn.nextLine();
		
		String birthMonth = (String) inputStr.subSequence(0, 3);
		String birthDate = (String)inputStr.subSequence(4, 6);
		int dateOfBirth = Integer.parseInt(birthDate);
		
		while(!daysInMonthMap.containsKey(birthMonth)){
			System.out.println("The birth-month entered is not correct");
			System.out.println("Kindly enter the month in \"Mmm\" and date in \"dd\" format separated by a space");
			inputStr = scn.nextLine();
			birthMonth = (String) inputStr.subSequence(0, 3);
			birthDate = (String)inputStr.subSequence(4, 6);
			dateOfBirth = Integer.parseInt(birthDate);
		}
		
		while(daysInMonthMap.containsKey(birthMonth)){
			int noOfDaysinMonth = daysInMonthMap.get(birthMonth);
			if(dateOfBirth <= noOfDaysinMonth){
				System.out.println("The number of days entered for the month are correct.");
				break;
			}else{
				System.out.println("The date entered is not valid for the month");
				System.out.println("Kindly enter the correct date in \"dd\" format");
				int dateStr = scn.nextInt();
				dateOfBirth = dateStr;
			}
		}
		
		int seqOfMonth = monthsSeqMap.get(birthMonth);
		System.out.println("Your's is the "+seqOfMonth+"th month of the year.");
		
		//	Calculation for the position of the Birth Day in the Year
		int birthDateNumericPositionInYear = 0;
		Iterator monthIterator = daysInMonthMap.entrySet().iterator();
		for(int i=1; i<seqOfMonth; i++){
			Map.Entry<String, Integer> monthEntry = (Map.Entry)monthIterator.next();
			birthDateNumericPositionInYear = birthDateNumericPositionInYear + monthEntry.getValue();
		}
		birthDateNumericPositionInYear = birthDateNumericPositionInYear + dateOfBirth;
		System.out.println("The Position of the BirthDate in the Year is "+birthDateNumericPositionInYear+"th day!!");
		
		//	Calculation of the Zodiac Sign
		Iterator zodiacIterator = zodiacMap.entrySet().iterator();
		while(zodiacIterator.hasNext()){
			Map.Entry<String, Integer> zodiacEntry = (Map.Entry)zodiacIterator.next();
			if(zodiacEntry.getValue() >= birthDateNumericPositionInYear){
				System.out.println("Your Zodiac Sign is "+zodiacEntry.getKey());
				break;
			}
		}
		
		System.out.println("Program Terminaed!!");
	}
}
