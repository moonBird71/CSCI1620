import java.util.Scanner;
import java.util.Random;

public class NPC
{
    public static void main(String[] args)
    {
    String grid[][] = new String[5][];	//uneven array - know how many categories, but each has different number of content

    grid[0] = new String[11];
    grid[0][0] = "Midlander Hyur";
    grid[0][1] = "Highlander Hyur";
    grid[0][2] = "Seeker of the Sun";
    grid[0][3] = "Keeper of the Moon";
    grid[0][4] = "Dunesfolk Lalafell";
    grid[0][5] = "Plainsfolk Lalafell";
    grid[0][6] = "Wildwood Elezen";
    grid[0][7] = "Duskwright Elezen";
    grid[0][8] = "Sea Wolf";
    grid[0][9] = "Hellsguard";
    grid[0][10] = "random";

    grid[1] = new String[3];
    grid[1][0] = "Male";
    grid[1][1] = "Female";
    grid[1][2] = "random";

    grid[2] = new String[14];
    grid[2][0] = "Braid";
    grid[2][1] = "Cornrows";
    grid[2][2] = "Shaved";
    grid[2][3] = "Spiked";
    grid[2][4] = "High Ponytail";
    grid[2][5] = "Low Ponytail";
    grid[2][6] = "Side Tail";
    grid[2][7] = "Ear Length";
    grid[2][8] = "Chin Length";
    grid[2][9] = "Dreadlocks";
    grid[2][10] = "Style 11";
    grid[2][11] = "Style 12";
    grid[2][12] = "Style 13";
    grid[2][13] = "random";

    grid[3] = new String[6];
    grid[3][0] = "Green";
    grid[3][1] = "Blue";
    grid[3][2] = "Gray";
    grid[3][3] = "Brown";
    grid[3][4] = "Yellow";
    grid[3][5] = "random";

    grid[4] = new String[7];
    grid[4][0] = "Pale";
    grid[4][1] = "Tan";
    grid[4][2] = "Dark";
    grid[4][3] = "Warm";
    grid[4][4] = "Dusky";
    grid[4][5] = "Exotic";
    grid[4][6] = "random";

    Tutorial();
    System.out.println();
    selectRace(grid);
    System.out.println();
    selectGender(grid);
    System.out.println();
    selectHair(grid);
    System.out.println();
    selectEye(grid);
    System.out.println();
    selectSkin(grid);
    System.out.println();

    }
    public static void Tutorial()
    {
        System.out.println("This program allows you to select an NPC's race, gender, hair, eyes, and skin color.  Or to have them selected randomly.");
    }

    public static String random(String grid[][], int r)
    {
        int rdm = new Random().nextInt(grid[r].length - 1);
        return grid[r][rdm];
    }

    public static void selectRace(String grid[][])
    {
        Scanner i = new Scanner(System.in);
        System.out.println("Select race: ");
        for (int r = 0; r < 1; r++)
        {
            for(int c = 0; c < grid[r].length; c++)
            {
                System.out.printf("%s ", grid[r][c]);
            }
            System.out.println();
        }
        String race = i.nextLine();
        if (race.equals("random"))
        {
            race = random(grid, 0);
        }
        System.out.printf("%s", race);
    }

    public static void selectGender(String grid[][])
    {
        Scanner i = new Scanner(System.in);
        System.out.println("Select gender: ");
        for (int r = 1; r < 2; r++)
        {
            for(int c = 0; c < grid[r].length; c++)
            {
                System.out.printf("%s ", grid[r][c]);
            }
            System.out.println();
        }
        String gender = i.nextLine();
        if (gender.equals("random"))
        {
            gender = random(grid, 1);
        }
        System.out.printf("%s", gender);

    }

    public static void selectHair(String grid[][])
    {
        Scanner i = new Scanner(System.in);
        System.out.println("Select hair style: ");
        for (int r = 2; r < 3; r++)
        {
            for(int c = 0; c < grid[r].length; c++)
            {
                System.out.printf("%s ", grid[r][c]);
            }
            System.out.println();
        }
        String hair = i.nextLine();
        if (hair.equals("random"))
        {
            hair = random(grid, 2);
        }
        System.out.printf("%s", hair);

    }

    public static void selectEye(String grid[][])
    {
        Scanner i = new Scanner(System.in);
        System.out.println("Select eye color: ");
        for (int r = 3; r < 4; r++)
        {
            for(int c = 0; c < grid[r].length; c++)
            {
                System.out.printf("%s ", grid[r][c]);
            }
            System.out.println();
        }
        String eye = i.nextLine();
        if (eye.equals("random"))
        {
            eye = random(grid, 3);
        }
        System.out.printf("%s", eye);

    }

    public static void selectSkin(String grid[][])
    {
        Scanner i = new Scanner(System.in);
        System.out.println("Select skin tone: ");
        for (int r = 4; r < 5; r++)
        {
            for(int c = 0; c < grid[r].length; c++)
            {
                System.out.printf("%s ", grid[r][c]);
            }
            System.out.println();
        }
        String skin = i.nextLine();
        if (skin.equals("random"))
        {
            skin = random(grid, 4);
        }
        System.out.printf("%s", skin);
    }
    
}
