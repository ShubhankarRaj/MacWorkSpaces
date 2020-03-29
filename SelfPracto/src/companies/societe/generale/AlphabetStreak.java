package companies.societe.generale;



import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;

public class AlphabetStreak {

    private static class Test implements Callable<String>{

        private final int stringLen;
        private final String inputStr;
        TreeMap<Character, Integer> mapOfChars = new TreeMap<>();

        public Test(int stringLen, String inputStr) {
            this.stringLen = stringLen;
            this.inputStr = inputStr;
        }

        @Override
        public String call() throws Exception {
            char[] charArr = inputStr.toCharArray();
            Integer maxVal = Integer.MIN_VALUE;
            char previousCh = '\0';
            int previousCharCount = 0;
            for(char ch : charArr){
                if(previousCh != ch) {
                    previousCharCount = 1;
                    Object val = mapOfChars.get(ch);
                    if (val != null && mapOfChars.get(ch) > previousCharCount) {
                    } else {
                        mapOfChars.put(ch, 1);

                    }
                }
                else {
                    if(mapOfChars.get(ch) > previousCharCount){}
                    else
                        mapOfChars.put(ch, mapOfChars.get(ch) + 1);
                    previousCharCount++;
                }
                maxVal = mapOfChars.get(ch) > maxVal ? mapOfChars.get(ch) : maxVal;
                previousCh = ch;

            }

            String returnString = new String();
            for(Map.Entry<Character, Integer> entry: mapOfChars.entrySet()){
                if(entry.getValue() == maxVal)
                    returnString += entry.getKey();
            }

            return maxVal + " " + returnString;
        }
    }

    private static final boolean DEBUG = false;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Test> tests = new ArrayList<>();
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(is)) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int len = scanner.nextInt();
                String input = scanner.next();
                tests.add(new Test(len, input));
            }
        }

        List<Future<String>> results = threadPool.invokeAll(tests);
        for (Future<String> f : results) {
            System.out.println(f.get());
        }
        threadPool.shutdown();
    }

}
