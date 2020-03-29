package StackOverFlow;

public class PrintPatternwithZero {
	public static void main(String args[]){
		String str = "ABCDE";
		printPattern(str);
	}
	
	static void printPattern(String str){
		int n = str.length();
		char strArr[] = str.toCharArray();
		char buff[] = new char[2*n];
		buff[0] = strArr[0];
		printPatternUtil(strArr, buff, 1, 1, n);
	}
	
	static void printPatternUtil(char strArray[], char buffer[], int i, int j, int sizeofArr){
		if(i == sizeofArr){
			buffer[j] = '\0';
			System.out.println(buffer);
			return;
		}
		
		buffer[j] = strArray[i];
		printPatternUtil(strArray, buffer, i+1, j+1, sizeofArr);
		
		buffer[j] = ' ';
		buffer[j+1] = strArray[i];
		
		printPatternUtil(strArray, buffer, i+1, j+2, sizeofArr);
	}
}
