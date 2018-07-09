package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 08/07/18.
 */
public class SolutionLengthLastWord {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        if(A.equals(" "))
            return 0;
        String[] wordsList = A.split(" ");
        int lenOfList = wordsList.length;
        if(lenOfList == 0){
            return 0;
        }
        String lastWord = wordsList[lenOfList - 1];
        int lenOfLastWord = lastWord.length();
        return lenOfLastWord;
    }

    public static void main(String[] args) {
        SolutionLengthLastWord sol = new SolutionLengthLastWord();
        System.out.println(sol.lengthOfLastWord("  "));
    }
}
