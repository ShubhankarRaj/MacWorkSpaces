package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 08/07/18.
 */
public class SolutionJustifiedText {
    public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        ArrayList<String> justifiedText = new ArrayList<>();

        if ((A.size()<1))
            return justifiedText;

        StringBuilder builder = new StringBuilder(A.size());
        for(String str: A){
            builder.append(str);
        }
        String output = builder.toString();

        if(output.equals("")){
            justifiedText.add("");
            return justifiedText;
        }

        int wordCount = A.size();
        int curLengthOfChars = 0;
        StringBuilder strB = new StringBuilder();
        boolean justifiedLimitMet = false;
        for(int i = 0; i < wordCount; i++){
            String word = A.get(i);
            if(word.length() > B)
                throw new IllegalArgumentException();

            else if((word.length() <= B) && ((curLengthOfChars + word.length()) <= B)){
                if((curLengthOfChars + word.length()) == B){
                    strB.append(word);
                    curLengthOfChars = strB.length();
                    justifiedLimitMet = true;
                }else{
                    strB.append(word);
                    curLengthOfChars = strB.length();

                    if (((i+1) < wordCount) && ((A.get(i + 1).length() + curLengthOfChars + 1) <= B)){
                        strB.append(" ");
                        curLengthOfChars = strB.length();
                    }else{
                        justifiedLimitMet = true;
                    }
                }
            }

            String interimText = String.valueOf(strB);
            String[] interimTextArray = interimText.split(" ");
            if(justifiedLimitMet){
                int numberOfSpacesToAppend = B - curLengthOfChars;
                if( String.valueOf(strB).equals(A.get(wordCount-1))){
                    //  This means that we are at last row of the list and it contains only the last word, which is already justified
                    while(numberOfSpacesToAppend > 0){
                        strB.append(' ');
                        numberOfSpacesToAppend--;
                    }
                    justifiedText.add(String.valueOf(strB));
                    return justifiedText;
                }else if(interimTextArray[interimTextArray.length - 1].equals(A.get(wordCount - 1))){
                    //  This means that we are at the end of the justification Text para. And we can rend this row with naturl left justification
                    while(numberOfSpacesToAppend > 0){
                        strB.append(' ');
                        numberOfSpacesToAppend--;
                    }
                    justifiedText.add(String.valueOf(strB));
                    return justifiedText;
                }
                else {

                    strB = appendSpaces(strB, numberOfSpacesToAppend);
                    justifiedText.add(String.valueOf(strB));
                }

                strB = new StringBuilder();
                curLengthOfChars = strB.length();
                justifiedLimitMet = false;
            }
        }
        //justifiedText.add(String.valueOf(strB));

        return justifiedText;
    }

    static StringBuilder appendSpaces(StringBuilder stringBuildObj, int numOfSpacesToAdd){

        int numberOfSpacesInCurrList = stringBuildObj.length() - String.valueOf(stringBuildObj).trim().length();
        String theVariableSpaceStr= " ";
        String theFixedSpaceStr = " ";
        StringBuilder temp = new StringBuilder();

        while(numOfSpacesToAdd > 0){
            String[] arr = String.valueOf(stringBuildObj).split(theVariableSpaceStr);
            if(arr.length == 1){
                //  This means that we have received only one word and spaces need to be appended to the right of the word
                temp.append(arr[0]);
                temp.append(theFixedSpaceStr);
                numOfSpacesToAdd--;
            }
            else {
                for (int i = 0; i < arr.length - 1; i++) {

                    temp.append(arr[i]);
                    temp.append(theVariableSpaceStr);

                    if (numOfSpacesToAdd > 0) {
                        temp.append(theFixedSpaceStr);
                        numOfSpacesToAdd--;
                    }

                    if (i == arr.length - 2)
                        temp.append(arr[i + 1]);
                }
            }
            stringBuildObj = temp;
            theVariableSpaceStr = theVariableSpaceStr+theFixedSpaceStr;
            temp = new StringBuilder();


        }
        return stringBuildObj;
    }

    public static void main(String[] args) {
        SolutionJustifiedText sol = new SolutionJustifiedText();
        ArrayList<String> arr = new ArrayList<>();
        /*arr.add("This");
        arr.add("is");
        arr.add("an");arr.add("example");
        arr.add("of");
        arr.add("text"); arr.add("justification.");*/
        //arr.add("");
        /*arr.add("am");
        arr.add("fasgoprn"); arr.add("lvqsrjylg"); arr.add("rzuslwan"); arr.add("xlaui"); arr.add("tnzegzuzn"); arr.add("kuiwdc");
        arr.add("fofjkkkm"); arr.add("ssqjig"); arr.add("tcmejefj"); arr.add("uixgzm");arr.add("lyuxeaxsg"); arr.add("iqiyip"); arr.add("msv"); arr.add("uurcazjc");
        arr.add("earsrvrq"); arr.add("qlq"); arr.add("lxrtzkjpg"); arr.add("jkxymjus"); arr.add("mvornwza"); arr.add("zty"); arr.add("q"); arr.add("nsecqphjy");*/
        arr.add("What"); arr.add("must"); arr.add("be"); arr.add("shall"); arr.add("be.");
        int justifiedCharCount = 12;
        ArrayList<String> justifiedText = sol.fullJustify(arr, justifiedCharCount);
        for(String str: justifiedText){
            System.out.println(str);
        }

    }
}
