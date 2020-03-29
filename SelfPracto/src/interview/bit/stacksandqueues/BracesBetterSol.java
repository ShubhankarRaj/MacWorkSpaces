package interview.bit.stacksandqueues;

import java.util.Stack;

public class BracesBetterSol {

    public int braces(String A){

        Stack<Character> stack = new Stack<>();

        for(Character ch : A.toCharArray()){
            if(ch.toString().matches("[*+-/(]"))
                stack.push(ch);
            else if(ch == ')'){
                if (stack.pop() == '(')
                    return 1;
                stack.pop();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BracesBetterSol br = new BracesBetterSol();

        System.out.println(br.braces("(a*b)+(b*(d+a+c))"));
    }
}
