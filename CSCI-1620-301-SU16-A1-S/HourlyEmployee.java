//Name:         Sonia Liu
//Class:        1620-301
//Program#:     1
//Due Date:     July 12
//
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha,
//              I have neither given nor received unauthorized help on this 
//              homework assignment
//
//Name:         Sonia Liu
//NUID:         748
//Email:        sonialiu@unomaha.edu
//
//Partners:     Casey Largent, caseylargent@unomaha.edu
//		Marcus Mallum, mmmallum@unomaha.edu
//Description:  Calculates wage based on hours worked, can increase wage and hours worked, can reset hours worked, and format information
//
public class HourlyEmployee extends Employee
{
    private double wage;
    private double hoursWorked;

    //Method Name:      HourlyEmployee
    //Parameters:       First name and last name as strings, middle initial and gender as chars, employee number as an int, fulltime as a boolean, and wage as a double
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //			Marcus Mallum, mmmallum@unomaha.edu
    //Description:      Receives field variables and variables from superclass for use in later methods.  And sets hours to 0.0
    public HourlyEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double wage)
    {
        super(fn, ln, m, g, empNum, ft);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
        hoursWorked = 0.0;
    }
    //Method Name:      increaseHours
    //Parameters:       hours, a double
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      Adds the amount of hours to the hours worked.  Reports error if amount is negative
    public void increaseHours(double hours)
    {
        if (hours < 0)
        {
            System.out.println("Invalid value, please enter a positive number: ");
        }
        else 
        {
            hoursWorked += hours;
        }
    }

    //Method Name:      annualRaise
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      Finds 5% of the current wage and increases wage by that
    public void annualRaise()
    {
        wage += (((wage * 5) / 100) - .005);
    }

    //Method Name:      calculateWeeklyPay
    //Parameters:       none
    //Return value(s):  the amount earned in a week, a double
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //			Marcus Mallum, mmmallum@unomaha.edu
    //Description:      calculates the amount earned and returns it
    //
    public double calculateWeeklyPay()
    {
        if (hoursWorked > 40)
        {
            return ((wage * 40) + ((hoursWorked - 40) * (wage * 2))) - .005;
        }
        else
        {
            return (wage * hoursWorked) - .005;
        }
    }

    //Method Name:      holidayBonus
    //Parameters:       none
    //Return value(s):  the pay for 40 hours' work, a double
    //Partners:
    //Description:      returns the wages for 40 hours 
    public double holidayBonus()
    {
        return (40 * wage) - .005;
    }

    //Method Name:      resetWeek
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      resets hours worked to 0
    public void resetWeek()
    {
        hoursWorked = 0.0;
    }

    //Method Name:      toString
    //Parameters:       none
    //Return value(s):  formatted strings
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      Overrides superclass toString method to return information in a formatted string
    @Override
    public String toString()
    {        
        return String.format("%sWage: %.2f\nHours Worked: %.2f\n", super.toString(), wage, hoursWorked);
    }

}
