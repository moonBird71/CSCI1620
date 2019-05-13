//Name:         Sonia Liu
//Class:        1620-301
//Program#:     0
//Due Date:     July 5
//
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha, I have neither given nor received unauthorized help on this homework assignment
//
//Name:         Sonia Liu
//NUID:         748
//Email:        sonialiu@unomaha.edu
//
//Partners:     Sweety Goenka, sgoenka@unomaha.edu
//
//Description:  Stores array of up to 10 floats and processes the array to find the sum, average, largest value and smallest value
import java.util.Scanner;
public class SimpleList
{
    private final Integer ARRAY_LENGTH = 10;
    private Float[] List;
    private Integer Count = 0;
    private Float Sum;
    private Float Average;
    private Float Large;
    private Float Small;

//Method Name:      SimpleList
//Parameters:       none
//Return value(s):  none
//Partners:         Sweety Goenka, sgoenka@unomaha.edu
//Description:      Welcomes user and sets Sum and the values in List to 0
    public SimpleList()
    {
        System.out.println("Welcome to the SimpleList Class");
	List = new Float[ARRAY_LENGTH];
	for (Integer r = 0; r < List.length; r++)
        {
            List[r] = 0.0f;
        }
        Sum = 0.0f;
    }
//Method Name:      getData
//Parameters:       none
//Return value(s):  none
//Partners:         Sweety Goenka, sgoenka@unomaha.edu
//Description:      Asks user to input up to 10 values, then stores the values into 'List' array and then uses 'Count' to keep track of the number of values
//                  Referenced www.tutorialspoint.com and stackoverflow.com
    public void getData()
    {
        Scanner i = new Scanner(System.in);
        System.out.print("Enter a floating point value: ");
	Count++;
        List[0] = i.nextFloat();
        for (Integer r = 1; r < List.length; r++)
        {
            System.out.print("Would you like to input another value (y or n)? ");
            char a = i.next().charAt(0);
            if (a =='n')                       //n
            {
                break;
            }
            else if (a =='y')                  //y
            {
		System.out.print("Enter a floating point value: ");
                List[r] = i.nextFloat();
		Count++;
            }
            else
            {
                System.out.println("Invalid input, enter y or n");
                r--;
            }
        }
    }

//Method Name:      processData
//Parameters:       none
//Return value(s):  none
//Partners:         none
//Description:      Calculates the sum, average, the smallest and largest of the user's input
//                  Referenced www.java-examples.com
    public void processData()
    {
        Large = List[0];
        Small = List[0];
        for (Integer r = 0; r < Count; r++)
        {
            Sum += List[r];
        }
        Average = Sum / Count;
        for (Integer r = 1; r < Count; r++)
        {
            if (List[r] >= Large)
            {
                Large = List[r];
            }
            else if (List[r] <= Small)
            {
                Small = List[r];
            }
        }
    }

//Method Name:      displayResults
//Parameters:       none
//Return value(s):  none
//Partners:         Sweety Goenka, sgoenka@unomaha.edu
//Description:      Displays the values stores in the 'List' array, the Sum, the Average, the largest value, and the smallest value
    public void displayResults()
    {
        for(Integer r = 0; r < Count; r++)
        {
            System.out.printf("Value %d = %f\n", r+1, List[r]);
        }
        System.out.printf("Sum of all values = %f\n", Sum);
        System.out.printf("Average of all values = %f\n",Average);
        System.out.printf("Largest value = %f\n", Large);
        System.out.printf("Smallest value = %f\n", Small);

    }


}
