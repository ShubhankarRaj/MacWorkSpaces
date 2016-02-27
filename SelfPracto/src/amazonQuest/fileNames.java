package amazonQuest;

import java.io.File;
import java.io.FileFilter;

public class fileNames {
	public static void main(String args[]){
		String fileDir = "/MyData/StudyDocs/";
        File dir = new File(fileDir);
       // FileFilter fileFilter = new WildcardFileFilter("*.html");
        File[] files = dir.listFiles();
        for(int i = 0; i < files.length; i++){
        	System.out.println(files[i].getName());
        }
	}
}
