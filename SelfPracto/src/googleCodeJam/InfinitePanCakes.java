package googleCodeJam;

public class InfinitePanCakes {
	public static int noOfMins = 0;
	public static void main(String args[]){
		InfinitePanCakes infPC = new InfinitePanCakes();
		int noOfDiners;
		int[] nofPancakes = null;
		noOfDiners = 1;
		nofPancakes[0] =  3;
		int val = infPC.getTime(noOfDiners, nofPancakes);
	}
	
	public static int getTime(int noOfHungryPeopleHavingPancake, int[] nofPancakes){
		int maxTimetoFinishPancakes = max(nofPancakes);
		if(maxTimetoFinishPancakes > (2^(nofPancakes.length))){
			
			if(nofPancakes.length <=2){
				return noOfMins =+ 2;
			}
			
			noOfMins =+ 1;
			
		}
		return 0;
	}
	
	public static int max(int[] panArray){
		int len = panArray.length;
		int maxVal = panArray[0];
		for(int i = 0; i < len; i++){
			if(maxVal > panArray[i])
				maxVal = panArray[i];
		}
		return maxVal;
	}
}
