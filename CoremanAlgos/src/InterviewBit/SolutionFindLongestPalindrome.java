package InterviewBit;

/**
 * Created by raj8lm on 13/07/18.
 */
public class SolutionFindLongestPalindrome {
    public String longestPalindrome(String A) {

        if(A.length() == 1){
            return A;
        }
        if(A.length() == 2){
            if(A.charAt(0) == A.charAt(1)){
                return A;
            } else {
                return A.substring(0, 1);
            }
        }

        String substring = "";
        int substringLength = Integer.MIN_VALUE;
        int lenOfCurrentSubString = 0;
        for(int i = 1; i < A.length(); i++){
            for(int j = i-1, k = i+1; j>=0 && k <A.length(); j--, k++){
                if(A.charAt(j) == A.charAt(k)){
                    if(k - j + 1 >= 3){
                        lenOfCurrentSubString = k - j + 1;
                        if(lenOfCurrentSubString > substringLength) {
                            substringLength = lenOfCurrentSubString;
                            substring = A.substring(j, k + 1);
                        }
                    }
                }else
                    break;
            }
        }

        for(int i = 1; i < A.length(); i++) {
            for (int j = i, k = i + 1; j >= 0 && k < A.length(); j--, k++) {
                if (A.charAt(j) == A.charAt(k)) {
                    if (k - j + 1 >= 2) {
                        lenOfCurrentSubString = k - j + 1;
                        if (lenOfCurrentSubString > substringLength) {
                            substringLength = lenOfCurrentSubString;
                            substring = A.substring(j, k + 1);
                        }
                    }
                } else
                    break;
            }
        }
        return substring;
    }

    public static void main(String[] args) {
        SolutionFindLongestPalindrome sol = new SolutionFindLongestPalindrome();
        System.out.println(sol.longestPalindrome("aaaabaaa"));
    }
}
