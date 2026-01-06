package adventofcodeday05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String content = "";
        try {
            content = Files.readString(Paths.get("day05/adventofcodeday05/input_day05.txt"));
        } catch (IOException e) {
            throw new RuntimeException("Error in reading file" + e);
        }

        String[] blocks = content.split("\\R\\R"); // split on blank line
        String intervalsBlock = blocks[0];
        String idsBlock       = blocks[1];


        List<String> intervals = Arrays.asList(intervalsBlock.split("\\R"));
        String[] idLines = idsBlock.split("\\R");
        FreshProcessor freshProcessor = new FreshProcessor();
        int total = 0;
        for(int i = 0; i < idLines.length; i++) {
            total = total + freshProcessor.FreshProcess(intervals, Long.parseLong(idLines[i]));
        }

        System.out.println("Total : " + total);

    }
}
