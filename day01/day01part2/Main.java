package day01part2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> instructions;
        try ( Stream<String> lines = Files.lines(Paths.get("day01/input_day01.txt")) ) {
            instructions = lines
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input_day01.txt", e);
        }

        int position = 50;
        int zeros = 0;

        for(String instruction : instructions){
            char dir = instruction.charAt(0);
            int steps = Integer.parseInt(instruction.substring(1));

            for(int i = 0; i < steps; i++){
                if(dir == 'R'){
                    position = (position + 1) % 100;
                }else{
                    position = (position - 1 + 100) % 100;
                }

                if(position == 0) zeros++;
            }
        }

        System.out.println("zeros = " + zeros);
    }
}
