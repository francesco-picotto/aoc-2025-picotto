package adventofcodeday04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static char[][] grid;

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("day04/adventofcodeday04/input_day04.txt"));
            grid = new char[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                grid[i] = new char[line.length()];
                for (int j = 0; j < line.length(); j++) {
                    grid[i][j] = line.charAt(j);
                }
            }
            System.out.println("Grid loaded: " + grid.length + " rows and " + grid[0].length + " columns");
        } catch (IOException e) {
            System.err.println("Error reading input_day03ì4.txt: " + e.getMessage());
        }
        int total = 0;
        Forklift forklift = new Forklift();
        boolean removed;
        do{
            removed = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if(grid[i][j] == '@' && forklift.getNeighbours(grid, i, j) < 4){
                       grid[i][j] = 'x';
                       total++;
                       removed = true;
                    }
                }
            }
        }while(removed);





        System.out.println("Total : " + total);

    }
}
