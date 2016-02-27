package amazonQuest;

import java.util.Scanner;

public class Repititions {
	public static void main(String args[]){
		System.out.println("Lets Start Buddy!!");
		System.out.println("Kindly enter the string that you want to check for repititions: ");
		launch();
	}
	static boolean launch(){
		Scanner scn = new Scanner(System.in);
		String repititionStr = scn.nextLine();
		//System.out.println(repititionStr);
		boolean repitition = false;
		String[] wordInScentence = repititionStr.split(" ");
		for(int i=0; i<=wordInScentence.length-2; i++){
			String src = wordInScentence[i];
		//	System.out.print("Source:"+src+" ");
			for(int j=i+1; j<=wordInScentence.length-1;j++){
				String ref=wordInScentence[j];
		//		System.out.println("Reference: "+ref);
				if(src.equals(ref)){
					System.out.println(src+" is repeated");
					repitition = true;
				}
			}
		}
		scn.close();
		return repitition;
	}
	
}
