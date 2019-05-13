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
//	        	Sweety Goenka, sgoenka@unomaha.edu
//Description:  implements an ArrayList capable of handling any type as long as type inherits from hasKey class
//
import java.lang.reflect.Array;
public class ArrayList <E extends hasKey>
//correct?
{
    private final int DEFCAP = 50;
    private int origCap;
    private int numElements;
    private E[] list;
    private Class<E> elementType;
    //correct?

    //Method Name:      ArrayList
    //Parameters:       et, a generic class
    //Return value(s):  a generic type
    //Partners:	    	Casey Largent, caseylargent@unomaha.edu
    //	            	Marcus Mallum, mmmallum@unomaha.edu
    //	            	Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Constructor. Sets origCap to DEFCAP
    public ArrayList(Class<E> et)
        //correct?
    {
        origCap = DEFCAP;
        numElements = 0;
        elementType = et;
        list = (E[]) Array.newInstance(elementType, origCap);
        //correct?
    }

    //Method Name:      ArrayList
    //Parameters:       size, an int; et, a generic class
    //Return value(s):  a generic type
    //Partners:	    	Casey Largent, caseylargent@unomaha.edu
    //	            	Marcus Mallum, mmmallum@unomaha.edu
    //	            	Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Constructor. Throws exception if size passed is greater then DEFCAP
    public ArrayList (Class<E> et, int size) throws Exception
        //correct?
    {
        if (size <= DEFCAP)
        {
            elementType = et;
            numElements = 0;
            origCap = size;
            list = (E[]) Array.newInstance(et, origCap);
        }
        else
        {
            Exception e = new Exception();
            throw e;
        }
    }

    //Method Name:      addItem
    //Parameters:       item, a generic type
    //Return value(s):  a Boolean
    //Partners:	    	Casey Largent, caseylargent@unomaha.edu
    //      	    	Marcus Mallum, mmmallum@unomaha.edu
    //	            	Sweety Goenka, sgoenka@unomaha.edu
    //Description:      If list is at capacity, enlarges list. Whether it is or not, insert given item at end of list
    public Boolean addItem(E item)
    {
        try
        {
            if(numElements >= list.length)
            {
                enlarge();
            }
        }
        catch (Exception e)
        {
            return false;
        }
        list[numElements] = item;
        numElements++;
        return true;
    }

    //Method Name:      removeItem
    //Parameters:       item, a generic type
    //Return value(s):  a Boolean
    //Partners:	    	Casey Largent, caseylargent@unomaha.edu
    //  	        	Marcus Mallum, mmmallum@unomaha.edu
    //	    	        Sweety Goenka, sgoenka@unomaha.edu
    //Description:      if item not found, return false; if found, move last item to that spot so to delete it
    public Boolean removeItem(E item)
    {
        int i = findItem(item);

        if (i != -1)
        {
            list[i] = list[numElements - 1];
            list[numElements - 1] = null;
            numElements--;
            return true;
        }
        else
        {
            return false;
        }
    }

    //Method Name:      findItem
    //Parameters:       item, a generic type
    //Return value(s):  an int
    //Partners:	    	Casey Largent, caseylargent@unomaha.edu
    //  	        	Marcus Mallum, mmmallum@unomaha.edu
    //	            	Sweety Goenka, sgoenka@unomaha.edu
    //Description:      Search array for given item
    public int findItem(E item)
    {
        for(int i = 0; i < lengthIs(); i++)
        {
            if(list[i].equals(item))
            {
                return i;
            }
        }
        return -1;
    }

    //Method Name:      findItemByKey
    //Parameters:       key, an int
    //Return value(s):  an int
    //Partners:	    	Casey Largent, caseylargent@unomaha.edu
    //	            	Marcus Mallum, mmmallum@unomaha.edu
    //	            	Sweety Goenka, sgoenka@unomaha.edu
    //Description:      finds position that shares the passed key
    public int findItemByKey(int key)
    {
        for(int i = 0; i < lengthIs(); i++)
        {
            if(list[i].getKey() == key)
            {
                return i;
            }
            //correct else - if item not in list
        }
        return -1;
    }

    //Method Name:      isEmpty
    //Parameters:       none
    //Return value(s):  a Boolean
    //Partners: 		Casey Largent, caseylargent@unomaha.edu
    //	            	Marcus Mallum, mmmallum@unomaha.edu
    //	            	Sweety Goenka, sgoenka@unomaha.edu
    //Description:      checks if list is empty
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

    //Method Name:      lengthIs
    //Parameters:       none
    //Return value(s):  an int
    //Partners:	    	Casey Largent, caseylargent@unomaha.edu
    //	            	Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      return the number of items
    public int lengthIs()
    {
        return numElements;
    }

    //Method Name:      clear
    //Parameters:       none
    //Return value(s):  none
    //Partners:		    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      clears list
    public void clear()
    {
        if(list.length > origCap)
        {
            E temp[] = (E[]) Array.newInstance(elementType, origCap);
            //correct?
            list = temp;
            //correct order?
        }
        numElements = 0;
    }

    //Method Name:      get
    //Parameters:       index, an int
    //Return value(s):  a generic type
    //Partners:		    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      retrieve item at the index given; throws exception if not found
    public E get(int index) throws Exception
        //correct?
    {
        if(lengthIs() >= index)
        {
            return list[index];
        }
        else
        {
            Exception e = new Exception("Index out of Range");
            throw e;
        }
    }

    //Method Name:      toString
    //Parameters:       none
    //Return value(s):  a string
    //Partners:		    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      return a string of all elements in list
    public String toString()
    {
        String s = new String("");
        for(int i = 0; i < lengthIs(); i++)
        {
            s += list[i] + "\n\n";   
        }
        return s;
    }

    //Method Name:      enlarge
    //Parameters:       none
    //Return value(s):  none
    //Partners:		    Casey Largent, caseylargent@unomaha.edu
    //		            Marcus Mallum, mmmallum@unomaha.edu
    //		            Sweety Goenka, sgoenka@unomaha.edu
    //Description:      enlarge array as long as it is less than max size
    private void enlarge() throws Exception
    {
        if (lengthIs() >= DEFCAP)
        {
            Exception a = new Exception("Already at max capacity");
            throw a;
        }
        else if (origCap + lengthIs() <  DEFCAP)
        {
            E[] larger = (E[]) Array.newInstance(elementType, lengthIs() + origCap);

            for(int i = 0; i < list.length; i++)
            {
                larger[i] = list[i];
            }
            list = larger;
            //correct order?
        }
        else 
        {
            E[] larger = (E[]) Array.newInstance(elementType, DEFCAP);

            for(int i = 0; i < list.length; i++)
            {
                larger[i] = list[i];
            }
            list = larger;
            //correct order?
        }


    }

}
