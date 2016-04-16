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

public class MushroomMonster {
	static File outFile = null;
	static int intervalCount = 0;

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
			System.out
					.println("Total number of Intervals here :" + lineContent);
			intervalCount = Integer.parseInt(lineContent);
		}
		if (lineCount % 2 != 0) {
			List<String> mushroomCountList = Arrays.asList(lineContent
					.split(" "));
			System.out.println("Case #" + ((lineCount - 1) / 2) + ": "
					+ computationMethod1(mushroomCountList) + " "
					+ computationMethod2(mushroomCountList));
			writer.write("Case #" + ((lineCount - 1) / 2) + ": "
					+ computationMethod1(mushroomCountList) + " "
					+ computationMethod2(mushroomCountList));
			writer.newLine();
			writer.close();
		}
	}

	private static int computationMethod1(List<String> mushroomCountList) {
		int totalNumberOfMushroomsConsumed = 0;
		for (int i = 1; i < mushroomCountList.size(); i++) {
			if (Integer.parseInt(mushroomCountList.get(i)) < Integer
					.parseInt(mushroomCountList.get(i - 1))) {
				totalNumberOfMushroomsConsumed = totalNumberOfMushroomsConsumed
						+ (Integer.parseInt(mushroomCountList.get(i - 1)) - Integer
								.parseInt(mushroomCountList.get(i)));
			}
		}
		return totalNumberOfMushroomsConsumed;
	}

	private static int computationMethod2(List<String> mushroomCountList) {
		int biggestChunkOfMushroomsEaten = 0;
		int numberOfMushroomsConsumed = 0;

		for (int i = 1; i < mushroomCountList.size(); i++) {
			int diff = Integer.parseInt(mushroomCountList.get(i - 1))
					- Integer.parseInt(mushroomCountList.get(i));
			biggestChunkOfMushroomsEaten = (biggestChunkOfMushroomsEaten < diff) ? diff
					: biggestChunkOfMushroomsEaten;
		}
		// Now we have the rate at which Kaylin had consumed the MUSHROOMS
		// And this rate is for every 10 seconds
		int rateOfMushroomsPerSecond = biggestChunkOfMushroomsEaten / 10;
		for (int i = 1; i < mushroomCountList.size(); i++) {
			// CHecking the condition when the first interval has higher number
			// of mushrooms than the 2nd one
			if (Integer.parseInt(mushroomCountList.get(i)) <= Integer
					.parseInt(mushroomCountList.get(i - 1))) {
				// The value at i-1 are the number of mushrooms consumed
				// But we need to check if this number is less or equal to the
				// rate
				if (Integer.parseInt(mushroomCountList.get(i - 1)) <= biggestChunkOfMushroomsEaten) {
					numberOfMushroomsConsumed = numberOfMushroomsConsumed
							+ (Integer.parseInt(mushroomCountList.get(i - 1)));

				} else {
					numberOfMushroomsConsumed = numberOfMushroomsConsumed
							+ biggestChunkOfMushroomsEaten;
					// carryForward =
					// Integer.parseInt(mushroomCountList.get(i-1)) -
					// biggestChunkOfMushroomsEaten;
				}
			} else {
				if (Integer.parseInt(mushroomCountList.get(i - 1)) <= biggestChunkOfMushroomsEaten) {
					numberOfMushroomsConsumed = numberOfMushroomsConsumed
							+ Integer.parseInt(mushroomCountList.get(i - 1));
				} else {
					numberOfMushroomsConsumed = numberOfMushroomsConsumed
							+ biggestChunkOfMushroomsEaten;
				}
			}
		}
		return numberOfMushroomsConsumed;
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
