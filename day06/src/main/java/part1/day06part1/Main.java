package day06part1;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {


        List<String> lines;
        try{
            lines = Files.readAllLines(Path.of("day06/input_day06.txt"));
        }catch (Exception e){
            throw new RuntimeException("Error parsing day06/input_day06.txt" + e);
        }

        int rows = lines.size();

        String[][] grid = new String[rows][];
        for (int r = 0; r < rows; r++) {
            grid[r] = lines.get(r).trim().split("\\s+");
        }

        int cols = grid[0].length;
        long[] total = new long[cols];

        for(int c = 0; c < cols; c++){

            if(grid[rows-1][c].charAt(0) == '+'){
                total[c] = 0;
                for(int r = 0; r < rows-1; r++){
                    total[c] = total[c] + Long.parseLong(grid[r][c]);
                }
            }else{
                total[c] = 1;
                for(int r = 0; r < rows-1; r++){
                    total[c] = total[c] * Long.parseLong(grid[r][c]);
                }
            }

        }
        long tot = 0;
        for(int c = 0; c < cols; c++){
            tot += total[c];
        }

        System.out.println("Total : " + tot);
    }
}
