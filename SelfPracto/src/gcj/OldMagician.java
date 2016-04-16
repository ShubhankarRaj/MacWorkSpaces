package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

public class OldMagician {

	static File outFile = null;

	public static void main(String[] args) {
		//	This method is created to capture input where the first line of the input is the number
		//	of test cases, and all the following lines are test cases.
		captureInput();
	}

	private static void solveTestCase(int lineCount, String lineContent) throws IOException {
		// Splitting the contents of the line to an integer array and checking
		// if the entries are even or odd
		String[] strArray = lineContent.split(" ");
		boolean whiteBallEven, blackBallEven;
		int testCaseNo = lineCount;
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, true));

		int[] intArray = new int[strArray.length];

		if (testCaseNo == 1) {
			// writer.write("Output");
			// writer.newLine();
		} else {

			// reading the count of BLACK and WHITE balls

			for (int i = 0; i < strArray.length; i++) {
				intArray[i] = Integer.parseInt(strArray[i]);
			}
			if ((intArray[0] % 2) == 0)
				whiteBallEven = true;
			else
				whiteBallEven = false;

			if ((intArray[1] % 2) == 0)
				blackBallEven = true;
			else
				blackBallEven = false;

			if (whiteBallEven && blackBallEven) {
				writer.write("Case #" + (testCaseNo - 1) + ": WHITE");
				writer.newLine();
			} else if (whiteBallEven && !(blackBallEven)) {
				writer.write("Case #" + (testCaseNo - 1) + ": BLACK");
				writer.newLine();
			} else if (!(whiteBallEven) && blackBallEven) {
				writer.write("Case #" + (testCaseNo - 1) + ": WHITE");
				writer.newLine();
			} else if (!(whiteBallEven) && !(blackBallEven)) {
				System.out.println("White Balls: " + intArray[0] + " Black Balls: " + intArray[1]);
				writer.write("Case #" + (testCaseNo - 1) + ": BLACK");
				writer.newLine();
			}
		}
		writer.close();
	}

	//	This method is created to capture input where the first line of the input is the number
	//	of test cases, and all the following lines are test cases.
	public static void captureInput() {
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
				}
				solveTestCase(countOfLine, line);
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

