package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fractiles {
	static File outFile = null;
	static ArrayList<String> charArrayList = new ArrayList<String>();

	public static void main(String[] args) {
		// This method is created to capture input where the first line of the
		// input is the number
		// of test cases, and all the following lines are test cases.
		captureInputAndSolveTestCase();
	}

	private static void solveTestCase(int lineCount, String lineContent)
			throws IOException {
		String[] testDataStrArr = lineContent.split(" ");
		int[] testDataArr = new int[testDataStrArr.length];
		BufferedWriter writer = new BufferedWriter(
				new FileWriter(outFile, true));
		for (int i = 0; i < testDataStrArr.length; i++) {
			testDataArr[i] = Integer.parseInt(testDataStrArr[i]);
		}

		int k = testDataArr[0];
		int c = testDataArr[1];
		int s = testDataArr[2];
		System.out.print("Case #"+(lineCount -1)+": ");
		writer.write("Case #" + (lineCount - 1) + ": ");
		System.out.println(k+" "+c+" "+s);
		List<Integer> b= new ArrayList<Integer> ();
		List<List<Integer>> a = new ArrayList<List<Integer>> ();
		for(int i=0; i<k; i++) {
			b= new ArrayList<Integer> ();
			for(int j=i;j<i+c;j++){
				if(j<k) {
					b.add(j);
				} else {
					break;
				}
			}
			a.add(b);
		}
		
		
		
		
		if(s<a.size()) {
			System.out.println("IMPOSSIBLE");
			writer.write("IMPOSSIBLE");
			writer.newLine();
			writer.close();
			return;
		} 
		BigInteger kb = BigInteger.valueOf(k);;
		List<Integer> b1 = a.get(0);
		List<Integer> b2;
		List<BigInteger> power = new ArrayList<BigInteger> ();
		int maxPower=0;

		if(b1!=null) {
			for(int i=0;i<b1.size();i++) {
				if(i==0){
					power.add(BigInteger.ONE);
				} else {
					power.add(power.get(i-1).multiply(kb));
				}
			}
			maxPower=power.size()-1;
			
			List<BigInteger> position = new ArrayList<BigInteger>(); 
			BigInteger pos = BigInteger.ZERO;
			for(int i=0;i<a.size();i++) {
				pos = BigInteger.ZERO;
				b2=a.get(i);
				for(int j=0; j<b2.size();j++) {
					BigInteger val;
					
					val= power.get(maxPower-j).multiply(BigInteger.valueOf(b2.get(j)));
					pos=pos.add(val);
				}
				pos=pos.add(BigInteger.ONE);
				writer.write(pos+" ");
				
			}
			
			
		}
		System.out.println();
		writer.newLine();
		
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
