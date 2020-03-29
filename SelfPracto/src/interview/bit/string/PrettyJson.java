package com.interview.bit.string;

import java.util.*;
import java.util.stream.Stream;

public class PrettyJson {

    static ArrayList<String> prettyList = new ArrayList<>();
    static int tabCounter = 0;
    static String str = new String();

    public ArrayList<String> prettyJSON(String A) {

        Stream<Character> charStream = A.chars().mapToObj( c -> (char)c);
        charStream.forEach(ch ->
        {
            System.out.println(ch);
            switch (ch){
                case '{':
                    addInList('{');
                    prettyList.add(System.lineSeparator());
                    str = "";
                    tabCounter++;
                case '[':
                    addInList('[');
                    prettyList.add(System.lineSeparator());
                    str = "";
                    tabCounter++;
                case '}':
                    tabCounter--;
                    addInList('}');
                    prettyList.add(System.lineSeparator());
                    str = "";
                case ']':
                    tabCounter--;
                    addInList('}');
                    prettyList.add(System.lineSeparator());
                    str = "";
                case ',':
                    if(!str.isEmpty())
                        str += String.valueOf(ch);
                    prettyList.add(System.lineSeparator());
                    str = "";
                default:
                    str += String.valueOf(ch);
            }
        }
        );
        return prettyList;
    }

    private static void addInList(Character ch){

        String str = new String("");
        for(int i = 1; i <= tabCounter; i++){
            str = "\t" + str;
        }

        prettyList.add(str + String.valueOf(ch));
    }

    public static void main(String[] args) {
        PrettyJson obj = new PrettyJson();
        System.out.println(obj.prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}"));
    }

}
