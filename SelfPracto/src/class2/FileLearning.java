package class2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileLearning {
	public static void main(String[] args) throws IOException {
		File path = new File(File.listRoots()[0], "Users"+System.getProperty("file.separator")+"raj8lm"+System.getProperty("file.separator")+"Desktop"+System.getProperty("file.separator"));
		System.out.println(path);
		File file = new File(path+"/a.txt");
		file.createNewFile();

		// true is for append
		FileWriter fw = new FileWriter(file, true);
		fw.write("testcase login failed " + new Date() +" \n");
		fw.close();

		FileReader fr = new FileReader(file);
		char[] ch = new char[100];
		fr.read(ch);
		System.out.println(ch);
		fr.close();

		// BufferedReader
		// BufferedWriter
	}
}
