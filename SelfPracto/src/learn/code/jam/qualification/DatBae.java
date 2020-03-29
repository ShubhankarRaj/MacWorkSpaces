package com.learn.code.jam.qualification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DatBae {

    public static void main(String[] args) throws IOException {
        long beginTime = System.nanoTime();
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        int totalTestCount = Integer.parseInt(br.readLine());

        outerloop:
        for (int i = 1; i <= totalTestCount; i++) {

            int[] nbfInfo = Arrays.stream(br.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int testLimit = nbfInfo[2];

            //  Running the Loop within the testLimit to get the right indices
            //  But our target is to get the right indices in the first go only
            while (testLimit >= 1) {

                String brokenWorkerIndex = findBrknWrkrIndex(br, nbfInfo);

                //  Print the broken Indices for the JUDGE to pass his verdict
                System.out.println(brokenWorkerIndex);

                int verdict = Integer.parseInt(br.readLine());
                if (verdict == -1) {
                    System.err.println("Guessed the Broken Indices Incorrectly!");
                    break outerloop;
                } else if (verdict == 1) {
                    testLimit = 0;
                    break;
                }
                testLimit--;
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }

    private static String findBrknWrkrIndex(BufferedReader br, int[] nbfInfo) throws IOException {
        int noBinaryChars = nbfInfo[0];
        int noBrknWorkrs = nbfInfo[1];

        //  The logic for finding the broken indices is to start from one end and to reach the other end
        //  Simplest logic for finding the non working brokers is to pass a input with single 1 and check the output
        //  Eg., B0 B1 B2 B3 B4 (0 & 3 are not working)
        //  Input 10000 -> 000 (Conclusion is B0 not working)
        //  Input 01000 -> 100 (Conclusion is B1 working)
        //  Likewise, we can get the other brokers not working

        int[] brknWrkrIndx = new int[noBinaryChars];

        StringBuilder index = new StringBuilder();

        for (int i = 0; i < brknWrkrIndx.length; i++) {
            if (i == 0) {
                brknWrkrIndx[0] = 1;
                continue;
            } else {
                brknWrkrIndx[i] = 0;
            }
        }
        int indexOf1 = 0;
        String attempt = Arrays.toString(brknWrkrIndx);

        attempt = attempt.replace("[", "").replace("]", "").replace(",", "").replace(" ", "");


        while (noBrknWorkrs > 0) {

            System.out.println(attempt);

            String response = br.readLine();
            if (!response.contains("1")) {
                index.append(indexOf1);
                --noBrknWorkrs;
                if (noBrknWorkrs > 0) {
                    index.append(" ");
                } else {
                    break;
                }
            }
            char[] attemptToChar = attempt.toCharArray();
            if (indexOf1 < attempt.length()) {
                attemptToChar[indexOf1] = '0';
                attemptToChar[indexOf1 + 1] = '1';
                attempt = new String(attemptToChar);
                indexOf1++;
            }
        }

        return index.toString();
    }
}
