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
//		Casey Largent, caseylargent@unomaha.edu
//Description:  holds the recursive methods to solve the maze, and to count the steps taken
//
public class MazeSolver
{
    private Maze maze;
    private int steps;

    //Method Name:      MazeSolver
    //Parameters:       m, of class maze
    //Return value(s):  none
    //Partners:		none
    //Description:      holds a Maze object, and counts the steps the solution takes
    public MazeSolver(Maze m)
    {
        maze = m;
        this.steps = steps;
        steps = 0;
    }

    //Method Name:      solveMaze
    //Parameters:       r and c, both ints
    //Return value(s):  a boolean
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //			Casey Largent, caseylargent@unomaha.edu
    //Description:      takes current position and tries to find exit
    public boolean solveMaze(int r, int c)
    {
	//if the passed col is both the last col and an open space, signals end of recursion
        if (c == maze.getExitColumn() && maze.isOpenSpace(r, c))
        {
	    maze.setCell(r, c, 'x');
	    steps++;
            return true;
        }

	//test: if current location is not open, cuts this recursion
	//if open, continue
        if(maze.isOpenSpace(r, c) == false)
        {
            return false;
        }

	//if not trip the false test, then mark current location 
        maze.setCell(r, c, 'x');

	//calls itself one space below; if recursive result is true, increase step count
	if (solveMaze(r + 1, c) == true)
        {
            steps++;
            return true;
        }

	//calls itself one space to the right; ...
        if (solveMaze(r, c + 1) == true)
        {
            steps++;
            return true;
        }

	//calls itself one space to the left; ...
        if (solveMaze(r, c - 1) == true)
        {
            steps++;
            return true;
        }

	//calls itself one space up; ...
 	if (solveMaze(r - 1,c) == true)
        {
            steps++;
            return true;
        }

	//if not part of path, removes the mark
	maze.setCell(r, c, '.');
	return false;
	
    }

    //Method Name:      getSteps
    //Parameters:       none
    //Return value(s):  the number of steps taken to reach end of maze, an int
    //Partners:		none
    //Description:      returns steps taken to reach end of maze
    public int getSteps()
    {
        return steps;
    }

}
