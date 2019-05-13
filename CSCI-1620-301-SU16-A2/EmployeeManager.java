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
//
//Description:  Manages the array of employee data: adding and removing information, listing the entries, calculating pay and bonuses, and changing variables
//
public class EmployeeManager
{
    private Employee[] employees;
    private final int employeeMax = 100;
    private int currentEmployees;

    //Method Name:      EmployeeManager
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      Constructor. Creates Employee array and sets currentEmployees to 0

    public EmployeeManager()
    {
        employees = new Employee[employeeMax];
        currentEmployees = 0;
    }

    //Method Name:      addEmployee
    //Parameters:       type and en as ints, fn and ln as strings, m and g as chars, ft as boolean, amount as double
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      takes an int that represents the added employee's type, as well as data to create that employee
    public void addEmployee(int type, String fn, char m, String ln, char g, int en, boolean ft, double amount)
    {
        if (currentEmployees == employeeMax)
        {
            System.out.println("End of array, can accept no more employees.");
        }
        else
        {
                if (type == 1)
                {
                    employees[currentEmployees] = new HourlyEmployee(fn, ln, m, g, en, ft, amount);
                    currentEmployees++;
                }
                if (type == 2)
                {
                    employees[currentEmployees] = new SalaryEmployee(fn, ln, m, g, en, ft, amount);
                    currentEmployees++;
                }
                if (type == 3)
                {
                    employees[currentEmployees] = new CommissionEmployee(fn, ln, m, g, en, ft, amount);
                    currentEmployees++;
                }
        }
    }

    //Method Name:      removeEmployee
    //Parameters:       index, an int
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      Removes an Employee at the given index of the Employee array
    //                  cs.umd.edu/~clin/MoreJava/Container/arr-remove.html
    public void removeEmployee(int index)
    {
        employees[index] = employees[currentEmployees - 1];
        employees[currentEmployees - 1] = null;
        currentEmployees--;
    }

    //Method Name:      listAll
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      Lists all current employees.  Outputs "No Employees" if there are none
    public void listAll()
    {
        if (currentEmployees == 0)
        {
            System.out.println("No Employees.");
        }
        else if (currentEmployees > 0)
        {
            for (int x = 0; x < currentEmployees; x++)
            {
                System.out.printf("%s\n", employees[x].toString());
                //use .toString?
            }
        }
    }

    //Method Name:      listHourly
    //Parameters:       none
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      Lists all current Hourly employees. Outputs "No Employees" if there are none
    public void listHourly()
    {
        int hCount = 0;
        for(Employee e: employees)
        {
            if (e instanceof HourlyEmployee)
            {
                HourlyEmployee he = (HourlyEmployee)e;
                System.out.printf("%s\n", he);
                hCount++;
            }
        }
	if (hCount == 0)
            {
                System.out.println("No Employees.");
            }
    }

    //Method Name:      listSalary
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      Lists all the current Salary employees. OUtputs "No Employees" if there are none
    public void listSalary()
    {
        int sCount = 0;
        for (Employee e: employees)
        {
            if (e instanceof SalaryEmployee)
                //instanceof use?
            {
                SalaryEmployee se = (SalaryEmployee)e;
                System.out.printf("%s\n", se);
                sCount++;
            }
        }
 	if (sCount == 0)
            {
                System.out.println("No Employees.");
            }
    }

    //Method Name:      listCommission
    //Parameters:       none
    //Return value(s):  none
    //Partners: 	none
    //Description:      Lists all current Commission employees. Outputs "No Employees" if there are none
    public void listCommission()
    {
        int cCount = 0;
        for (Employee e: employees)
        {
            if (e instanceof CommissionEmployee)
            {
                CommissionEmployee ce = (CommissionEmployee)e;
                System.out.printf("%s\n", ce);
                cCount++;
            }
        }
	if (cCount == 0)
            {
                System.out.println("No Employees.");
            }
    }

    //Method Name:      resetWeek
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      Resets week for all employees
    public void resetWeek()
    {
        for (int x = 0; x < currentEmployees; x++)
        {
            employees[x].resetWeek();
            //correct?
        }
    }

