package day06part2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> lines;
        try{
            lines = Files.readAllLines(Path.of("day06/input_day06.txt"));
        }catch (Exception e){
            throw new RuntimeException("Error parsing day06/input_day06.txt" + e);
        }

        int rows = lines.size();

        List<String> numberLines = lines.subList(0, rows-1);
        String operatorLine = lines.get(rows-1); //here i store all the operators

        int cols = numberLines.get(0).length();


        //don't understand this part
        String opsLine = operatorLine.replace(" ", ""); // e.g. "+*+"
        Deque<Character> ops = new ArrayDeque<>();
        for (char ch : opsLine.toCharArray()) {
            ops.push(ch);   // so rightmost operator comes out first
        }


        List<Long> current = new ArrayList<>();
        long total = 0L;
        for(int c = cols-1; c >= -1; c--){
            boolean separator = (c == -1);

            StringBuilder col =  new StringBuilder();
            boolean allSpaces = true;

            if(!separator){
                for(String line : numberLines){
                    char ch = (c < line.length() ? line.charAt(c) : ' ');
                    col.append(ch);
                    if (ch != ' ') allSpaces = false;
                }
                separator = allSpaces;
            }

            if(!separator){
                String digits = col.toString().replace(" ", "");
                long v = Long.parseLong(digits);
                current.add(v);
                continue;
            }

            if(!current.isEmpty()){
                char op = ops.pop();
                long acc = (op == '+') ? 0L : 1L;
                for (long v : current) {
                    acc = (op == '+') ? acc + v : acc * v;
                }
                total = total + acc;
                current.clear();

            }

        }


        System.out.println("Total : " + total);
    }
}
