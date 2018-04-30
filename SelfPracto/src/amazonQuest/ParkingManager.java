package amazonQuest;
import java.util.Scanner;
public class ParkingManager {
      static int[] dimensions = new int[2];
      static int userLevel;
      //    Storing the dimensions of the Parking lot
      //    Create the 2-D matrix for parking lot based upon the ROWS and COLS
      static int[][][] parkingLotArray = new int[dimensions[0]][dimensions[1]][2];
      public static void main(String args[]){
            Scanner scnSystemStartupParkingLotSize = new Scanner(System.in);
            System.out.println("Enter the parking lot size in aXb format where \n"
                        + "a is the number of rows and b is the number of columns: ");
            String parkingLotSize = scnSystemStartupParkingLotSize.next();
            
            //	The ADMIN who would be initializing the LIFT, should also be determining the LEVEL 
            //	which would be considered as the level at which all the users are going to come
            //	to receive the vehicles.
            System.out.println("Enter the level which is considered as USER LEVEL:");
            userLevel = scnSystemStartupParkingLotSize.nextInt();
            scnSystemStartupParkingLotSize.close();
            
            //    Delimiter which we are asking the user to enter
            char delimeter = 'X';																																																																																																																																																																																																																																																																																																																																																								
            String[] arr = parkingLotSize.split(Character.toString(delimeter));
            for(int i = 0; i < dimensions.length; i++){
                  dimensions[i] = Integer.parseInt(arr[i]);
            }
            
            System.out.println("No. of ROWS in Parking Lot: "+dimensions[0]);
            System.out.println("No. of COLS in Parking Lot: "+dimensions[1]);
            
            System.out.println("/n # INITIALIZING PARKING LOT #");
            
           
            
            //    Assuming that the first slot of the parking lot is going to be blank at the time of initializing
            //    For rest of the slots in parking lot, enter the slot ID and boolean cargo indicator
            int empty = 0;
            int non_empty = 1;
            int shelfSerialNo = 1;
            
            for(int i = 0; i < dimensions[0]; i++){
                  for(int j = 0; j< dimensions[1]; j++){
                        if(i == 0 && j ==0){
                              parkingLotArray[i][j][0] = shelfSerialNo;
                              parkingLotArray[i][j][1] = empty;
                        }else{
                              parkingLotArray[i][j][0] = shelfSerialNo;
                              parkingLotArray[i][j][1] = non_empty;
                        }
                        shelfSerialNo++;
                  }
            }
            
            //    Printing the 3D Array
            printParkingLotAtStart(parkingLotArray);
            
            //    The LIFT is INITIALIZED. Now we would create the mechanism to search for a ITEM in a particular SLOT and accordingly bring it to middle row
            
            Scanner scnUserInput = new Scanner(System.in);
            while(!(scnUserInput.next().equals("Exit"))){
	            System.out.println("Enter the SHELF which you want to bring to the middle");
	            
	            int desiredSlot = scnUserInput.nextInt();          
	            
	            //	Moving the NON-EMPTY slots towards EMPTY slot and bringing the desired slot to mid array
	            maneuverParkingLot(desiredSlot, parkingLotArray);
            }

            //    Closing the SCANNER object
            scnUserInput.close();
      }
      
      /*
       * While moving the slots, we need to do couple of things:
       * 1st: Figure out if the SLOT is already available at the USER LEVEL
       * 2nd: If not, then how far is the empty slot wrt the desired slot
       * 3rd: How can we capitalize on the empty slot to move the desired slot to nearest User Level
       */
      static void maneuverParkingLot(int slotToBringToMiddle, int[][][] arrayToManeuver){
    	  
      }
      
      /*
       * This is the method to print the PARKING LOT array
       * For each position in the PARKING LOT, we have two slots in the array
       * The first one is for the serial number of the array and the second one
       * is for tracking it availability.
       * 
       */
      static void printParkingLotAtStart(int[][][] parkingArray){
            
            for(int i=0; i<dimensions[0]; i++){
                  for(int j=0; j<dimensions[1]; j++){
                        System.out.print("SLOT NO:"+i+","+j+"->");
                        System.out.print("SHELF No:"+parkingArray[i][j][0]);
                        System.out.print("->");
                        
                        if(parkingArray[i][j][1] == 0){
                              System.out.print("EMPTY   ");
                        }else{
                              System.out.print("Not MPTY   ");
                        }
                  }
                  System.out.println();
            }
      }
}