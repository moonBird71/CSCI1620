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
//Description:  Gets variable from superclass to calculate raises, bonuses, and the weekly pay for salary employees.  Outputs the information in a formatted string
//
public class SalaryEmployee extends Employee
{
    private double salary;

    //Method Name:      SalaryEmployee
    //Parameters:       fn and ln as strings, m and g as chars, empNum as an int, ft as a boolean, and salary as a double
    //Return value(s):  none
    //Partners:		none
    //Description:      Receives field and superclass variables
    public SalaryEmployee(String fn, String ln, char m, char g, int empNum, boolean ft, double salary)
    {
        super (fn, ln, m, g, empNum, ft);
        this.salary = salary;
    }

    //Method Name:      annualRaise
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      increases salary by 6%
    public void annualRaise()
    {
        salary += (((salary * 6) / 100) - .005);
    }

    //Method Name:      calculateWeeklyPay
    //Parameters:       none
    //Return value(s):  a formatted string with the salary employee's pay for the week (which is a double)
    //Partners:		none
    //Description:      returns amount a salary employee earns in a week
    public double calculateWeeklyPay()
    {
        return ((salary / 52) - .005);
    }

    //Method Name:      holidayBonus
    //Parameters:       none
    //Return value(s):  formatted strings with the amount for a bonus (a double)
    //Partners:		none
    //Description:      returns the amount for a bonus for a salary employee, which is 3% of salary
    public double holidayBonus()
    {
        return (((salary * 3) / 100) - .005);
    }

    //Method Name:      resetWeek
    //Parameters:       none
    //Return value(s):  a formatted string
    //Partners:		none
    //Description:      no change
    public void resetWeek()
    {
    }

    //Method Name:      toString
    //Parameters:       none
    //Return value(s):  formatted strings 
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      overrides superclass toString method to putput formatted string
    @Override
    public String toString()
    {
        return String.format("%sSalary: %.2f\n", super.toString(), salary);
    }

}
