package amazonQuest;

import java.util.ArrayList;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SwapAndSort {
	public static void kSwap(List<Integer> input, int k) {
        if (k == 0 || input.size() <= k) {
            return;
        }

        // Finding the maximum digit in the list
        int m = getMaxDigit(input, k);

        // This contains all indexes in the array, that == m
        List<Integer> maxPositions = new ArrayList<>();

        // This contains all values from 0 to maxPosition.size()
        List<Integer> forSwapping = new ArrayList<>();

        int leftCursor = 0;
        // We iterate two cursors - one from the end that gathers indices of all values == m
        // and the other from the head - just increment. Loop stops when cursors meet
        for (int i = input.size() - 1; i > 0 && i > leftCursor; i--) {
            if (input.get(i) == m) {
                forSwapping.add(input.get(leftCursor));
                maxPositions.add(i);
                leftCursor++;
            }
        }
        int len = maxPositions.size();

        // The most important part - we sort the 'head' in ascending order
        // to move in place of maximum elements in correct order
        Collections.sort(forSwapping);

        // Now just swap max item elements with #len first ones
        for (int i = 0; i < len; i++) {
            input.set(i, m);
            input.set(maxPositions.get(i), forSwapping.get(i));
        }

        // Recurse for sublist (#len first elements are already inplace)
        kSwap(input.subList(len, input.size()), k - len);
    }

    private static int getMaxDigit(List<Integer> input, int k) {
        return input.stream().max(Comparator.<Integer>naturalOrder()).get();
    }

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(1, 3, 2));
        int k = 1;
        kSwap(l, k);
        System.out.println(l);

        l = new ArrayList<>(Arrays.asList(1, 3, 2));
        k = 2;
        kSwap(l, k);
        System.out.println(l);

        l = new ArrayList<>(Arrays.asList(7, 8, 9, 9));
        k = 2;
        kSwap(l, k);
        System.out.println(l);

        l = new ArrayList<>(Arrays.asList(8, 7, 9, 9));
        k = 2;
        kSwap(l, k);
        System.out.println(l);

        l = new ArrayList<>(Arrays.asList(8, 7, 6, 9, 5, 9));
        k = 3;
        kSwap(l, k);
        System.out.println(l); // This is not correct :((

    }
}
