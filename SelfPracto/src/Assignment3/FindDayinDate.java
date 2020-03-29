package Assignment3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FindDayinDate {
	public static void main(String args[]){
		Scanner scn = new Scanner(System.in);
		System.out.println("Kindly enter the date in \"dd/mm/yyyy\" format");
		String dateString = scn.next();
		
		try{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToday = df.parse(dateString);
		df.applyPattern("EEEE");
		System.out.println(dateToday);
		String day = df.format(dateToday);
		System.out.println(day);
		} 
		catch(ParseException e){
			e.printStackTrace();
		}
		
	}
}
