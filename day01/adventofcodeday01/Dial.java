package adventofcodeday01;

import static java.lang.Math.floor;

public class Dial {
    private int position = 50; //starting position of the dial

    public Dial() {
    }

    public int rotate(String seqstr, boolean advanceMethod) {
        //here the sequence of steps are parsed
        char dir = seqstr.charAt(0);
        int delta = 0;
        int zeros = 0;
        int steps = Integer.parseInt(seqstr.substring(1)); //extrapolate the string starting from 1
        if (dir == 'L') delta = -steps; //just to simplify steps
        else if (dir == 'R') delta = steps;


        if(advanceMethod)
        {
            // PART B
            zeros = steps / 100; //how many times it hits zero
            int remainder = steps % 100;


            if(remainder > 0){
                if(dir == 'R'){
                    if(position == 0 || position + remainder >= 100) zeros++;
                }
                else{
                    if(position - remainder <= 0) zeros++;
                }
            }
            position = ((position + delta) % 100 + 100) % 100;
        }
        else {
            position = ((position + delta) % 100 + 100) % 100;
            zeros = isOnZero()? 1:0;
        }

        return zeros;
    }

    public boolean isOnZero() {
        return position == 0;
    }
}