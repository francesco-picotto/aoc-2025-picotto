package adventofcodeday02;

import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        InputParser parser = new InputParser();
        List<String> ranges = parser.parseRanges("day02/adventofcodeday02/input_day02.txt");
        long total1 = 0;
        long total2 = 0;
        for (String range : ranges) {
            String[] rangeArray = range.split("-");
            long start = Long.parseLong(rangeArray[0]);
            long end = Long.parseLong(rangeArray[1]);

            IdChecker idChecker = new IdChecker();
            for(long id1 = start; id1 <= end; id1++) {
                total1 = total1 + idChecker.IdValidation(id1, false);
            }




            for(long id2 = start; id2 <= end; id2++) {
                total2 = total2 + idChecker.IdValidation(id2, true);
            }

        }
        System.out.println("Total part one: " + total1);
        System.out.println("Total part two: " + total2);
    }
}
