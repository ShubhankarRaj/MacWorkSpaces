package companies.drishti;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VideoSearchInTimeRange {

    private static List<String> fileNames;
    private final File DIRECTORY = new File("C:\\Users\\mmt6540\\Desktop\\videoLibrary");

    public VideoSearchInTimeRange() {
        for(File videoFile : DIRECTORY.listFiles()){
            if(videoFile.isFile()){
             /*   String fileName = videoFile.getName().replaceFirst("[.][^.]+$","");
                String[] startAndEndTimeArr = fileName.split("_");
*/
                fileNames.add(videoFile.getName());
            }
        }
    }

    private static void addNewFileToList(String newFileName){
        fileNames.add(newFileName);
    }
    public static void notifyFileAddition(String videoFileName){
        addNewFileToList(videoFileName);
    }

    /*
    Accept String parameters in YYYYMMDDHHmmSS format
    Also the arraylist is sorted in Time, and so would be the names
     */
    public List<String> searchVideosInRange(String startTime, String endTime) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHmmSS");
        Date startDateAndTime = sdf.parse(startTime);
        Date endDateAndTime = sdf.parse(endTime);

        if(endDateAndTime.compareTo(startDateAndTime) <= 0) {
            System.out.println("Start Time is after End Time");
            return null;
        }

        int overLapStartIndex = fileNames.size()/2;

        int overLapEndIndex = fileNames.size()/2;

        //  Searching for index for Start range
        while(overLapStartIndex > 0 && overLapStartIndex < fileNames.size()){
            String fileToCheck = fileNames.get(overLapStartIndex);
            String absfileName = fileToCheck.replaceFirst("[.][^.]+$","");

            String[] startAndEndTimeArr = absfileName.split("_");

            if(startDateAndTime.compareTo(sdf.parse(startAndEndTimeArr[0])) < 0){
                if(endDateAndTime.compareTo(sdf.parse(startAndEndTimeArr[1])) > 0){
                    break;
                }
                overLapStartIndex = overLapStartIndex/2;
                continue;
            }else if(startDateAndTime.compareTo(sdf.parse(startAndEndTimeArr[0])) > 0){
                overLapStartIndex = overLapStartIndex + overLapStartIndex / 2;
                continue;
            }else{
                System.out.println("Start range's index found");
                break;
            }
        }

        //  Searching for index for End range
        while(overLapEndIndex > 0 && overLapEndIndex < fileNames.size()){
            String fileToCheck = fileNames.get(overLapEndIndex);
            String absfileName = fileToCheck.replaceFirst("[.][^.]+$","");

            String[] startAndEndTimeArr = absfileName.split("_");

            if(endDateAndTime.compareTo(sdf.parse(startAndEndTimeArr[1])) < 0){
                overLapEndIndex = overLapEndIndex / 2;
                continue;
            } else if(endDateAndTime.compareTo(sdf.parse(startAndEndTimeArr[1])) > 0){
                if(startDateAndTime.compareTo(sdf.parse(startAndEndTimeArr[0]))< 0){
                    break;
                }
                overLapEndIndex = overLapEndIndex + overLapEndIndex/2;
                continue;
            } else{
                System.out.println("End range's index found");
                break;
            }
        }

        List<String> result = new ArrayList<>();
        //  Adding all the files in the range to the list for output
        for(int i = overLapStartIndex; i < overLapEndIndex; i++){
            result.add(fileNames.get(i));
        }

        return result;
    }


    public static void main(String[] args) {
        VideoSearchInTimeRange newSearch = new VideoSearchInTimeRange();

        //  Adding dummy files in the list
        VideoSearchInTimeRange.notifyFileAddition("20191015185101_20191015185201.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015185501_20191015185601.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015185801_20191015185901.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015190101_20191015190201.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015190401_20191015190501.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015190601_20191015190701.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015190723_20191015190823.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015190901_20191015191001.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015191101_20191015191201.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015191401_20191015191501.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015191601_20191015191701.mp4");
        VideoSearchInTimeRange.notifyFileAddition("20191015191801_20191015191901.mp4");

        System.out.println("Files Added");
    }
}
