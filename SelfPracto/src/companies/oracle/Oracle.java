package companies.oracle;

public class Oracle {


    public int reverseInt(int input){

        boolean numIsNeg = false;
        if(input < 0)
        {

        }
        int size = Integer.toString(input).length();

        int multiplicationFactor = 1;
        for(int i= 1; i < size; i++){
            multiplicationFactor *= 10;
        }
        int output = 0;

        for(int i = 1; i <= size; i++){
            int rem = input%10;
            input /= 10;

            output = output + rem * multiplicationFactor;
            multiplicationFactor /= 10;
        }

        return output;
    }

    int[] rotateArr(int[] arr, int rotationCount){
        int actualRotCount = rotationCount % arr.length;

        int maxElem = arr.length;


        int counter = 1;
        for(int i = 0; i < arr.length; i++){
            if(actualRotCount > 0){
                arr[i] = maxElem - (actualRotCount - 1);
            }else{
                arr[i] = counter;
                counter ++;
            }
            actualRotCount --;

        }
        return arr;
    }

    public static void main(String[] args) {
        Oracle sol = new Oracle();
        //System.out.println(sol.reverseInt(0));

        int[] arr = {1,2, 3, 4, 5, 6, 7, 8, 9};

        int[] retArr = sol.rotateArr(arr, 30);
        for(int i : retArr)
            System.out.println(i);

        //  First rotated array is : 9,1,2,3,4,5,6,7,8
        //  Second rotation is : 8,9,1,2,3,4,5,6,7

        //  int[] rotateArr(int[] arr, int rotationCount)

    }

}
