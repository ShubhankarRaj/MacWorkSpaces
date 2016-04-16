package gcj;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SquareField {
	static File outFile = null;
	public static String outFilePath;
	
	public static void main(String args[]) {
		// This method is created to capture the total number of test scenarios
		// in 1st line
		// total number of test cases and another parameter in the second line,
		// and
		// all the test-data for the test cases from the 3rd line onwards
		captureInputNew();
	}
	
	private static int squareFieldCalculator(ArrayList<Integer[]> testDataArray, int noOfSquares){
		
		Collections.sort(testDataArray, new Comparator<Integer[]>(){
			public int compare(Integer[] oneInt, Integer[] otherInts){
				return oneInt[0].compareTo(otherInts[0]);
			}
		});
		
		//	Printing the Sorted Array
		for (Integer[] eachArr : testDataArray){
			System.out.println(Arrays.toString(eachArr));
		}
		
		//	We need to take the squares from the extremes of the sorted list
		//	If we have three squares, then we would start forming the squares at the first point
		//	and the last point, and for that length we would check if any other point is getting covered or not.
		//	The next point from where we would be starting the square is the next point which is not in the square.
		
		boolean notCovered = true;
		int length_ofSquare = 1;
		
		//	Take the first square for 1st point, and 2nd square for the last point
		//	likewise we need to move to and fro till all the points are covered
		int startIndex = 0;
		int lastIndex = testDataArray.size() - 1;
		
		int sizeOfSquare = 1;
		
		//	We can keep track of the coverage of squares everytime we increase the size of the squares in a Hashmap.
		
		while(notCovered){
			for(int i = 1; i <= noOfSquares; i++){
				
				//	Check how many of the points in the ArrayList are covered
				//	for the start index
				if(i%2 != 0){
					
					//	Last thing to do is to increment the start index by 1
					startIndex += 1;
				}
				
//				Check how many of the points in the ArrayList are covered
				//	for the last index
				if(i%2 == 0){

					//	Last thing to do is to decrement the end index by 1
					lastIndex -= 1;
				}
			}
		}
		return 0;
	}
	
	public static void captureInputNew(){
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the path of the file: ");
		String filePath = scn.next();
		FileReader inputFile;
		BufferedReader bReader;
		System.out.println("Enter the path of the O/P file: ");
		
		outFilePath = scn.next();
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
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));
			LineNumberReader lineNo = new LineNumberReader(inputFile);
			String line;
			int countOfLine = 0, totalTestScenarios, totalTestCases = 0, totalSquares = 0, testCaseCounter = 0, testScenarioCounter = 0, lengthOfSquare;
			String[] testCaseDetails, testDataDetails;
			ArrayList<Integer[]> testDataArrayList = new ArrayList<Integer[]>();
			boolean thisRowIsTestDATA = false;
			// Reading the file LINE by LINE
			while ((line = lineNo.readLine()) != null) {
				countOfLine = lineNo.getLineNumber();
				
				//	Reserving the first line for total number of Test Scenarios
				if (countOfLine == 1) {
					System.out.println("Total count of TEST SCENARIOS in the input file is: " + line);
				}else{
					
					//	If the row found in the input is not for test data:
					if(!thisRowIsTestDATA){
						testScenarioCounter++;
						testCaseDetails = line.split(" ");
						//	First element of the array wud be reserved for total number of test cases
						totalTestCases = Integer.parseInt(testCaseDetails[0]);
						//	2nd element of the array wud be reserved for total number of squares for test-data
						totalSquares = Integer.parseInt(testCaseDetails[1]);
						System.out.println("Total number of Test Cases:"+totalTestCases );
						System.out.println("Total number of Squares for this TC:"+totalSquares);
						//	Clearing the arraylist with all the test-data, so that new set of test-data can be added
						testDataArrayList.clear();
						
						//	Setting the flag as TRUE so that Test Data is captured 
						thisRowIsTestDATA = true;
						
					}else{
							testDataDetails = line.split(" ");
							Integer[] testDataArray = new Integer[testDataDetails.length];
							for(int i=0; i<testDataDetails.length; i++){
								testDataArray[i] = Integer.parseInt(testDataDetails[i]);
							}
							//	Adding the Integer array containing the test data to the ArrayList!!
							testDataArrayList.add(testDataArray);
							testCaseCounter++;
							
							if(testCaseCounter == totalTestCases){
								testCaseCounter = 0;
								
								//	After scanning through all the rows for the test data, the flag need to be toggled
								//	so that we are able to read the next test case details
								thisRowIsTestDATA = false;
								
								//	Send the ArrayList(testDataArrayList) to the method which is going to actually solve the problem
								//	This is the custom Function which will vary from QUESTION to QUESTION
								lengthOfSquare = squareFieldCalculator(testDataArrayList, totalSquares);
								
								//	Add the lines for getting the length of the square which would be the solution
								//	and print them in the output file.
								writer.write("Case #" +testScenarioCounter+ ": "+lengthOfSquare);
							
						}
					}
				}
			}
		}catch(Exception e){
			
		}
	
	}
}

