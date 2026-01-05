package adventofcodeday02;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public List<String> parseRanges(String filename) throws Exception {
        List<String> ranges = new ArrayList<>();
        String content = Files.readString(Paths.get(filename));
        String[] pairs = content.split(",");
        for (String pair : pairs) {
            pair = pair.trim();  // Remove any whitespace
            if (!pair.isEmpty()) {
                ranges.add(pair);
            }
        }
        return ranges;
    }
}
