//Name:         Sonia Liu
//Class:        1620-301
//Program#:     2
//Due Date:     July 19
//
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha,
//              I have neither given nor received unauthorized help on this 
//              homework assignment
//
//Name:         Sonia Liu
//NUID:         748
//Email:        sonialiu@unomaha.edu
//
//Partners:    	Casey Largent, caseylargent@unomaha.edu
//		Marcus Mallum, mmmallum@unomaha.edu
//Description:  Accepts variables from superclass Employee.  Has methods to increase the sales variable, the rate variable, return the rate, and output the information as a string
//
public class CommissionEmployee extends Employee
{
    private double sales;
    private double rate;
    //Method Name:      CommissionEmployee
    //Parameters:       first and last name as strings, middle initial and gender as chars, employee number as an int, fulltime as a boolean, rate as a double
    //Return value(s):  none
    //Partners:	    Marcus Mallum, mmmallum@unomaha.edu
    //Description:      receives field and superclass variables for use
    public CommissionEmployee (String fn, String ln, char m, char g, int empNum, boolean ft, double rate)
    {
        super(fn, ln, m, g, empNum, ft);
        this.rate = rate;
        sales = 0.0;
    }

    //Method Name:      increaseSales
    //Parameters:       sales, a double
    //Return value(s):  a formatted string
    //Partners:		none
    //Description:      increases the value of sales, a double.  Gives error message if given a negative value
    public void increaseSales (double sales)
	//
    {
        if (sales < 0)
        {
            System.out.println("Invalid value, please enter a positive number: ");
        }
        else
        {
            this.sales += sales;
        }
    }

    //Method Name:      annualRaise
    //Parameters:       none
    //Return value(s):  none
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //Description:      increase rate by .2%
    public void annualRaise ()
    {
        rate += .2;
    }

    //Method Name:      calculateWeeklyPay
    //Parameters:       none
    //Return value(s):  a formatted string
    //Partners:		none
    //Description:      returns the rate as a string
    public double calculateWeeklyPay()
    {
        return (rate * sales) / 100;
	//
    }

    //Method Name:      holidayBonus
    //Parameters:       none
    //Return value(s):  formatted strings
    //Partners:		none
    //Description:      no bonus
    public double holidayBonus()
    {
        return 0;
    }

    //Method Name:      resetWeek
    //Parameters:       none
    //Return value(s):  a string
    //Partners:		none
    //Description:      reset sales to 0
    public void resetWeek()
    {
        sales = 0.0;
    }

    //Method Name:      toString
    //Parameters:       none
    //Return value(s):  a formatted string
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      overrides superclass toString method and outputs the information in a formatted string
    @Override
    public String toString()
    {
        return String.format("%sRate: %.2f\nSales: %.2f\n", super.toString(), rate, sales);

    }

}
