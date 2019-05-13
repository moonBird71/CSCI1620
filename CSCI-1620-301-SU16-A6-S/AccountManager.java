//Name:         Sonia Liu
//Class:        1620-301
//Program#:     6
//Due Date:     August 16
//
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha,
//              I have neither given nor received unauthorized help on this 
//              homework assignment
//
//Name:         Sonia Liu
//NUID:         748
//Email:        sonialiu@unomaha.edu
//
//Partners:     none
//
//Description:  Manages a file of accounts
//
import java.io.*;
import java.util.*;
import java.lang.SecurityException;
public class AccountManager
{
    private AccountRecordSerializable[] accounts;
    private int numRecords;
    private final int MAX_RECORDS = 100;

    //Method Name:      AccountManager
    //Parameters:       none
    //Return value(s):  none
    //Partners:         none
    //Description:      Constructor. Initializes accounts and numRecords
    public AccountManager()
    {
        AccountRecordSerializable accounts[] = new AccountRecordSerializable[MAX_RECORDS];
        int numRecords = 0;
    }
    //Method Name:      readRecords
    //Parameters:       file, a string
    //Return value(s):  none
    //Partners:         none
    //Description:      If passed file doesn't exist, outputs message. If it does, reads the object into accounts array
    public void readRecords(String file)
    {
        try
        {
            input = new ObjectInputStream(new FileInputStream("file.ser"));
            //change to book ex?
        }
        catch(IOException IOE)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
        try
        {
            if(findRecord(input.getAccount) == -1)
            {
                System.err.println("No Existing Records.");
            }
            else
            {
                while(true)
                {
                    AccountRecordSerializable record = (AccountRecordSerializable)input.readObject();
                    record.toString();
                    //.getAccount/First/Last/Balance?
                }
            }
        }
        catch(EOFException EOFE)
        {
            System.err.println("End of File reached.");
        }
        catch(ClassNotFoundException CNFE)
        {
            System.err.println("Unable to create object.");
        }
        catch(IOException IOE)
        {
            System.err.println("Error while reading file.");
        }            
        try
        {
            if(input != null)
            {
                input.close();
            }
        }
        catch(IOException IOE)
        {
            System.err.println("Error closing file.");
            System.exit(1);
        }
    }
    //Method Name:      writeRecords
    //Parameters:       file, a string
    //Return value(s):  none
    //Partners:         none
    //Description:      All objects in accounts array are written to passed file
    public void writeRecords(String file)
    {
        Scanner in = new Scanner(System.in);
        try
        {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("file.ser"));
            //change to book ex?
        }
        catch(IOException IOE)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
        while(in.hasNext())
            //diff method?
        {
            try
            {
                AccountRecordSerializable record = new AccountRecordSerializable(in.nextInt(), in.next(), in.next(), in.nextDouble());
                output.writeObject(record);
                accounts[numRecords] = record;
                numRecords++;
            }
            catch(IOException IOE)
            {
                System.err.println("Error writing to file.");
                return;
            }
            catch(NoSuchElementException NSEE)
            {
                System.err.println("No such element.");
                return;
            }
        }
        try
        {
            if(output != null)
            {
                output.close();
            }
        }
        catch(IOException IOE)
        {
            System.err.println("Error closing file.");
            System.exit(1);
        }
        in.close();
    }
    //Method Name:      printRecords
    //Parameters:       none
    //Return value(s):  none
    //Partners:         none
    //Description:      Prints a header and all current records in sorted order
    public void printRecords()
    {
        System.out.printf("%-10s%-12s%-12s%10s\n", "Account", "First Name", "Last Name", "Balance");
        accounts.sortRecords();
        for(int i = 0; i < numRecords; i++)
        {
            accounts[i].toString();
        }
    }
    //Method Name:      addRecord
    //Parameters:       accountNumber, an int; and balance, a double
    //Return value(s):  none
    //Partners:         none
    //Description:      Prints message that a new account number has been found and prompts for a first and last name, creates a new account, adds it to the array, prints another message, and prints the new account
    public void addRecord(int accountNumber, double balance)
    {
        Scanner in = new Scanner(System.in);
        numRecords++;
        System.out.printf("New account number %d found!\n", accountNumber);
        System.out.print("Enter First Name: ");
        first = (String)in.next();
        System.out.print("\nEnter Last Name: ");
        last = (String)in.next();
        accounts[numRecords] = new AccountRecordSerializable(accountNumber, first, last, balance);
        System.out.println("New account added: ");
        accounts[numRecords].toString();
        in.close();
    }
    //Method Name:      sortRecords
    //Parameters:       none
    //Return value(s):  none
    //Partners:         none
    //Description:      Sorts all records by account number
    public void sortRecords()
    {
        int smallest;
        for(int i = 0; i < numRecords - 1; i++)
        {
            smallest = i;
            for(int o = i + 1; o < numRecords; o++)
            {
                if(accounts[o].nextInt() < accounts[smallest])
                    //correct get int?
                {
                    smallest = o;
                }
            }
            swap(i, smallest);
        }
    }
    //Method Name:      findRecord
    //Parameters:       accountNumber, an int
    //Return value(s):  an int
    //Partners:         none
    //Description:      Tries to find passed account and returns the index if found. Returns -1 if not.
    public int findRecord(int accountNumber)
    {
        int index = -1;
        for(int i = 0; i < numRecords; i++)
        {
            if(accounts[i].getAccount() == accountNumber)
                //get account number out of array
            {
                index = i;
            }
        }
        return index;
    }
    //Method Name:      updateTransactions
    //Parameters:       file, a string
    //Return value(s):  none
    //Partners:         none
    //Description:      Data is read off the passed file, and accounts are adjusted/added as needed
    public void updateTransactions(String file)
    {
        try
        {
            Scanner in = new Scanner(new File("file.txt"));
        }
        catch(FileNotFoundException FNFE)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
        try
        {
            while(true)
            {
                accountNumber = in.nextInt();
                balance = in.nextDouble();
                if(findRecord(accountNumber) == -1)
                {
                    if(balance >= 0.00)
                    {
                        addRecord(accountNumber, balance);
                    }
                }
                else
                {
                    int index = findRecord(accountNumber);
                    double amount = accounts[index].getBalance();
                    amount = (amount + balance);
                    String first = accounts[index].getFirstName();
                    String last = accounts[index].getLastName();
                    accounts[index] = AccountRecordSerializable(accountNumber, first, last, amount);
                }
            }
        }
        catch(EOFException EOFE)
        {
            System.err.println("End of File reached.");
        }
        catch(ClassNotFoundException CNFE)
        {
            System.err.println("Unable to create object.");
        }
        catch(IOException IOE)
        {
            System.err.println("Error while reading file.");
        }

        catch(NoSuchElementException NSEE)
        {
            System.err.println("No such element.");
        }
        catch(IllegalStateException ISE)
        {
            System.err.println("Scanner is closed.");
        }

        try
        {
            if(in != null)
            {
                in.close();
            }
        }
        catch(IOException IOE)
        {
            System.err.println("Error closing file.");
            System.exit(1);
        }
    }
}

