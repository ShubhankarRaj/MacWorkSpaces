package gcj.timetable;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static int clockToMinutes(String s) {
        int t = 0;
        t += 60 * Integer.parseInt(s.substring(0, 2));


        t += Integer.parseInt(s.substring(3, 5));
        return t;
    }

    public static void setEvent(int eventType, int eventTime,
                                ArrayList<Integer> events, ArrayList<Integer> eventTimes) {
        if (eventTime >= 1440)
            return;
        int index = 0;
        if (eventTimes.size() != 0)
            while (eventTimes.size() > index
                    && eventTimes.get(index) <= eventTime)
                if (eventTimes.get(index) == eventTime) {
                    if ((eventType != 4 && eventType != 8)
                            || (events.get(index) != 1 && events.get(index) != 2))
                        index++;
                    else
                        break;
                } else
                    index++;
        eventTimes.add(index, eventTime);
        events.add(index, eventType);
    }

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(new File("/Volumes/HDD/MyData/WorkSpaces/Java/DynamicProgg/SelfPracto/src/gcj/timetable/B-small-practice.in"));
        PrintWriter out = new PrintWriter(new File("/Volumes/HDD/MyData/WorkSpaces/Java/DynamicProgg/SelfPracto/src/gcj/timetable/output.out"));

        int T = scan.nextInt();
        int turnAroundTime, na, nb;
        ArrayList<Integer> events = new ArrayList<Integer>();
        ArrayList<Integer> eventTimes = new ArrayList<Integer>();

        for (int cT = 1; cT <= T; cT++) {

            events.clear();
            eventTimes.clear();

            turnAroundTime = scan.nextInt();
            na = scan.nextInt();
            nb = scan.nextInt();

            for (int i = 0; i < na; i++) {
                setEvent(2, clockToMinutes(scan.next()), events, eventTimes);
                setEvent(4, turnAroundTime + clockToMinutes(scan.next()),
                        events, eventTimes);
            }
            for (int i = 0; i < nb; i++) {
                setEvent(1, clockToMinutes(scan.next()), events, eventTimes);
                setEvent(8, turnAroundTime + clockToMinutes(scan.next()),
                        events, eventTimes);
            }
            na = 0;
            nb = 0;
            int rna = 0;
            int rnb = 0;
            for (int i = 0; i < events.size(); i++) {
                if ((events.get(i) & 8) > 0)
                    na++;
                if ((events.get(i) & 4) > 0)
                    nb++;
                if ((events.get(i) & 2) > 0)
                    na--;
                if ((events.get(i) & 1) > 0)
                    nb--;
                if (na == -1) {
                    na++;
                    rna++;
                }
                if (nb == -1) {
                    nb++;
                    rnb++;
                }
            }

            out.println("Case #" + cT + ": " + rna + " " + rnb);
        }

        scan.close();
        out.close();

    }
}
