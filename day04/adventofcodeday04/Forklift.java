package adventofcodeday04;

public class Forklift {

    public int getNeighbours(char[][] grid, int row, int col) {
        int count = 0; //so that the @ of the current roll isn't counted
        //System.out.println("Now checking for roll at position: (" + row + ", " + col + ")");
        for (int i = row-1; i <= row+1; i++) {
            //System.out.println("Now trying with row: " + i);
            if(i>= 0 && i<grid.length) {
                for (int j = col-1; j <= col+1; j++) {
                    //System.out.println("Now trying with col: " + j);
                    //System.out.println("we are at posistion (" + i + ", " + j + ")");
                    if(j>=0 && j<grid[i].length) {
                        //System.out.println("Good position at (" + i + "," + j + ")");

                        if (grid[i][j] == '@' && (i != row || j != col)) {
                            //System.out.println("counting this[" + i +"," + j +"]");
                            count++;
                        }
                        else if(i == row && j == col) {
                            //System.out.println("we are at the start, so doesn't count");
                        }
                        else{
                            //System.out.println("in position (" + i + "," + j + ") there's : " + grid[i][j]);
                        }
                    }
                    else{
                        //System.out.println("Invalid column: " + j);
                    }
                }
            }
            else {
                //System.out.println("Invalid row: " + i);
            }
        }

        return count;
    }
}
