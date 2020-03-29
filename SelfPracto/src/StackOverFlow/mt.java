package StackOverFlow;

import java.util.*;
class mt {
    int i,M=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of array");
        int sizeOfArray=sc.nextInt();
        int sizeArr = sizeOfArray;
        int arr[]= new int [sizeOfArray];
        int temp;
        System.out.println("enter the numbers");
        for (int i=0; i<sizeOfArray; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println("the sorted array is below :");
        
        for (int i=0; i<=sizeArr; i++){
            for (int j=0; j<sizeArr-1; j++) {
                if (arr[j]>arr[j+1]) {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int i=0; i<sizeOfArray; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("enter number to search");
        int srch=sc.nextInt();
        for (int i=0; i<sizeOfArray; i++) {
        	int M=0;
            if (arr[i]==srch)
            {
                System.out.println("found at "+i);
                M++;
                break;
            }
            else if (M==0&&i==sizeOfArray-1)
            {
                System.out.println("number not found");
            }
        }
    }
}
