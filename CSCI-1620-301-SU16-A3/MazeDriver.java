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
//Partners:   	Marcus Mallum, mmmallum@unomaha.edu 
//
//Description:	ask user which maze to use, and calls methods to solve maze and output answer
//
import java.util.InputMismatchException;
import java.util.Scanner;
public class MazeDriver
{
    //Method Name:	main
    //Parameters:  	none
    //Return value(s):	none
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //Description:	ask user which maze to use, and calls methods to solve maze and output answer
    public static void main(String args[])
    {
       	int choice = 0;
        Maze m;
	MazeSolver ms;
        Scanner s = new Scanner(System.in);
        
	int ent;
        char[][]m1 = {{'#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','#','.','.','.','.','.','.','#'},
            {'.','.','#','.','#','.','#','#','#','#','.','#'},
            {'#','#','#','.','#','.','.','.','.','#','.','#'},
            {'#','.','.','.','.','#','#','#','.','#','.','.'},
            {'#','#','#','#','.','#','.','#','.','#','.','#'},
            {'#','.','.','#','.','#','.','#','.','#','.','#'},
            {'#','#','.','#','.','#','.','#','.','#','.','#'},
            {'#','.','.','.','.','.','.','.','.','#','.','#'},
            {'#','#','#','#','#','#','.','#','#','#','.','#'},
            {'#','.','.','.','.','.','.','#','.','.','.','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#'}};
        char[][]m2 =  {{'#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','.','.','.','#','.','.','.','#','#','.','.'},
            {'#','.','#','.','.','.','#','.','.','.','.','#'},
            {'#','.','#','#','#','#','.','#','.','#','.','#'},
            {'#','.','.','.','#','#','.','.','.','.','.','#'},
            {'#','#','#','.','#','#','#','#','.','#','.','#'},
            {'.','.','.','.','.','.','.','.','.','.','#','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#'}};
        char[][]m3 = {{'#','#','#','#','#','#','#','#','#'},
            {'#','.','#','.','#','.','.','.','#'},
            {'#','.','.','.','#','.','#','#','#'},
            {'#','#','#','.','#','.','#','.','.'},
            {'.','.','.','.','.','.','#','.','#'},
            {'#','#','.','#','.','#','#','.','#'},
            {'#','.','.','#','.','#','.','.','#'},
            {'#','#','.','#','.','#','.','.','#'},
            {'#','#','#','#','#','#','#','#','#'}};

        do
        {
            System.out.println("Which Maze would you like?");
            for (int line = 0; line < 3; line++)
            {
                System.out.printf("%d. Maze %d\n", line + 1, line + 1);
            }
            System.out.println("4. Random");
            System.out.print("Enter Choice: ");
            try
            {
                choice = s.nextInt();
            }
            catch(InputMismatchException IME)
            {
                System.out.printf("\n%s\n", IME);
            }
            if(choice < 1 || choice > 4)
            {
                System.out.println("Invalid choice");
            }

        }
        while (choice < 1 || choice > 4);

        switch(choice)
        {
            case 1:
		System.out.println();
                m = new Maze(m1, 2, 4);
		ms = new MazeSolver(m);
                System.out.println("Your Maze");
		System.out.println();
                m.printMaze();
                System.out.println();
                ent = m.getEntranceRow();
                if(ms.solveMaze(ent, 0) == true)
                {
                    System.out.println("Solved");
                    System.out.println("Your Maze");
		    System.out.println();
                    m.printMaze();
                    System.out.printf("Path took %d steps.\n", ms.getSteps());
                }
                else
                {
                    System.out.println("Your Maze");
		    System.out.println();
                    m.printMaze();
                    System.out.println("Not Solved");
                }
		break;

            case 2:
		System.out.println();
                m = new Maze(m2, 6, 1);
		ms = new MazeSolver(m);
                System.out.println("Your Maze");
		System.out.println();
                m.printMaze();                
		System.out.println();
                ent = m.getEntranceRow();
                if(ms.solveMaze(ent, 0) == true)
                {
                    System.out.println("Solved");
                    System.out.println("Your Maze");
		    System.out.println();
                    m.printMaze();
                    System.out.printf("Path took %d steps.\n", ms.getSteps());
                }
                else
                {
                    System.out.println("Your Maze");
		    System.out.println();
                    m.printMaze();
                    System.out.println("Not Solved");
                }
		break;
            case 3:
		System.out.println();
                m = new Maze(m3, 4, 3);
		ms = new MazeSolver(m);
                System.out.println("Your Maze");
		System.out.println();
                m.printMaze();                
		System.out.println();
                ent = m.getEntranceRow();
                if(ms.solveMaze(ent, 0) == true)
                {
                    System.out.println("Solved");
                    System.out.println("Your Maze");
		    System.out.println();
                    m.printMaze();
                    System.out.printf("Path took %d steps.\n", ms.getSteps());
                }
                else
                {
                    System.out.println("Your Maze");
		    System.out.println();
                    m.printMaze();                    
		    System.out.println("Not Solved");
                }
		break;
            case 4:
		System.out.println();
                System.out.println("Your Maze");
		System.out.println();
                m = new Maze();
		ms = new MazeSolver(m);
                System.out.println();
                ent = m.getEntranceRow();
                if(ms.solveMaze(ent, 0) == true)
                {
                    System.out.println("Solved");
                    System.out.println("Your Maze");
		    System.out.println();
                    m.printMaze();
                    System.out.printf("Path took %d steps.\n", ms.getSteps());
                }
                else
                {
                    System.out.println("Your Maze");
		    System.out.println();
                    m.printMaze();
                    System.out.println("Not Solved");
                }

        }
    }
}
