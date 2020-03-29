package interview.bit.stacksandqueues;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Braces {

    /*
    Every expressions should have the same pairs of Braces as there are number of operators
     */
    public int braces(String A) {

        Stack<Character> braces = new Stack<>();
        List<Character> charList = A.chars().mapToObj(x -> (char) x).collect(Collectors.toList());
        int operatorCounter = 0;
        int bracesCounter = 0;

        for (Character ch : charList) {
            switch (ch) {
                case '(':
                    braces.push(ch);
                    break;

                case '+':
                    braces.push(ch);
                    operatorCounter++;
                    break;

                case '-':
                    braces.push(ch);
                    operatorCounter++;
                    break;

                case '*':
                    braces.push(ch);
                    operatorCounter++;
                    break;

                case '/':
                    braces.push(ch);
                    operatorCounter++;
                    break;

                case ')':

                    if (braces.peek() == '(')
                        //  There is a set of braces without any operator
                        return 1;

                    do{
                        if(braces.peek().toString().matches("[*+-/]")){
                            braces.pop();
                        }
                    }while(braces.peek() != '(');
                    bracesCounter++;
                    if (braces.peek() == '(')
                        braces.pop();

                    break;


            }
        }

        if(bracesCounter <= operatorCounter)
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        Braces br = new Braces();

        System.out.println(br.braces("(a*b)+(b*(d+(a)))"));
    }
}
