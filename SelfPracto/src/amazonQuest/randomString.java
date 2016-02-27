package amazonQuest;

import java.util.Random;

public class randomString {
	private final String str = "0123456789qwertyuiopasdfghjklzxcvbnm!@#$%^&*()_+";
	StringBuilder sb = new StringBuilder();
	Random rnd = new Random();
	public String randomString(int len){
		for(int i = 0; i<len; i++){
			sb.append(str.charAt(rnd.nextInt(str.length())));
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		randomString uID = new randomString();
		System.out.println(uID.randomString(8));
	}
}
