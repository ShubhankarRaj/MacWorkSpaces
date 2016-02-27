import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
//rename class to Main to submit on codechef

public class ChefAndWay {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int ans;
        if (N <= 5) {
            ans = subtask1(A, N, K);
        } else {
            ans = subtask2(A, N, K);
        }

        System.out.println(ans);
    }

    private static int subtask1(int[] a, int n, int k) {
        List<BigInteger> list = new ArrayList<BigInteger>();
        list.add(BigInteger.valueOf(a[0]));
        for (int i = 1; i < n; i++) {
            BigInteger min = list.get(i - 1);
            for (int j = 2; j <= k; j++) {
                if (i - j >= 0 && list.get(i - j).compareTo(min) < 0) min = list.get(i - j);
            }
            System.out.println(list.toString()+" and min: "+min);
            list.add(min.multiply(BigInteger.valueOf(a[i])));
        }

        return list.get(n - 1).mod(BigInteger.valueOf(1000000007)).intValue();
    }

    private static int subtask2(int[] a, int n, int k) {
        long[] min = new long[n];


        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

        pq.offer(new Pair(Math.log(a[0]), 0));
        min[0] = a[0] % 1000000007;

        for (int i = 1; i < n; i++) {
            while (i - pq.peek().index > k) pq.poll();
            int j = pq.peek().index;
            min[i] = (min[j] * a[i]) % 1000000007;
            pq.offer(new Pair(pq.peek().logValue + Math.log(a[i]), i));
        }

        return (int) min[n - 1];
    }
}


class Pair implements Comparable<Pair> {
    double logValue;
    int index;

    Pair(double logValue, int index) {
        this.logValue = logValue;
        this.index = index;
    }

    @Override
    public int compareTo(Pair that) {
        return Double.compare(this.logValue, that.logValue);
    }
}
