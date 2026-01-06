package adventofcodeday05;

import java.util.List;

public class FreshProcessor {


    public int FreshProcess(List<String> freshIntervals, long id) {

        for(String interval : freshIntervals){
            String [] intervalArr = interval.split("-");
            long lbound = Long.parseLong(intervalArr[0]);
            long hbound = Long.parseLong(intervalArr[1]);
            if(intervalCheck(id, lbound, hbound) == 1){
                //fresh = true;
                return 1;
            }
        }
        return 0;

    }


    public int intervalCheck(long id, long lbound, long hbound){
        if(id < lbound || id > hbound)   return 0;
        else return 1;
    }
}
