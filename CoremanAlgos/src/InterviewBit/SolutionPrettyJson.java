package InterviewBit;

import java.util.ArrayList;

/**
 * Created by raj8lm on 08/07/18.
 */
public class SolutionPrettyJson {
    public ArrayList<String> prettyJSON(String A) {
        ArrayList<String> prettyJson = new ArrayList<>();
        char[] inputArr = A.toCharArray();
       /* int overallTabCount = 0;
        for(int i = 0; i < inputArr.length; i++) {
            if ((i  == 0) && (inputArr[i] == '{'){
                prettyJson.add(String.valueOf(inputArr[i]));
            }
            if((i > 0) && (inputArr[i] == '{')){
                if(inputArr[i - 1] == '{'){
                    overallTabCount++;
                    int tabCountForRow = overallTabCount;
                    String tabbeforeDoubleBrace = "";
                    while(tabCountForRow > 0)
                    {
                        tabbeforeDoubleBrace = tabbeforeDoubleBrace + "\t";
                        tabCountForRow--;
                    }
                    prettyJson.add(tabbeforeDoubleBrace);
                    prettyJson.get(prettyJson.size()-1).concat(String.valueOf(inputArr[i]));
                }else {
                    int tabCountForRow = overallTabCount;
                    String tabbeforeSingleBrace = "";
                    while(tabCountForRow > 0)
                    {
                        tabbeforeSingleBrace = tabbeforeSingleBrace + "\t";
                        tabCountForRow--;
                    }
                    prettyJson.add(tabbeforeSingleBrace);
                    prettyJson.get(prettyJson.size()-1).concat(String.valueOf(inputArr[i]));
                }
            }
            if((i > 0) && (inputArr[i] != '{')){
                //  Here we are checking for normal literals like alphabets or numbers
                if(inputArr[i - 1] == '{'){
                    overallTabCount++;
                    int tabCountForRow = overallTabCount;
                    String tabbeforeCharWithBrace = "";
                    while(tabCountForRow > 0)
                    {
                        tabbeforeCharWithBrace = tabbeforeCharWithBrace + "\t";
                        tabCountForRow--;
                    }
                    prettyJson.add(tabbeforeCharWithBrace);
                    prettyJson.get(prettyJson.size()-1).concat(String.valueOf(inputArr[i]));
                }else{
                    int tabCountForRow = overallTabCount;
                    String tabbeforeCharWithoutBrace = "";
                    while(tabCountForRow > 0)
                    {
                        tabbeforeCharWithoutBrace = tabbeforeCharWithoutBrace + "\t";
                        tabCountForRow--;
                    }
                    prettyJson.add(tabbeforeCharWithoutBrace);
                    prettyJson.get(prettyJson.size()-1).concat(String.valueOf(inputArr[i]));
                }
                if(inputArr[i] == ','){
                    prettyJson.get(prettyJson.size()-1).concat(String.valueOf(inputArr[i]));
                }
                if(inputArr[i -1] == ','){

                }
                else
                    prettyJson.get(prettyJson.size()-1).concat(String.valueOf(inputArr[i]));

            }

        }*/

        return prettyJson;
    }
}
