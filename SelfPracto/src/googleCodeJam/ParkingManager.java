package googleCodeJam;

import java.util.Scanner;


public class ParkingManager {
    static int[] dimensions = new int[2];
    static int[][][] parkingLotArray;

    public static void main(String args[]) {
        Scanner scnSystemStartupParkingLotSize = new Scanner(System.in);
        System.out.println("Enter the parking lot size in aXb format where \n"
                + "a is the number of rows and b is the number of columns: ");

        String parkingLotSize = scnSystemStartupParkingLotSize.next();
        //    Storing the dimensions of the Parking lot

        //    Delimiter which we are asking the user to enter
        char delimeter = 'X';
        String[] arr = parkingLotSize.split(Character.toString(delimeter));
        for (int i = 0; i < dimensions.length; i++) {
            dimensions[i] = Integer.parseInt(arr[i]);
        }

        System.out.println("No. of ROWS in Parking Lot: " + dimensions[0]);
        System.out.println("No. of COLS in Parking Lot: " + dimensions[1]);

        System.out.println("Enter the ROW which is the GROUND level:");
        String groundLevelRow = scnSystemStartupParkingLotSize.next();

        System.out.println("/n # INITIALIZING PARKING LOT #");

        //    Create the 2-D matrix for parking lot based upon the ROWS and COLS
        //    The parking lot array is made Three dimensional so that in the third dimension we can
        //    track the META information of the slot, like filled or empty. In the entire parking lot
        //    there would always be one slot which be empty on all times.

        parkingLotArray = new int[dimensions[0]][dimensions[1]][2];

        //    Assuming that the first slot of the parking lot is going to be blank at the time of initializing
        //    For rest of the slots in parking lot, enter the slot ID and boolean cargo indicator
        int empty = 0;
        int non_empty = 1;
        int shelfSerialNo = 1;

        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                if (i == 0 && j == 0) {
                    parkingLotArray[i][j][0] = shelfSerialNo;
                    parkingLotArray[i][j][1] = empty;
                } else {
                    parkingLotArray[i][j][0] = shelfSerialNo;
                    parkingLotArray[i][j][1] = non_empty;
                }
                shelfSerialNo++;
            }
        }

        //    Printing the 3D Array
        printParkingLot(parkingLotArray);

        //    The LIFT is INITIALIZED. Now we would create the mechanism to identify a
        //    SLOT and accordingly bring it to middle row on any column
        Scanner scnUserInput = new Scanner(System.in);


        while (!scnUserInput.next().equals("QUIT")) {
            System.out.println("Enter the SHELF which you want to bring to the GROUND");
            int desiredSlot = scnUserInput.nextInt();
            int emptyRow = 0;
            int emptyColumn = 0;

            outerloop:
            for (int i = 0; i < dimensions[0]; i++) {
                for (int j = 0; j < dimensions[1]; j++) {
                    if (parkingLotArray[i][j][1] == empty) {
                        emptyRow = i;
                        emptyColumn = j;
                        break outerloop;
                    }
                }
            }

            //  The desired slot is actually the position in the Array. For example if the user has entered 4 as the
            //  slot to be picked up and the GROUND level is row 1, then the movemnet is simple:
            //  content of array[1,0] >> content of array[0,0](empty)
            //  But if somebody wants SHELF no 9 to GROUND LEVEL at row 1, then this should be the flow:
            //  SHELF2 move to 0,0; SHELF3 move to 0,1; SHELF6 move to 0,2;
            //  SHELF9 move to 1,2; SHELF 8 move to 2,2; SHELF5 move to 2,1;
            //  SHELF3 move to 1,1; SHELF6 move to 0,1; SHELF9 move to 0,2

            //  Step1: Find the position where the SHELF is currently present
            //  Step2: Find the position where the EMPTY Slot is present
            //  Step3: Move all the elements towards the EMPTY SLOT so that the desired shelf reaches Ground Row
            //  Step4: In case after moving one step, the desired shelf has not reached Ground level, again the
            //  analysis need to be done as per the below mentioned algo

            /*
             *   Three parameters are primary here: 1. Empty slot(E); 2. Desired slot(D); 3. Ground row(G)
             *   if(row(D) = G)
             *       then "Vehicle is ready to be taken out"
             *   if(row(D) < G && row(D) = row(E))
             *       then E = Shelf@ [row(E)-1,col(E)]
             *       [row(E) - 1, col(E)] = new E
             *
             *   if(row(D) < G && row(D) < row(E))
             *      then
             *
             * */
          //  getTheCar(desiredSlot, emptyRow, emptyColumn, groundLevelRow);

        }
        //    Closing the SCANNER objects
        scnUserInput.close();
        scnSystemStartupParkingLotSize.close();
    }

    static void printParkingLot(int[][][] parkingArray) {

        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                System.out.print("SLOT NO:" + i + "," + j + "->");
                System.out.print("SHELF No:" + parkingArray[i][j][0]);
                System.out.print("->");

                if (parkingArray[i][j][1] == 0) {
                    System.out.print("###EMPTY###");
                } else {
                    System.out.print("NOT-EMPTY   ");
                }
            }
            System.out.println();
        }
    }

    static void getTheCar(int desiredSlot, int emptySlotRow, int emptySlotColumn, int groundLevelRow) {
        int row, column;
        int desiredSlotRow = 0;
        int desiredSlotCol = 0;
        boolean shouldIReturn = false;

        while (!shouldIReturn) {
            outerloop:
            for (row = 0; row < dimensions[0]; row++) {
                for (column = 0; column < dimensions[1]; column++) {
                    if (parkingLotArray[row][column][0] == desiredSlot) {
                        desiredSlotRow = row;
                        desiredSlotCol = column;
                        break outerloop;
                    }
                }
            }

            if (desiredSlotRow == groundLevelRow) {
                printParkingLot(parkingLotArray);
                shouldIReturn = true;
                return;
            }

            if ((desiredSlotRow < groundLevelRow) && (desiredSlotRow == emptySlotRow)) {
                if (desiredSlotCol < emptySlotColumn) {

                }
                if (desiredSlotCol > emptySlotColumn) {

                }

            }

            if ((desiredSlotRow < groundLevelRow) && (desiredSlotRow < emptySlotRow)) {

                if (desiredSlotCol < emptySlotColumn) {

                }
                if (desiredSlotCol > emptySlotColumn) {

                }
            }

            if ((desiredSlotRow < groundLevelRow) && (desiredSlotRow > emptySlotRow)) {
                if (desiredSlotCol < emptySlotColumn) {

                }
                if (desiredSlotCol > emptySlotColumn) {

                }
            }

            if ((desiredSlotRow > groundLevelRow) && (desiredSlotRow == emptySlotRow)) {

                if (desiredSlotCol < emptySlotColumn) {

                }
                if (desiredSlotCol > emptySlotColumn) {

                }

            }

            if ((desiredSlotRow > groundLevelRow) && (desiredSlotRow < emptySlotRow)) {

                if (desiredSlotCol < emptySlotColumn) {

                }
                if (desiredSlotCol > emptySlotColumn) {

                }

            }

            if ((desiredSlotRow > groundLevelRow) && (desiredSlotRow > emptySlotRow)) {

                if (desiredSlotCol < emptySlotColumn) {

                }
                if (desiredSlotCol > emptySlotColumn) {

                }

            }


        }


    }
}
