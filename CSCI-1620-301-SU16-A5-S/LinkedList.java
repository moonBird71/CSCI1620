//Name:         Sonia Liu
//Class:        1620-301
//Program#:     5
//Due Date:     Aug 9
//
//Honor Pledge: On my honor as a student of the University of Nebraska at Omaha,
//              I have neither given nor received unauthorized help on this 
//              homework assignment
//
//Name:         Sonia Liu
//NUID:         748
//Email:        sonialiu@unomaha.edu
//
//Partners:    	Sweety Goenka, sgoenka@unomaha.edu
//		Casey Largent, caseylargent@unomaha.edu
//Description:  Creates and manipulates a LinkedList of nodes
//
import java.util.*;
public class LinkedList<E>
{
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private int numElements;
    private String name;

    //Method Name:      LinkedList
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      Constructor. Sets variables
    public LinkedList()
    {
        name = "list";
        firstNode = null;
        lastNode = null;
        numElements = 0;
    }

    //Method Name:      LinkedList
    //Parameters:       listName, a string
    //Return value(s):  none
    //Partners:		none
    //Description:      Constructor. Sets variables
    public LinkedList(String listName)
    {
        name = listName;
        firstNode = null;
        lastNode = null;
        numElements = 0;
    }

    //Method Name:      insertAtFront
    //Parameters:       item, a generic type
    //Return value(s):  none
    //Partners:		Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Inserts passed item to front of list
    public void insertAtFront(E item)
    {
        ListNode current = null;
        if(numElements == 0)
        {
            firstNode = new ListNode(item);
            lastNode = firstNode;
        }
        else
        {
            current = new ListNode(item, firstNode);
            firstNode = current;
        }
        numElements++;
    }

    //Method Name:      insertAtBack
    //Parameters:       item, a generic type
    //Return value(s):  none
    //Partners:		Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Inserts passed item in back of list
    public void insertAtBack(E item)
    {
        ListNode current = null;
        if(numElements == 0)
        {
            lastNode = new ListNode(item);
            firstNode = lastNode;
        }
        else
        {
            current = new ListNode(item);
            lastNode.setNext(current);
            lastNode = current;
        }
        numElements++;
    }

    //Method Name:      removeFromFront
    //Parameters:       none
    //Return value(s):  a generic type
    //Partners:		Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Removes the first item in list and returns it
    //                  docs.oracle.com.javase/tutorial/essential/exceptions/throwing.html
    public E removeFromFront() throws EmptyListException
    {
        E current = null;
        if(numElements == 0)
        {
            throw new EmptyListException();
        }
        else if(firstNode == lastNode)
        {
            current = firstNode.getData();
            firstNode = null;
            lastNode = null;
            numElements--;
            return current;
        }
        else
        {
            current = firstNode.getData();
            firstNode = firstNode.getNext();
            numElements--;
            return current;
        }
    }

    //Method Name:      removeFromBack
    //Parameters:       none
    //Return value(s):  a generic type
    //Partners:		Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Removes last item in list and returns it
    //                  stackoverflow.com/questions/15792682/delete-last-node-of-a-linked-list
    public E removeFromBack() throws EmptyListException
    {
        E current = null;
        if(numElements == 0)
        {
            throw new EmptyListException();
        }
        else if(firstNode == lastNode)
        {
            current = lastNode.getData();
            firstNode = null;
            lastNode = null;
            numElements--;
            return current;
        }
        else
        {
            ListNode temp = firstNode;
            while(temp.getNext() != lastNode)
            {
                temp = temp.getNext();
            }
            current = lastNode.getData();
            lastNode = temp;
            lastNode.setNext(null);
            numElements--;
            return current;
        }
    }

    //Method Name:      remove
    //Parameters:       index, an int
    //Return value(s):  none
    //Partners:		Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Removes the element at the given index
    public void remove(int index) throws EmptyListException, IndexOutOfBoundsException
    {
        if(numElements == 0)
        {
            throw new EmptyListException();
        }
        else if(index > numElements - 1 || index < 0)
        {
            throw new IndexOutOfBoundsException(name);
        }
        else if(index == 0)
        {
            removeFromFront();
        }
        else
        {
            ListNode current = firstNode;
            ListNode temp = firstNode;
            for(int i = 0; i < index - 1; i++)
            {
                current = current.getNext();
            }
            for(int i = 0; i < index; i++)
            {
                temp = temp.getNext();
            }
            current.setNext(temp.getNext());
            temp.setData(null);
            numElements--;
        }
    }

    //Method Name:      get
    //Parameters:       index, an int
    //Return value(s):  a generic type
    //Partners:		Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Returns the element at the given index
    public E get(int index) throws EmptyListException, IndexOutOfBoundsException
    {
        if(numElements == 0)
        {
            throw new EmptyListException();
        }
        else if(index > numElements - 1 || index < 0)
        {
            throw new IndexOutOfBoundsException(name);
        }
        else
        {
            ListNode current = firstNode;
            for(int i = 0; i < index; i++)
            {
                current = current.getNext();
            }
            E gotten = (E)current.getData();
            return gotten;
        }
    }

    //Method Name:      findAndRemove
    //Parameters:       item, a generic type
    //Return value(s):  a Boolean
    //Partners:		Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Tries to find the passed item. If found, removes; if not, returns false
    public Boolean findAndRemove(E item) throws EmptyListException
    {
        ListNode current = firstNode;
        ListNode temp = null;
        int index = -1;
        if (numElements == 0)
        {
            throw new EmptyListException();
        }
        else
        {
            for(int i = 0; i < numElements; i++)
            {
                if(current.getData() == item)
                {
                    temp = current;
                    index = i;
                }
                current = current.getNext();
            }
            if(index != -1)
            {
                remove(index);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    //Method Name:      findItem
    //Parameters:       item, a generic type
    //Return value(s):  an int
    //Partners:		Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Tries to find the passed item. If found, returns index; if not, returns -1
    public int findItem(E item)
    {
        ListNode current = firstNode;
        int temp = -1;
        for(int i = 0; i < numElements; i++)
        {
            if(current.getData() == item)
            {
                temp = i;
            }
            current = current.getNext();
        }
        return temp;
    }
    //Method Name:      lengthIs
    //Parameters:       none
    //Return value(s):  an int
    //Partners:		none
    //Description:      Returns the number of elements
    public int lengthIs()
    {
        return numElements;
    }

    //Method Name:      clear
    //Parameters:       none
    //Return value(s):  none
    //Partners:		none
    //Description:      Removes all elements from list
    public void clear()
    {
        firstNode = null;
        lastNode = null;
        numElements = 0;
        //System.out.println("clear");
    }

    //Method Name:      print
    //Parameters:       none
    //Return value(s):  none
    //Partners:		Casey Largent, caseylargent@unomaha.edu
    //Description:      If list is empty, prints message. Otherwise, prints formatted list
    public void print()
    {
        if(numElements == 0)
        {
            System.out.printf("Empty %s\n", name);
        }
        else
        {
            System.out.printf("The list %s is: ", name);
            ListNode current = firstNode;
            E item = null;
            for(int i = 0; i < numElements; i++)
            {
                item = (E)current.getData();
                System.out.printf("%s ", item);
                current = current.getNext();
            }
            System.out.println();
        }
    }

    //Method Name:      isEmpty
    //Parameters:       none
    //Return value(s):  a Boolean
    //Partners:		none
    //Description:      Returns true if empty, false if not
    public Boolean isEmpty()
    {
        if(numElements == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
