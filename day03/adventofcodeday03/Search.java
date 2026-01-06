package adventofcodeday03;

import java.util.ArrayList;

public class Search {
    private static int i = 0;
    private static int jlength = 12;

    public long MaxJoltageSearch(String bank, boolean advanceMethod){
        int len = bank.length();


        if(!advanceMethod){
            char dec = MaxSearch(bank, 0, len-2);
            char unit = MaxSearch(bank, i+1, len-1);
            //System.out.println("dec and unit = " + dec + unit);

            // return Long.parseLong(dec - '0') * 10 + (unit - '0'));
        }

        StringBuilder joltagestr = new StringBuilder();
        joltagestr.append(MaxSearch(bank, 0, len-jlength));
        for(int k=1;k<jlength;k++){
            joltagestr.append(MaxSearch(bank, i+1, len - jlength + k));
        }
        return Long.parseLong(joltagestr.toString());

    }

    private char MaxSearch(String s, int start, int end) {
        char max = '0';
        for (int j = start; j <= end; j++) {
            if(s.charAt(j) > max) {
                max = s.charAt(j);
                i = j;
            }
        }
        return max;
    }
}
