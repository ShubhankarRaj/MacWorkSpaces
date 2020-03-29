import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class HackerEarth {
    //read treemap
    public static void main(String[] args) {
        String regex =".@.";
        ArrayList<String> test = new ArrayList<String>();
        System.out.println(test.size());
        test.add("h");
        test.add("hi");
        test.add("hii");
        test.add(1,"hiii");
        System.out.println(test.size());
        test.remove("hi");
        test.remove(2);
        System.out.println(test.size());

        int sum = 0;
        int a = 3;
        while(sum++ <3) {
            int b = (1+2 *sum)%3;
            switch(b) {
                default:
                case 0:
                    a -= 1;
                    break;
                case 1:
                    a += 5;
            }
            }
        System.out.println(a);

        ArrayList<String> testt = new ArrayList<String>();
        //testt.add(new Integer(1));

    }

    private void hackerEarth(String name) {
        if (name.equals("Java"))
            throw new IllegalArgumentException();

    }

    public double HackerEarth1() throws Exception {
        return 0.7;
        }


}

class Hacker1 {
    public static char readInput() {
        char c = '\u0000';
        int input = 0;
        try {
            input = System.in.read();
            if(input != -1)
                c = (char)input;
        } catch (IOException e) {

        }
        return c;
    }

    public static void main(String[] args) {
        char c = Hacker1.readInput();
        System.out.println(c);
    }
}


