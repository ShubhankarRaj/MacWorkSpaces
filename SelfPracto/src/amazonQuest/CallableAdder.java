package amazonQuest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class CallableAdder implements Callable<Integer> {

    Integer operand1;
    Integer operand2;

    CallableAdder(Integer operand1, Integer operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Integer call() throws Exception{
        System.out.println(Thread.currentThread().getName() + " is doing the partial sum of " + operand1 + " + " + operand2 + " = "+(operand1 + operand2));
        return operand1 + operand2;
    }
}

class ParallelAdder {
    public Integer parallelSum() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futuresList = new ArrayList<Future<Integer>>();
        int count = 1;
        int prev = 0;

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            if (count % 2 == 0) {
                //System.out.println("Prev: " + prev + " Current: " + i);
                Future<Integer> future = executorService.submit(new CallableAdder(prev, i));
                futuresList.add(future);
                count = 1;
                continue;
            }
            prev = i;
            count++;
        }
        int totSum = 0;
        for (Future<Integer> fut : futuresList) {
            try {
                totSum = totSum + fut.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        long t2 = System.currentTimeMillis();

        System.out.println("Total SUM by parallel addition is " + totSum);
        System.out.println("Time taken by parallel Sum " + (t2-t1));

        return totSum;
    }

    public int sequentialSum()
    {

        long t1 = System.currentTimeMillis();
        Integer totsum=0;
        for(int i = 0;i < 100;i++)
        {
            totsum=totsum+i;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("sequentialSum Total Sum is " + totsum);
        System.out.println("Time taken by sequentialSum " + (t2-t1));
        return totsum;

    }

    public static void main(String[] args) {

        ParallelAdder adder = new ParallelAdder();

        int pSum= adder.parallelSum();

        int sSum= adder.sequentialSum();

        System.out.println("parallel Sum equals to Sequential Sum ? " );

        System.out.println("Answer is :: " + (pSum==sSum));

    }
}
