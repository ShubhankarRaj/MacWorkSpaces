package amazonQuest;

public class AlphaNumericSort {
	public static String arr[]={"a2","w1","a3","a4","b1","b2","b3","b4","b5","c1","c2","c3","c4"};
	static void AlphaNumericSort(String[] inputArr){
		int arrLen = inputArr.length;
		for(int i = 0; i < arrLen; i++){
			inputArr = arr;
			char val[] = inputArr[i].toCharArray();
			placeValinArr(i, val, inputArr);
		}
		for(int k = inputArr.length-1 ; k >= 0; k--){
			System.out.print(" "+inputArr[k]);
		}
	}
	static void placeValinArr(int curPos, char[] valInCharArr,String[] inArr){
		for(int j=0;j<inArr.length; j++){
			String temp;
			char valInArr[] = inArr[j].toCharArray();
			if ((valInArr[1] <= valInCharArr[1]) && (valInArr[0] <= valInCharArr[0])){
				temp = inArr[j];
				inArr[j] = inArr[curPos];
				inArr[curPos] = temp;
			}
			else if (valInArr[0] <= valInCharArr[0]){
					temp = inArr[j];
					inArr[j] = inArr[curPos];
					inArr[curPos] = temp;
				}
			else{
					continue;
				}
				
			}
			arr = inArr;
		}
	
	public static void main(String args[]){
	 
	 AlphaNumericSort(arr);
 }
}
