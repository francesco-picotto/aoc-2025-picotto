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
            zeros = (int) floor((double) steps / 100); //how many times it hits zero
            int remainder = steps % 100;
            if(dir == 'R' && remainder >= (100-position)) zeros++;
            else if(dir == 'L' && position != 0 && remainder >= position) zeros++;
        }
        else {
            zeros = isOnZero()? 1:0;
        }
        position = (position + 100 + delta) % 100;
        return zeros;
    }

    public boolean isOnZero() {
        return position == 0;
    }
}