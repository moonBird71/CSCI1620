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
//
//Description:  Creates a Node in a LinkedList
//
public class ListNode<E>
{
    private E data;
    private ListNode<E> nextNode;

    //Method Name:      ListNode
    //Parameters:       d, a generic type
    //Return value(s):  none
    //Partners:		none
    //Description:      Constructor. Sets nextNode to null
    //                  stackoverflow.com/question/15792682/delete-last-node-of-a-linked-list
    public ListNode(E d)
    {
        data = d;
        nextNode = null;
    }

    //Method Name:      ListNode
    //Parameters:       d, a generic type; node, a ListNode
    //Return value(s):  none
    //Partners:     	none
    //Description:      Constructor. Sets the next node reference
    public ListNode(E d, ListNode<E> node)
    {
        data = d;
        nextNode = node;
    }

    //Method Name:      setData
    //Parameters:       d, a generic type
    //Return value(s):  none
    //Partners:		none
    //Description:      Sets passed data to local variable
    public void setData(E d)
    {
        data = d;
    }

    //Method Name:      getData
    //Parameters:       none
    //Return value(s):  a generic type
    //Partners:		none
    //Description:      Returns the data stored in the node
    public E getData()
    {
        return data;
    }

    //Method Name:      setNext
    //Parameters:       next, a ListNode
    //Return value(s):  none
    //Partners:		none
    //Description:      Sets the next node reference
    public void setNext(ListNode<E> next)
    {
        nextNode = next;
    }

    //Method Name:      getNext
    //Parameters:       none
    //Return value(s):  a ListNode
    //Partners:		none
    //Description:      Returns the next node reference
    public ListNode<E> getNext()
    {
        return nextNode;
    }

}
