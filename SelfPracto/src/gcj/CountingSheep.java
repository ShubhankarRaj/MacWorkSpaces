package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountingSheep {

	static File outFile = null;

	public static void main(String[] args) {
		// This method is created to capture input where the first line of the
		// input is the number
		// of test cases, and all the following lines are test cases.
		captureInputAndSolveTestCase();
	}

	private static void solveTestCase(int lineCount, String lineContent)
			throws IOException {
		// The line content is the number which we are going to multiply
		int number = Integer.parseInt(lineContent);
		Map<Integer, String> trackDigitVisited = new HashMap<Integer, String>();
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(outFile, true));
		for (int i = 0; i < 10; i++) {
			trackDigitVisited.put(i, "NOTFOUND");
		}
		boolean allDigitsCovered = false;
		int multiplier = 1;
		int product;
		while (!allDigitsCovered) {
			product = number * multiplier;
			if (product == 0) {
				System.out.println("Case #" + (lineCount - 1) + ": " + product);
				writer.write("Case #" + (lineCount - 1) + ": INSOMNIA");
				writer.newLine();
				allDigitsCovered = true;
			} else {
				String productInStringFormat = String.valueOf(product);
				char[] digitsInProd = productInStringFormat.toCharArray();
				for (int i = 0; i < digitsInProd.length; i++) {
					String noPresentInMap = trackDigitVisited.get(Integer
							.parseInt(Character.toString(digitsInProd[i])));
					if (noPresentInMap.equals("NOTFOUND")) {
						trackDigitVisited.put(Integer.parseInt(Character
								.toString(digitsInProd[i])), "DIGIT FOUND");
					}
				}
				if (!trackDigitVisited.containsValue("NOTFOUND")) {
					System.out.println("Case #" + (lineCount - 1) + ": "
							+ product);
					writer.write("Case #" + (lineCount - 1) + ": " + product);
					writer.newLine();
					allDigitsCovered = true;
				}
			}
			multiplier++;
		}
		writer.close();
	}

	// This method is created to capture input where the first line of the input
	// is the number
	// of test cases, and all the following lines are test cases.
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
					System.out
							.println("Total count of cases in the input file is: "
									+ line);
				} else {
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
