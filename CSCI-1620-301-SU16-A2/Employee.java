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
//Description:  Base class that other classes in directory inherit variables and methods from.  Contains methods to validate and return employee information and to override the superclass methods of equals and toString.
//
import java.util.Scanner;
public abstract class Employee
{
    private String firstName;
    private String lastName;
    private char middleInitial;
    private boolean fulltime;
    private char gender;
    private int employeeNum;

    //Method Name:      Employee
    //Parameters:       First name and last name as strings, middle initial and gender as chars, employee number as int, and fulltime as boolean
    //Return value(s):  none
    //Partners:		Marcus Mallum, mmmallum@unomaha.edu
    //Description:      Receives field variables for use in other methods
    public Employee(String fn, String ln, char m, char g, int empNum, boolean ft)
    {
        setFirstName(fn);
        setLastName(ln);
        setMiddleI(m);
        setGender(g);
        setEmployeeNumber(empNum);
        fulltime = ft;
    }

    //Method Name:      setEmployeeNumber
    //Parameters:       empNum, an int
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //			Marcus Mallum, mmmallum@unomaha.edu
    //Description:      validates that the Employee Number is between 10,000 and 99,999 and asks for another if it isn't
    public void setEmployeeNumber(int empNum)
    {
        Scanner s = new Scanner(System.in);
        while (empNum < 10000 || empNum > 99999)
        {
            System.out.println("Employee Number invalid, please re-enter: ");
            empNum = s.nextInt();
        }
        if (empNum >= 10000 && empNum <= 99999)
        {
            employeeNum = empNum;
        }
    }

    //Method Name:      getEmployeeNumber
    //Parameters:       none
    //Return value(s):  employeeNum, an int
    //Partners:		none
    //Description:      returns the employee number
    public int getEmployeeNumber()
    {
        return employeeNum;
    }

    //Method Name:      setFirstName
    //Parameters:       fn, a string
    //Return value(s):  none
    //Partners:		none
    //Description:      assigns the given first name to a variable
    public void setFirstName(String fn)
    {
        firstName = fn;
    }

    //Method Name:      getFirstName
    //Parameters:       none
    //Return value(s):  firstName, a string
    //Partners:		none
    //Description:      returns the given first name
    //                  referenced stackoverflow.com
    public String getFirstName()
    {
        return firstName;
    }

    //Method Name:      setLastName
    //Parameters:       ln, a string
    //Return value(s):  none
    //Partners:		none
    //Description:      assigns the last name to a variable
    public void setLastName(String ln)
    {
        lastName = ln;
    }

    //Method Name:      getLastName
    //Parameters:       none
    //Return value(s):  lastName, a string
    //Partners:		none
    //Description:      returns the given last name
    public String getLastName()
    {
        return lastName;
    }

    //Method Name:      setMiddleI
    //Parameters:       m, a char
    //Return value(s):  none
    //Partners:		none
    //Description:      assigns the given middle initial to a variable
    public void setMiddleI(char m)
    {
        middleInitial = m;
    }

    //Method Name:      setGender
    //Parameters:       g, a char
    //Return value(s):  none
    //Partners:		none
    //Description:      assigns either M or F to the variable 'gender' and defaults to F if the given value is not either one
    public void setGender(char g)
    {
        if (g == 'M' || g == 'F')
        {
            gender = g;
        }
        else
        {
            gender = 'F';
        }
    }

    //Method Name:      equals
    //Parameters:       e2, an object
    //Return value(s):  a boolean
    //Partners: 	none
    //Description:      Overrides the superclass method 'equals.' Now returns 'true' if the employeeNum in both instances are the same, 'false' if not
    @Override
    public boolean equals(Object e2)
    {
        if (this.employeeNum == ((Employee)e2).employeeNum)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Method Name:      toString
    //Parameters:       none
    //Return value(s):  a formatted string
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      Overrides superclass method toString. Now returns given info in a formatted string
    @Override
    public String toString()
    {
        String emp = employeeNum + "\n" + lastName + ", " + firstName + " " + middleInitial + ".\n" + "Gender: " + gender + "\n";
        if (fulltime == true)
        {
            emp += "Status: Full Time\n";
        }
        else
        {
            emp += "Status: Part Time\n";
        }
        return emp;
    }
    //Method Name:      calculateWeeklyPay
    //Parameters:       none
    //Return value(s):  none
    //Partners:		    none
    //Description:      Abstract method to be implemented by subclass.  Calculates pay for the week.
    public abstract double calculateWeeklyPay();

    //Method Name:      annualRaise
    //Parameters:       none
    //Return value(s):  none
    //Partners:		    none
    //Description:      Abstract method to be implemented by subclass.  Gives Employee a raise.
    public abstract void annualRaise();

    //Method Name:      holidayBonus
    //Parameters:       none
    //Return value(s):  none
    //Partners:		    none
    //Description:      Abstract method to be implemented by subclass.  Calculates bonus for Employee.
    public abstract double holidayBonus();

    //Method Name:      resetWeek
    //Parameters:       none
    //Return value(s):  none
    //Partners:		    none
    //Description:      Abstract method to be implemented by subclass.  Resets weekly values for Employee.
    public abstract void resetWeek();

}
