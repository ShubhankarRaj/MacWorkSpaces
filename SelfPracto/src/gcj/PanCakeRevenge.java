package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PanCakeRevenge {
	
	static File outFile = null;
	
	public static void main(String[] args) {
		// This method is created to capture input where the first line of the
		// input is the number
		// of test cases, and all the following lines are test cases.
		captureInputAndSolveTestCase();
	}

	private static void solveTestCase(int lineCount, String lineContent)
			throws IOException {
		char[] symbolArray = lineContent.toCharArray();
		ArrayList<Character> patternArrayList = new ArrayList<Character>();
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(outFile, true));
		patternArrayList.add(symbolArray[0]);
		for(int i = 1; i < symbolArray.length; i++){
			if(symbolArray[i] == symbolArray[i-1]){
				continue;
			}else{
				patternArrayList.add(symbolArray[i]);
			}
		}
		System.out.println("Case #" + (lineCount - 1) + ": " + patternArrayList);
		if(patternArrayList.size()%2 == 0){
			if(patternArrayList.get(0) == '+'){
				writer.write("Case #" + (lineCount - 1) + ": " + patternArrayList.size());
				writer.newLine();
			}else{
				writer.write("Case #" + (lineCount - 1) + ": " + (patternArrayList.size() - 1));
				writer.newLine();
			}
		}else{
			if(patternArrayList.get(0) == '+'){
				writer.write("Case #" + (lineCount - 1) + ": " + (patternArrayList.size() - 1));
				writer.newLine();
			}else{
				writer.write("Case #" + (lineCount - 1) + ": " + patternArrayList.size());
				writer.newLine();
			}
		}
		writer.close();	
	}

//	This method is created to capture input where the first line of the input is the number
//	of test cases, and all the following lines are test cases.
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

