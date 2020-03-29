package com.learn.misc;

import java.util.ArrayList;

/**
 * Created By MMT6540 on 11 Jun, 2018
 */
public class SolutionFindStepsCount {


        public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

            int sizeOfXCord = A.size();
            int sizeOfYCord = B.size();
            if(sizeOfXCord != sizeOfYCord){
                return 0;
            }
            int stepCount = 0;

            //  Skipping the first element as that contains only the size
            for(int i = 0; i < sizeOfXCord-1; i++){
                Point origin = new Point(A.get(i), B.get(i));
                Point destination = new Point(A.get(i+1), B.get(i+1));

                while(!(origin.getX() == destination.getX() && origin.getY() == destination.getY())) {
                    //Based upon the difference in the co-ordinates, we would make out whether to traverse diagnollay or horizontally/vertically
                    if ((origin.getX() == destination.getX()) || (origin.getY() == destination.getY())) {
                        //  This means that the points are in straight line
                        while (origin.getX() == destination.getX() && (origin.getY() != destination.getY())) {
                            stepCount = stepCount + 1;
                            if (origin.getY() < destination.getY()) {
                                origin.y = origin.getY() + 1;
                            } else {
                                origin.y = origin.getY() - 1;
                            }
                        }
                        while (origin.getX() != destination.getX() && (origin.getY() == destination.getY())) {
                            stepCount = stepCount + 1;
                            if (origin.getX() < destination.getX()) {
                                origin.x = origin.getX() + 1;
                            } else {
                                origin.x = origin.getX() - 1;
                            }
                        }
                    } else {
                        //  This means that we need to make a diagonal move and we need to understand the direction
                        if(origin.getX() < destination.getX() && origin.getY() < destination.getY()){
                            stepCount = stepCount + 1;
                            origin.x = origin.getX() + 1;
                            origin.y = origin.getY() + 1;
                        } else if(origin.getX() > destination.getX() && origin.getY() > destination.getY()){
                            stepCount = stepCount + 1;
                            origin.x = origin.getX() - 1;
                            origin.y = origin.getY() - 1;
                        } else if(origin.getX() > destination.getX() && origin.getY() < destination.getY()){
                            stepCount = stepCount + 1;
                            origin.x = origin.getX() - 1;
                            origin.y = origin.getY() + 1;
                        } else if(origin.getX() < destination.getX() && origin.getY() > destination.getY()){
                            stepCount = stepCount + 1;
                            origin.x = origin.getX() + 1;
                            origin.y = origin.getY() - 1;
                        }
                    }
                }


            }
            return stepCount;
        }

        class Point{
            int x,y;
            public Point(Integer x, Integer y){
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }
        }

    public static void main(String[] args) {
        SolutionFindStepsCount newSol= new SolutionFindStepsCount();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        /*
        A : [ 4, 8, -7, -5, -13, 9, -7, 8 ]
B : [ 4, -15, -10, -3, -13, 12, 8, -8 ]
         */
        A.add(4);
        A.add(8);
        A.add(-7);
        A.add(-5);
        A.add(-13);
        A.add(9);
        A.add(-7);
        A.add(8);
        B.add(4);
        B.add(-15);
        B.add(-10);
        B.add(-3);
        B.add(-13);
        B.add(12);
        B.add(8);
        B.add(-8);
        System.out.println(newSol.coverPoints(A, B));
    }

}