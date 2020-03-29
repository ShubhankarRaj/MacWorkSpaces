package googleCodeJam;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class StandingOvation {

	public static void main(String[] args) {
		int argLen = args.length;
		StandingOvation.ovation();
	}

	private static void writeOutput(String str) {
		File outputFile = new File("/Users/raj8lm/Downloads/output.out");
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

	private static void ovation() {
		File testInput = new File("/Users/raj8lm/Downloads/A-large.in");
		BufferedReader br = null;
		StringBuilder output = new StringBuilder();
		try {

			br = new BufferedReader(new FileReader(testInput));
			int numOfTest = Integer.parseInt(br.readLine());
			String test;
			String[] testSplit;
			int smax;
			String audience;
			int sno;
			int standing;
			int friend;
			// Loop through each test
			for (int testCount = 0; testCount < numOfTest; ++testCount) {
				test = br.readLine();

				testSplit = test.split(" ");
				smax = Integer.parseInt(testSplit[0]);
				audience = testSplit[1];
				standing = 0;
				friend = 0;
				for (int s = 0; s <= smax; s++) {
					sno = Integer.parseInt("" + audience.charAt(s));
					if (sno == 0)
						continue;
					if (s <= standing) {
						standing += sno;
					} else {
						friend += (s - standing);
						standing += (s - standing) + sno;

					}
				}

				output.append("Case #").append((testCount + 1)).append(": ")
						.append(friend);
				output.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		writeOutput(output.toString());
	}

}
