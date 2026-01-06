package adventofcodeday01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> instructions;
        try ( Stream<String> lines = Files.lines(Paths.get("day01/adventofcodeday01/input.txt")) ) {
            instructions = lines
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input_day01.txt", e);
        }

        //List<String> instructions = List.of("L68", "L30", "R48", "L5", "R60", "L55", "L1", "L99", "R14", "L82");

        Dial dialA = new Dial();
        int pw = 0;
        for (String seqstr: instructions){
            pw += dialA.rotate(seqstr, false);
        }
        System.out.println("pw = " + pw);



        // PART B: setting the advanceMethod to true
        Dial dialB = new Dial();
        pw = 0;
        for (String seqstr: instructions){
            pw += dialB.rotate(seqstr, true);
        }
        System.out.println("pw with Advanced method = " + pw);
    }
}
