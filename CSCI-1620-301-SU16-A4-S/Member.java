//Name:         Sonia Liu
//Class:        1620-301
//Program#:     4
//Due Date:     Aug 2
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
//      		Marcus Mallum, mmmallum@unomaha.edu
//		        Sweety Goenka, sgoenka@unomaha.edu
//Description:  Represents a library member. Has the name and the limit of books the member can check out, and the member's id.  Also has an arraylist of books that are the books currently checked out by that member
//
public class Member implements hasKey
{
    private String name;
    private final int MAX_BOOKS = 3;
    private ArrayList<Book> checkedOut;
    private int memberId;

    //Method Name:      Member
    //Parameters:       none
    //Return value(s):  none
    //Partners: 		Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Constructor. Sets key member to 0, name to "", and checkedOut to an unsized ArrayList
    public Member()
    {
        memberId = 0;
        name = " ";
        checkedOut = new ArrayList (Book.class);
    }
    //Method Name:      Member
    //Parameters:       n, a string; and i, an int
    //Return value(s):  none
    //Partners:         Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Constructor. Sets name to n, and checkedOut to an ArrayList<Book> of 3
    //                  stackoverflow.com/question/8896758/initial-size-for-the-arraylist
    public Member(String n, int i)
    {
        name = n;
        memberId = i;
        try
        {
            checkedOut = new ArrayList<Book>(Book.class, MAX_BOOKS);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    //Method Name:      checkOut
    //Parameters:       b, a Book
    //Return value(s):  a Boolean
    //Partners: 	    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Adds the passed book to the checkedOut ArrayList if less than 3 books are checked out. Returns true if it can, false if not
    public Boolean checkOut(Book b)
    {
        if(checkedOut.lengthIs() < MAX_BOOKS)
        {
            checkedOut.addItem(b);
            return true;
        }
        else
        {
            return false;
        }
    } 

    //Method Name:      returnBook
    //Parameters:       b, a Book
    //Return value(s):  a Boolean
    //Partners:		    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Tries to remove the passed book from checkedOut. Returns true if successful, false otherwise
    public Boolean returnBook(Book b)
    {
        if (checkedOut.findItem(b) != -1)
        {
            checkedOut.removeItem(b);
            return true;
        }
        else
        {
            return false;
        }
    }

    //Method Name:      equals
    //Parameters:       m, an Object
    //Return value(s):  a boolean
    //Partners:		    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      determines if passed Member is same as the calling member - true if so. Otherwise, false
    public boolean equals(Object m)
    {
        if (memberId == m)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //Method Name:      printCheckedOut
    //Parameters:       none
    //Return value(s):  none
    //Partners:         Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      outputs all the currently checked out Books
    public void printCheckedOut()
    {
        if(checkedOut.isEmpty())//there is items in checkedOut
        {    
            System.out.print("Member does not have any books checked out.\n\n");
        }
        else//there are no items in checkedOut
        {
            System.out.print(checkedOut.toString());
        }


    }

    //Method Name:      toString
    //Parameters:       none
    //Return value(s):  a formatted string
    //Partners:         Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Returns a formatted string
    @Override
    public String toString()
    {
        return String.format("%s\n%d\n", name, memberId);
    }

    //Method Name:      getKey
    //Parameters:       none
    //Return value(s):  memberId, an int
    //Partners:		    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      returns the member ID
    public int getKey()
    {
        return memberId;
    }

}
