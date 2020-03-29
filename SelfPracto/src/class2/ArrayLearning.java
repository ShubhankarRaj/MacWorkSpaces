package class2;

public class ArrayLearning {

	public static void main(String[] args) {
		// int[] oneDArray = new int[3];
		//
		// for(int i=0;i<oneDArray.length;i++){
		// oneDArray[i]= i+10;
		// }
		//
		// for(int i=0;i<oneDArray.length;i++){
		// System.out.println(oneDArray[i]);
		// }

		String[][] twoDArray = new String[3][2];

		twoDArray[0][0] = "name1";
		twoDArray[0][1] = "pwd";
		twoDArray[1][0] = "name2";
		twoDArray[1][1] = "pwd2";
		twoDArray[2][0] = "name3";
		twoDArray[2][1] = "pwd3";
		
		for (int i = 0; i < twoDArray.length; i++) {
			for (int j = 0; j < twoDArray[i].length; j++) {
				twoDArray[i][j] = "Temp_" + i + "_" + j;
			}
		}
		
		System.out.println(twoDArray);

		for (int i = 0; i < twoDArray.length; i++) {
			for (int j = 0; j < twoDArray[i].length; j++) {
				System.out.println(twoDArray[i][j]);
			}
		}

	}
}
