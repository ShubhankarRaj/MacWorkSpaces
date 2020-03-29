package googleCodeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Dijkstra_prob {
	public static void main(String[] args){
		new Dijkstra_prob().Dijkstra_func();
	}
	public void Dijkstra_func(){
		File testInput = new File("/Users/raj8lm/Downloads/A-small-attempt2.in");
		BufferedReader br = null;
		StringBuilder output = new StringBuilder();
		try {

			br = new BufferedReader(new FileReader(testInput));
			int numOfTest = Integer.parseInt(br.readLine());
			
			String[] testSplit;
						
			for(int testCount = 0; testCount<numOfTest; testCount++){
				String test = null;
				String input = "";
				int charCount=0;
				int repeater=0;
				
				test = br.readLine();
				testSplit = test.split(" ");
				charCount = Integer.parseInt(testSplit[0]);
				repeater = Integer.parseInt(testSplit[1]);
				String baseString = br.readLine();
				for(int a = 0; a<repeater; a++){
					input = input+baseString;
				}

				boolean printStatus = false;
				int leftChar = 1, middleChar =1, rightChar=1;
				char[] chArr = input.toCharArray();
				int[] asciiArr = new int[chArr.length];
				// Converting the characters to respective ASCII values for comfortable multiplication
				for(int k = 0; k<chArr.length; k++){
					asciiArr[k] = (int) chArr[k]; 
				}
				leftChar_loop:
					for(int i=0; i<asciiArr.length; i++){

						if(leftChar<0){
							leftChar = -1*leftChar;
							leftChar = -1*multiplyChars(leftChar,asciiArr[i]);
						}
						else{
							leftChar = multiplyChars(leftChar,asciiArr[i]);
						}
						if(leftChar == (int)'i'){
							int middleCharStartPos = i+1;
							middleChar_loop:
								for(int j = middleCharStartPos ;j<asciiArr.length; j++){
									if(middleChar<0){
										middleChar = -1*middleChar;
										middleChar = -1*multiplyChars(middleChar,asciiArr[j]);
									}
									else{
										middleChar = multiplyChars(middleChar,asciiArr[j]);
									}
									if(middleChar == (int)'j'){
										int rightCharStartPos = j+1;
										rightChar_loop:
											if(rightCharStartPos!=asciiArr.length-1){
												for(int k = rightCharStartPos; k<asciiArr.length; k++){
													if(rightChar<0){
														rightChar = -1*rightChar;
														rightChar= -1*multiplyChars(rightChar,asciiArr[k]);
													}
													else{
														rightChar=multiplyChars(rightChar,asciiArr[k]);
													}
													if(rightChar == (int)'k'){
														if(k==asciiArr.length-1){
															printStatus = true;
															break leftChar_loop;
														}else{
															printStatus = false;
														}
													}
												}
											}else{
												rightChar=multiplyChars(rightChar,asciiArr[rightCharStartPos]);
												if(rightChar == (int)'k'){
													printStatus = true;
													break leftChar_loop;
												}else{
													printStatus = false;
												}
											}
									}
									if(j==asciiArr.length-i){
										printStatus = false;
									}
								}
						}
						if(i==asciiArr.length-1){
							printStatus = false;
						}
					}
			
				if(printStatus){
					output.append("Case #").append((testCount + 1)).append(": ")
					.append("YES");
					output.append("\n");
				}
				else{
					output.append("Case #").append((testCount + 1)).append(": ")
					.append("NO");
					output.append("\n");
				}
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		writeOutput(output.toString());
	}
		
private static void writeOutput(String str) {
	File outputFile = new File("/Users/raj8lm/Downloads/smallAttemptRetry.out");
	BufferedWriter writer = null;
	try {
		writer = new BufferedWriter(new FileWriter(outputFile));
		writer.write(str);

	} catch (IOException e) {
	} finally {
		try {
			if (writer != null)
				writer.close();
		} catch (IOException e) {
		}
	}
}

public static int multiplyChars(int a, int b){
	if(a == 1){
		return b;
	}
	if(b == 1){
		return a;
	}
	if(a==105 && b==105){
		return -1;
	}
	if(a==105 && b==106){
		return 107;
	}
	if(a==105 && b==107){
		return -106;
	}
	if(a==106 && b==105){
		return -107;
	}
	if(a==106 && b==106){
		return -1;
	}
	if(a==106 && b==107){
		return 105;
	}
	if(a==107 && b==105){
		return 106;
	}
	if(a==107 && b==106){
		return -105;
	}
	if(a==107 && b==107){
		return -1;
	}
	return 1;
}

}
