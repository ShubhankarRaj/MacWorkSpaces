package com.learn.code.jam.round1a;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
    public static void main(String[] args) {
     diceRolls(6);
    }

    public static void diceRolls(int dice) {
        List<Integer> chosen = new ArrayList<Integer>();
        diceRolls(dice, chosen);
    }

    // private recursive helper to implement diceRolls logic
    private static void diceRolls(int dice, List<Integer> chosen) {
        System.out.println("Entering diceRolls with dice="+dice);
        if (dice == 0) {
            System.out.println(chosen); // base case
        } else {
            for (int i = 1; i <= 6; i++) {
                System.out.println("Starting for loop. i="+i+", dice="+dice);
                chosen.add(i); // choose
                diceRolls(dice - 1, chosen); // explore
                chosen.remove(chosen.size() - 1); // un-choose
                System.out.println("Ending for loop. i="+i+", dice="+dice);
            }
            System.out.println("Exiting diceRolls with dice="+dice);
        }
    }
}
