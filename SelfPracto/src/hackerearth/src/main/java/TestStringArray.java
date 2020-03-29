

public class TestStringArray {
    static int string_minimization(String str) {
        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);

        if(firstChar != lastChar)
            return str.length();
        else {
            return splitString(str);
        }

    }

    static int splitString(String input) {
        for (int i =0;i<input.length();i++) {
            for (int j = input.length()-1;j>=0;j--) {
                if(input.charAt(i) == input.charAt(j)) {
                    i++;
                    j--;
                } else if(input.charAt(i) == input.charAt(i-1)) {
                    i++;
                } else if(input.charAt(j) == input.charAt(j+1)) {
                    j--;
                } else {
                    break;
                }
            }
        }
        return 0;
    }
}
