//Name:         Sonia Liu
//Class:        1620-301
//Program#:     3
//Due Date:     July 26
//
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha,
//              I have neither given nor received unauthorized help on this 
//              homework assignment
//
//Name:         Sonia Liu
//NUID:         748
//Email:        sonialiu@unomaha.edu
//
//Partners:     Marcus Mallum, mmmallum@unomaha.edu 
//
//Description:	creates a Maze, either randomly or with input
//
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
public class Maze
{
    private char map[][];
    private int entranceRow;
    private int exitRow;

    //Method Name:      Maze
    //Parameters:       a 2D char array, and the rows for the entrance and exit (ints)
    //Return value(s):  none
    //Partners:		none
    //Description:      Accepts a 2D char array and values for the entrance and exit
    public Maze (char [][]m, int ent, int ex)
    {
        map = m;
        entranceRow = ent;
        exitRow = ex;
    }
    //Method Name:      Maze 
    //Parameters:       none
    //Return value(s):  none
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //Description:      Generates a random maze with dimensions between 6-12, with a random start point, a random end point, and each space inside with a 1/3 chance of being a wall and a 2/3 chance of being open
    //                  stackoverflow.com
    public Maze()
    {
        System.out.println("Generating Random Maze");
        Random num = new Random();
        int r = num.nextInt(7) + 6;
        int c = num.nextInt(7) + 6;
        entranceRow = num.nextInt(r - 2) + 1;
        exitRow = num.nextInt(r - 2) + 1;

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j ++)
            {
                if (i == 0 || i == r)
                {
                    System.out.print("#");
                }
                if (j == 0 || j == c)
                {
                    if (j == 0 && i == entranceRow)
                    {
                        System.out.print(".");
                    }
                    if (j == 0 && i != entranceRow)
                    {
                        System.out.print("#");
                    }
                    if (j == c && i == exitRow)
                    {
                        System.out.print(".");
                    }
                    if (j == c && i != exitRow)
                    {
                        System.out.print("#");
                    }
                }
                else 
                {
                    int rdm = num.nextInt(3);
                    if (rdm == 0)
                    {
                        System.out.print("#");
                    }
                    else
                    {
                        System.out.print(".");
                    }
                }
            }
        }
    }

    //Method Name:      getCell
    //Parameters:       r and c, both ints
    //Return value(s):  a char
    //Partners:
    //Description:      Retrieves the individual char at the given coordinates of the array
    public char getCell(int r, int c)
    {
        return map[r][c];
    }

    //Method Name:      setCell
    //Parameters:       r and c, both ints; and val, a char
    //Return value(s):  none
    //Partners:		none
    //Description:      Sets individual elements in the map array
    public void setCell(int r, int c, char val)
    {
        try
        {
            if (r < 12 && c < 12)
            {
                map[r][c] = val;
            }
        }
        catch (InputMismatchException IME)
        {
            System.out.printf("\n%s\n", IME);
        }
    }

    //Method Name:      getEntranceRow
    //Parameters:       none
    //Return value(s):  the row to be the entrance, an int
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //Description:      Finds the row that is the entrance
    public int getEntranceRow()
    {
        return entranceRow;
    }

    //Method Name:      getExitColumn
    //Parameters:       none
    //Return value(s):  row to be the exit, an int
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //Description:      finds the row that is the exit
    public int getExitColumn()
    {
       int exitRow = map[0].length - 1;
       return exitRow;
    }

    //Method Name:      isOpenSpace
    //Parameters:       r and c, both ints
    //Return value(s):  a boolean
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //Description:      checks if given array index is an open space
    public boolean isOpenSpace(int r, int c)
    {
        if(r >= 0 && r < 12)
        {
            if(c >= 0 && c < 12)
            {
                if(map[r][c] == '.')
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
	return false;
    }

    //Method Name:      printMaze
    //Parameters:       none
    //Return value(s):  none
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //Description:      outputs the map array
    public void printMaze()
    {
        for(int r = 0; r < map.length; r++)
        {
            for(int c = 0; c < map[r].length; c++)
            {
                System.out.printf("%c", map[r][c]);
            }
	    System.out.println();
        }
    }

}
