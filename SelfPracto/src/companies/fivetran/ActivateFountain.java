/*
package companies.fivetran;

import java.util.*;

public class ActivateFountain {

    public static int fountainActivation(List<Integer> locations){
        int currStart = 0;
        int currEnd = 0;
        int maxFountainCount = 0;

        ArrayList<ArrayList<Integer>> rangeMatrix = new ArrayList<>();

        LinkedHashMap<Integer, Fountain> map = new LinkedHashMap<>();


        for(int i = 1; i <= locations.size(); i++){
            Fountain fount = new Fountain();

            int tempStartRange = getRange(i, locations.get(i -1), locations.size()).get(0);
            fount.setStartRange(tempStartRange);
            int tempEndRange = getRange(i, locations.get(i -1), locations.size()).get(0);
            fount.setEndRange(tempEndRange);
            fount.setRunning(true);

            map.put(i, fount);
        }

        maxFountainCount = map.entrySet().size();
        List<Fountain> previousRunningFountains = new ArrayList<Fountain>();
        //Integer previousMapKey, currentMapKey;
        Fountain curentMapEntry;

        for(int i = 1; i < map.entrySet().size(); ){

            Fountain currFountain = map.get(i);
            Integer counter = i;
            while(counter >= 1){
                if(currFountain.getStartRange() > map.get(i - 1).getEndRange()){

                }
            }

            */
/*if(!keepThePreviousFountain) {
                previousRunningFountains = map.get(i-1);

            }

            curentMapEntry = map.get(i);

            //  Checking for end range of Previous Entry first if it overlaps the Current entry
            if(previousRunningFountains.get(1) > curentMapEntry.get(0)) {
                maxFountainCount--;
                //  We need NOT to remove the Entry from the MAP

                keepThePreviousFountain = true;
                i++;
            }else if(previousRunningFountains.get(1) == curentMapEntry.get(0)){
                keepThePreviousFountain = false;
                i++;
            }else{
                maxFountainCount--;
                int
                while()
            }*//*

        }
    */
/**//*
}

    private static List<Integer> getRange(int count, int arrayValInLocationArr, int sizeOfArr){
        Integer startRange = Math.max(count - arrayValInLocationArr, arrayValInLocationArr);
        Integer endRange = Math.min(count + arrayValInLocationArr, sizeOfArr);
        return new ArrayList<>(Arrays.asList(startRange, endRange));
    }


    static class Fountain{
        Integer startRange, endRange;
        Boolean isRunning;

        public Integer getStartRange() {
            return startRange;
        }

        public void setStartRange(Integer startRange) {
            this.startRange = startRange;
        }

        public Integer getEndRange() {
            return endRange;
        }

        public void setEndRange(Integer endRange) {
            this.endRange = endRange;
        }

        public Boolean getRunning() {
            return isRunning;
        }

        public void setRunning(Boolean running) {
            isRunning = running;
        }
    }
}
*/
