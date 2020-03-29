package practise;

import java.util.ArrayList;

public class TestLambda {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(100);
        list.add(-20);
        list.add(0);

        list.forEach(n -> {if(n%2 == 0) System.out.println(n);});

    }
}
