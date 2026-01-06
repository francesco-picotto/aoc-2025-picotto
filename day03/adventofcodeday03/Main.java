package adventofcodeday03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //List<String> banks = List.of("987654321111111", "811111111111119", "234234234234278", "818181911112111");
        List<String> banks = null;

        try {
            banks = Files.readAllLines(Paths.get("day03/adventofcodeday03/input_day03.txt"));
        } catch (IOException e) {
            System.err.println("Failed to read input" + e.getMessage());
            System.exit(1);
        }

        long total = 0;
        /*Search search1 = new Search();
        for(String bank : banks){
            //System.out.println("current total: " + search.MaxJoltageSearch(bank));
            total = total + search1.MaxJoltageSearch(bank, false);
        }

        System.out.println("Total part one: " + total);*/


        total = 0;
        Search search2 = new Search();
        for(String bank : banks){
            //System.out.println("current total: " + search.MaxJoltageSearch(bank));
            total = total + search2.MaxJoltageSearch(bank, true);
        }

        System.out.println("Total part one: " + total);
    }
}
