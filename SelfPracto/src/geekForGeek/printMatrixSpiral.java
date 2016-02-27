package geekForGeek;

import java.util.ArrayList;
import java.util.Scanner;

public class printMatrixSpiral {
	public static void main(String args[]){
		System.out.println("Enter the number of Rows and Columns of the 2D matrix");
		Scanner scn = new Scanner(System.in);
		
		//	Getting the dimensions of the 2D Matrix
		System.out.print("Enter the Row No: ");
		int rows = scn.nextInt();
		System.out.println();
		System.out.print("Enter the Col No: ");
		int cols = scn.nextInt();
		
		//	Creating the 2D Matrix
		twoDMatrix matrix = new twoDMatrix(rows, cols);
		
		//	Printing the original Matrix
		
	}
}
class twoDMatrix{
	
	public twoDMatrix(int row, int col){
		int[][] matrixArray = new int[row][col];
				
		//	Inserting the values into the MATRIX
		Scanner matrixScanner = new Scanner(System.in);
		System.out.println("Kindly enter the values in the matrix");
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.println("Enter the value for 2DMatrix["+i+"]["+j+"]");
				matrixArray[i][j] = matrixScanner.nextInt();
			}
		}
		
		//	Printing the Array in Original Form
		printOriginalMatrix(matrixArray);
		
		//	Printing the Array in the Matrix form
		printSpiralMatrix_MyApproach(matrixArray);
		
		//	Printing the Array in guided approach
		printSpiralMatrix(matrixArray);
	}
	
	private void printOriginalMatrix(int[][] printArray){
		System.out.println("Printing the MATRIX array: ");
		for(int i=0; i<printArray.length; i++){
			System.out.print("[");
			for(int j=0; j<printArray[i].length; j++){
				System.out.print(printArray[i][j]+", ");
			}
			System.out.println("]");
		}
	}
	
	private void printSpiralMatrix_MyApproach(int[][] printArray){
		System.out.println("Printing the Array in Spiral:");
		int numberOfRows = printArray.length;
		int numberOfCols = printArray[0].length;
		int maxRows = numberOfRows, maxCols = numberOfCols;
		int numOfIterations=0;
		while(numberOfRows > 0 && numberOfCols >0){
			//	Printing the top Edge of the Matrix
			for(int i=numOfIterations; i<numberOfCols+numOfIterations; i++){
				System.out.print(printArray[numOfIterations][i]+", ");
			}
			
			//	Printing the RIGHT edge of the Matrix
			for(int j=numOfIterations+1; j<numberOfRows+numOfIterations; j++){
				System.out.print(printArray[j][numberOfCols-1+numOfIterations]+", ");
			}
			
			
			//	Printing the BOTTOM edge of the Matrix
			for(int k=numberOfCols-1-1+numOfIterations; k>=numOfIterations; k--){
				System.out.print(printArray[numberOfRows-1+numOfIterations][k]+", ");
			}
			
			//	Printing the LEFT edge of the Matrix
			for(int l= numberOfRows-1-1; l>=1; l--){
				System.out.print(printArray[l][maxCols-numberOfCols]+", ");
			}
			numOfIterations += 1;
			numberOfRows = numberOfRows-2;
			numberOfCols = numberOfCols-2;
			
		}
	}
	
	public void printSpiralMatrix(int[][] printArray){
		int rowStartIndex = 0, colStartIndex = 0, i;
		int rowEndIndex = printArray.length - 1;
		int colEndIndex = printArray[0].length - 1;
		System.out.println();
		while(rowStartIndex <= rowEndIndex && colStartIndex <= colEndIndex){
			
			//	Printing the first row
			for(i = colStartIndex; i <= colEndIndex; i++){
				System.out.print(printArray[rowStartIndex][i]+", ");
			}
			rowStartIndex++;
			
			//	Printing the last column
			for(i = rowStartIndex; i <= rowEndIndex; i++){
				System.out.print(printArray[i][colEndIndex]+", ");
			}
			colEndIndex--;
			
			//	Printing the last row
			if(rowStartIndex <= rowEndIndex){
				for(i = colEndIndex; i >= colStartIndex; i--){
					System.out.print(printArray[rowEndIndex][i]+", ");
				}
				rowEndIndex--;
			}
			
			//	Printing the first column of the remaining columns
			if(colStartIndex <= colEndIndex){
				for(i = rowEndIndex; i >= rowStartIndex; --i){
					System.out.print(printArray[i][colStartIndex]+", ");
				}
				colStartIndex++;
			}
			
		}
	}
	
}
