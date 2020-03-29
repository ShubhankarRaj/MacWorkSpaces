package algo.abdulbari;

import java.util.Scanner;

public class MultiStageGraphTraversal {
    public static void main(String[] args) {
        //  Scanner object for reading input from commnad line
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the dimensions of the Graph: ");
        System.out.print("ROWS and COLS: ");
        int rows = scn.nextInt();
        int cols = rows;

        int costArr[][] = new int[rows][cols];

        System.out.println("Enter stages of the Graph");
        int stages = scn.nextInt();
        String nodesInEachStage[] = new String[stages];
        for(int i = 1; i <= stages; i++){
            System.out.println("Enter nodes in stage "+i+" separated by space");
            nodesInEachStage[i-1] = scn.next();
        }


        System.out.println("For each node in the graph, which is connected to another, enter the weight of the path");
        System.out.println("Each row is dedicated for one node only. If node 2 is connected to node 3,5 and 7 in 7X7 matrix,");
        System.out.println("then, this should be the input: 0 0 4 0 2 0 9 , where 4,2 and 9 are the weights of the paths");

        for(int i = 0; i <= rows; i++){
            String costToEachNode = scn.next();
            String[] costArrEachRow = costToEachNode.split(" ");
            if(costArrEachRow.length != rows - 1){
                System.out.println("Values entered are not of the same size as cost array row");
                System.exit(0);
            }else{
                for(int j = 0; j <= cols; j++){
                    if(i == 0){
                        costArr[i][j] = 0;
                    }else if(j == 0){
                        costArr[i][j] = 0;
                    }else{
                        costArr[i][j] = Integer.parseInt(costArrEachRow[j -1]);
                    }
                }
            }

        }

        //  Creating the cost array which contains the cost of reaching the destination from each array
        int costEachNode[] = new int[rows];
        //  Since the cost of reaching the destination from destination will be zero only
        costEachNode[rows] = 0;

        //  Creating the array which will store the next node from each node towards destination
        int direction[] = new int[rows];

        //  Traversing the graph from end to start
        for(int i = (rows-1); i >= 1; i--){
            int min = Integer.MAX_VALUE;
            int stageOfNode = getStage(i, nodesInEachStage);
            if(stageOfNode == (stages - 1)){
                costEachNode[i] = costArr[i][cols];
            }else{
                for(int k = i+1; k <= cols; k++){
                    if(costArr[i][k] != 0 && (costArr[i][k] + costEachNode[k]) < min){
                        min = (costArr[i][k] + costEachNode[k]);
                        direction[i] = k;
                    }
                }
                costEachNode[i] = min;
            }

        }

        //  Finally finding the path in the GRAPH
        int path[] = new int[stages];
        path[1] = 1; path[stages] = rows;
        for(int i = 2; i < stages; i++){
            path[i] = direction[path[i - 1]];
        }

        for(int p : path){
            System.out.print(p+" -> ");
        }
    }

    private static int getStage(int i, String[] nodesInEachStage) {
        for(int j = 0; i < nodesInEachStage.length; j++){
            String arr[] = nodesInEachStage[j].split(" ");
            for(String str : arr){
                if(i == Integer.parseInt(str))
                    return j+1;
            }
        }

        return 0;
    }
}
