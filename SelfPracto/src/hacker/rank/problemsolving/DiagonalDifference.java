package com.hacker.rank.problemsolving;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int difference = 0;
        //  Sum of diagonal Left to Right
        int lengthOfSquare = arr.size();
        int sumOfDiagonalLToR = 0;
        int sumOfDiagonalRToL = 0;

        for(int i = 0; i < lengthOfSquare; i++){
            sumOfDiagonalLToR += arr.get(i).get(i);
        }
        int j = 0;
        for(int i = lengthOfSquare - 1; i >= 0 ; i--){

            sumOfDiagonalRToL += arr.get(i).get(j);
            j++;
        }

        if(sumOfDiagonalLToR >= sumOfDiagonalRToL)
           return sumOfDiagonalLToR - sumOfDiagonalRToL;
        else
            return sumOfDiagonalRToL - sumOfDiagonalLToR;
    }

    public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> arr = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    arr.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            int result = DiagonalDifference.diagonalDifference(arr);

            /*bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();

            bufferedReader.close();
            bufferedWriter.close();*/
        }
    }



