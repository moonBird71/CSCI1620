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
//Description:  A menu driven system allowing to check out and return books
//
import java.util.Scanner;

public class Library
{
    //Method Name:  	main
    //Parameters:   	none
    //Return value(s):	none
    //Partners:		    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:	a menu driven system allowing the checking out/returning of books

    public static void main(String[] args)
    {
        ArrayList<Book> books = null;
        ArrayList<Book> stock = null;
        ArrayList<Member> members = null;

        //Declare other variables to be used
        try
        {
            books = new ArrayList(Book.class, 5);
            stock = new ArrayList(Book.class, 5);
            members = new ArrayList(Member.class, 5);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        Scanner s = new Scanner(System.in);
        int id = 0;
        int isbn = 0;
        int numID = 0;
        Book numISBN = null;
        int choice = 0;
        boolean check = false;
        int index = 0;
        Member mbr = new Member();
        //Create new ArrayLists for books, stock, and members
        //Remember, the constructor for ArrayList that
        //takes a size throws an Exception!

        //Populate books ArrayList
        books.addItem(new Book(812550706, "Ender's Game", "Card, Orson Scott"));
        books.addItem(new Book(385334206, "Breakfast of Champions", "Vonnegut, Kurt"));
        books.addItem(new Book(80652720, "The Alphabet of Manliness", "Maddox"));
        books.addItem(new Book(141182865, "A Condeferacy of Dunces", "Toole, John Kennedy"));
        books.addItem(new Book(441013597, "Dune", "Herbert, Frank"));
        books.addItem(new Book(415325056, "History of Western Philosophy", "Russell, Bertrand"));
        books.addItem(new Book(307388921, "Choke", "Palahniuk, Chuck"));
        books.addItem(new Book(316776963, "Me Talk Pretty One Day", "Sedaris, David"));
        books.addItem(new Book(375703768, "House of Leaves", "Danielewski, Mark"));
        books.addItem(new Book(1592402038, "Eats, Shoots, & Leaves", "Truss, Lynne"));

        //Populate members ArrayList
        members.addItem(new Member("Parker, Peter", 56754));
        members.addItem(new Member("Spector, Marc", 74686));
        members.addItem(new Member("Curry, Arthur", 71245));
        members.addItem(new Member("Stark, Tony", 96785));
        members.addItem(new Member("Queen, Oliver", 45267));

        //Copy books into stock
        for(int x = 0; x < books.lengthIs(); x++)
        {
            try
            {
                stock.addItem(books.get(x));
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

        //Implement Library User Menu\
        do
        {
            System.out.println("Library Manager");
            System.out.println("1. Check Out");
            System.out.println("2. Return");
            System.out.println("3. List Stock");
            System.out.println("4. List Checked Out");
            System.out.println("5. Exit");
            System.out.print("Selection: ");
            choice = s.nextInt();
            System.out.println();



            switch(choice)
            {
                case 1 :
                    System.out.print(members.toString());

                    do
                    {
                        System.out.print("Member ID: ");
                        id = s.nextInt();
                        System.out.println();
                        numID = members.findItemByKey(id);
                    }
                    while (numID == -1);//check if id is valid/in list

                    System.out.print(books.toString());

                    do
                    {
                        System.out.print("Book ISBN: ");
                        isbn = s.nextInt();
                        System.out.println();
                        index = stock.findItemByKey(isbn);
                    }
                    while (index == -1); //check if ISBN is valid/in list

                    if (index != -1)
                        //in range?
                    {
                        try
                        {
                            numISBN = books.get(index);
                            check = mbr.checkOut(numISBN);
                            if (check == true)
                            {
                                stock.removeItem(numISBN);
                                System.out.printf("%s", members.get(numID));
                                System.out.println("has checked out");
                                System.out.printf("%s", books.get(index));
                            }
                            //prints member who checked out what book
                            else
                            {
                                System.out.println("Member has the max limit of books checked out");
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    else
                    {//output reason why
                        try
                        {
                            System.out.printf("%s", books.get(index));
                            System.out.println("is not available");
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 2 :
                    System.out.print(members.toString());

                    do
                    {
                        System.out.print("Member ID: ");
                        id = s.nextInt();
                        System.out.println();
                        numID = members.findItemByKey(id);
                    }
                    while (numID == -1);//check if id is valid/in list

                    System.out.print(books.toString());

                    do
                    {
                        System.out.print("Book ISBN: ");
                        isbn = s.nextInt();
                        System.out.println();
                        index = books.findItemByKey(isbn);
                    }
                    while (index == -1); //check if ISBN is valid/in list

                    if (index != -1)//member has returned book
                    {
                        try
                        {
                            check = mbr.returnBook(numISBN);
                            stock.addItem(numISBN);
                            if(check = true)
                            {
                                System.out.printf("%s", members.get(numID));
                                System.out.println("has returned");
                                System.out.printf("%s", books.get(index));
                            }
                            else
                            {
                                System.out.print("Member does not have that Book");
                            }
                        }
                        catch (Exception e)
                        {
                            System.out.println(e);
                        }
                    }
                    System.out.print("\n\n");
                    break;

                case 3 :
                    System.out.print(stock.toString());
                    //S.o.p?
                    break;

                case 4 :
                    System.out.print(members.toString());

                    do
                    {
                        System.out.print("Member ID: ");
                        id = s.nextInt();
                        System.out.println();
                        numID = members.findItemByKey(id);
                    }
                    while (numID == -1);//check if id is valid/in list

                    try
                    {
                        Member mem = members.get(numID);
                        mem.printCheckedOut();

                    }

                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    //S.o.p?
                    break;
                case 5 :
                    System.out.println("Exiting Library");
                    break;

            }
        }
        while(choice != 5);
    }//end main
}//end class