    //Method Name:      calculatePayout
    //Parameters:       none
    //Return value(s):  the total weekly payout for all employees, a double
    //Partners: 	Casey Largent, caseylargent@unomaha.edu
    //Description:      Returns the weekly payout for all employees
    public double calculatePayout()
    {
        double payout = 0.0;
        for (int x = 0; x < currentEmployees; x++)
        {
	  System.out.printf("\n%sPayout Amount: %.2f\n", employees[x], employees[x].calculateWeeklyPay());
          payout += employees[x].calculateWeeklyPay();
		//round up   
        }
	System.out.println();
	return payout;
    }
    //Method Name:      removeRedundancies
    //Parameters:       none
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      Removes any duplicate employees, retaining the earlier version
    public void removeRedundancies()
    {
        for(int x = 0; x < currentEmployees - 1; x++)
        {
            for(int y = x + 1; y < currentEmployees; y++)
            {
                if(employees[x].getEmployeeNumber() == employees[y].getEmployeeNumber())
                    //need to compare employee IDs
                {
		    System.out.printf("\nDuplicate employee ID found: %d. Employee %s, %s has not been added.\n", employees[y].getEmployeeNumber(), employees[y].getLastName(), employees[y].getFirstName());
			//input employee number, last name, first name
                    removeEmployee(y);
                }
            }
        }
    }

    //Method Name:      getIndex
    //Parameters:       empNum, an int
    //Return value(s):  index of the given employee in the array. -1 if the employee doesn't exist in the array
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      Given an employee number, returns the index of that employee.  Returns -1 if employee doesn't exist
    public int getIndex(int empNum)
    {
        for (int x = 0; x < currentEmployees; x++)
        {
            if(employees[x].getEmployeeNumber() == empNum)
            {
                return x; 
            }
        }
	return -1;
    }

    //Method Name:      sortNumber
    //Parameters:       none
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      sorts employees by employee number
    //                  www.java-examples.com/java-bubble-sort-example
    public void sortNumber()
    {
        Employee temp;
        for (int x = 0; x < currentEmployees - 1; x++)
        {
            for(int y = x + 1; y < currentEmployees; y++)
            {
                if (employees[x].getEmployeeNumber() > employees[y].getEmployeeNumber())
                {
                    temp = employees[x];
                    employees[x] = employees[y];
                    employees[y] = temp;
                }
            }
        }
    }

    //Method Name:      sortName
    //Parameters:       none
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      sorts employees primarily by last name, secondarily by first name
    public void sortName()
    {
        Employee temp;
        for (int x = 0; x < currentEmployees - 1; x++)
        {
            for(int y =  x + 1; y < currentEmployees; y++)
            {
                if (employees[x].getLastName().compareTo(employees[y].getLastName()) > 0)
                {
                    temp = employees[x];
                    employees[x] = employees[y];
                    employees[y] = temp;
                }
                if(employees[x].getLastName().compareTo(employees[y].getLastName()) == 0)
		{
                    if (employees[x].getFirstName().compareTo(employees[y].getFirstName()) > 0)
                    {
                        temp = employees[x];
                        employees[x] = employees[y];
                        employees[y] = temp;
                    }
                }
            }
        }
    }

    //Method Name:      annualRaises
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      Applies annual raise to all current employees
    public void annualRaises()
    {
        for (int x = 0; x < currentEmployees; x++)
        {
            employees[x].annualRaise();
            //correct?
        }
    }

    //Method Name:      holidayBonuses
    //Parameters:       none
    //Return value(s):  the holiday bonuses of all employees in total, a double
    //Partners:		none
    //Description:      outputs the total holiday bonus of all employees
    public double holidayBonuses()
    {
        double total = 0.0;
        for(int x = 0; x < currentEmployees; x++)
        {
            total += employees[x].holidayBonus();
        }
        System.out.printf("Total holiday bonus: %f", total);
        return total;
    }

    //Method Name:      increaseHours
    //Parameters:       index - an int, amount - a double
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      increase the hours worked of the employee at the index by the amount
    public void increaseHours(int index, double amount)
    {
        if (employees[index] instanceof HourlyEmployee)
            //correct?
        {
            ((HourlyEmployee)(employees[index])).increaseHours(amount);
        }
    }

    //Method Name:      increaseSales
    //Parameters:       index - an int, amount - a double
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      increase sales of the employee at the given index by the amount
    public void increaseSales(int index, double amount)
    {
        if(employees[index] instanceof CommissionEmployee)
            //correct?
        {
            ((CommissionEmployee)(employees[index])).increaseSales(amount);
        }
    }

}
