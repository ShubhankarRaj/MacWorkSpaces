package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Haircut {
	static File outFile = null;
	static int intervalCount = 0;
	public static int numOfBarbers, customerCount;
		
		public static void main(String[] args) {
			// This method is created to capture input where the first line of the
			// input is the number
			// of test cases, and all the following lines are test cases.
			captureInputAndSolveTestCase();
		}

		
		private static void solveTestCase(int lineCount, String lineContent)
				throws IOException {
			BufferedWriter writer = new BufferedWriter(
					new FileWriter(outFile, true));
			
			if (lineCount % 2 == 0) {
				String[] firstLineArray = lineContent.split(" ");
				numOfBarbers = Integer.parseInt(firstLineArray[0]);
				customerCount = Integer.parseInt(firstLineArray[1]);
				
			}
			if (lineCount % 2 != 0) {
				String[] barberTimeStringArray = lineContent.split(" ");
				int[] barberTimeIntArray = new int[barberTimeStringArray.length];
				for(int i = 0; i< barberTimeIntArray.length; i++){
					barberTimeIntArray[i] = Integer.parseInt(barberTimeStringArray[i]);
				}
				
				Boolean customerNumberReached = false;
				int timerCounter = 1;
				while(!customerNumberReached){
					for(int i=0; i < barberTimeIntArray.length; i++){
						
						if(barberTimeIntArray[i] % timerCounter == 0){
							customerCount = customerCount-1;
						}
						barberTimeIntArray[i] = barberTimeIntArray[i] - 1;
						if(barberTimeIntArray[i] == 0){
							barberTimeIntArray[i] = Integer.parseInt(barberTimeStringArray[i]);
						}
					}
					timerCounter++;
					
					
					
//					for(int i=0; i< barberTimeArray.length; i++){
//						if (Integer.parseInt(barberTimeArray[i])%timerCounter == 0){
//							customerCount = customerCount - 1;
//							if(customerCount == 0){
//								writer.write("Case #" + (lineCount-1) +": "+(i+1));
//								customerNumberReached = true;
//								break;
//							}
//						}
//						timerCounter++;
//					}
//					timerCounter = 1;
					
				}
			}
		}
		
		
		public static void captureInputAndSolveTestCase() {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the path of the file: ");
			String filePath = scn.next();
			FileReader inputFile;
			BufferedReader bReader;
			System.out.println("Enter the path of the O/P file: ");
			String outFilePath = scn.next();
			outFile = new File(outFilePath);

			if (outFile.exists()) {
				outFile.delete();
				try {
					outFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				inputFile = new FileReader(filePath);

				LineNumberReader lineNo = new LineNumberReader(inputFile);
				String line;
				int countOfLine = 0;
				// Reading the file LINE by LINE
				while ((line = lineNo.readLine()) != null) {
					countOfLine = lineNo.getLineNumber();
					if (countOfLine == 1) {
						System.out.println("Total count of cases in the input file is: " + line);
					}else{
						solveTestCase(countOfLine, line);
					}
				}
				lineNo.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File is not found!!");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}
