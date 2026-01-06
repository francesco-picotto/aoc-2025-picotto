package src.main.java.Picotto.part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("day05/src/main/java/Picotto/part2/input_day05.txt"));
        } catch (IOException e) {
            throw new RuntimeException("Problem reading the input file" + e);
        }

        List<long[]> intervals = new ArrayList<>();

        for(String line : lines){
            line = line.trim();
            if(line.isEmpty()) break;

            String[] parts = line.split("-");
            long lbound = Long.parseLong(parts[0]);
            long ubound = Long.parseLong(parts[1]);

            intervals.add(new long[]{lbound, ubound});
        }
        intervals.sort(Comparator.comparingLong(r -> r[0])); //understand this well

        List<long[]> mergedIntervals = new ArrayList<>();

        long[] current =  intervals.get(0);

        for(int i = 1; i < intervals.size(); i++){
            long[] next =  intervals.get(i);

            if(next[0] <= current[1] + 1){
                current[1] = Math.max(current[1], next[1]);
            }
            else{
                mergedIntervals.add(current);
                current = next; //goes to next
            }
        }

        mergedIntervals.add(current); //add the last one

        long total = 0;
        for(long[] interval : mergedIntervals){
            total += (interval[1] - interval[0] + 1);
        }

        System.out.println("Total : " + total);
    }
}
