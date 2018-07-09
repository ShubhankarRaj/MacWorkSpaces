package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 08/07/18.
 */
public class SolutionLongestCommonPrefix {
    public String longestCommonPrefix(ArrayList<String> A) {
        int minLenOfStr = Integer.MAX_VALUE;
        int currLenOfStr;
        for(String str:A){
            currLenOfStr = str.length();
            minLenOfStr = (currLenOfStr < minLenOfStr) ? currLenOfStr : minLenOfStr;
        }
        ArrayList<Character> commonPrefix = new ArrayList<>();
        boolean isCommon = true;
        for(int i = 0; i < minLenOfStr; i++){
            String refString = A.get(0);
            for(String strToComp:A){
                if(strToComp.charAt(i) != refString.charAt(i)) {
                    isCommon = false;
                    break;
                }
            }
            if(isCommon)
                commonPrefix.add(refString.charAt(i));
        }

        StringBuilder builder = new StringBuilder(commonPrefix.size());
        for(Character ch: commonPrefix){
            builder.append(ch);
        }
        String output = builder.toString();
        if(output.equals("")){
            return "";
        }
        return output;
    }

    public static void main(String[] args) {
        SolutionLongestCommonPrefix sol = new SolutionLongestCommonPrefix();
        ArrayList<String> list = new ArrayList<>();
        list.add("abcd");
        list.add("abcd");
        list.add("efgh");
        System.out.println(sol.longestCommonPrefix(list));
    }
}
