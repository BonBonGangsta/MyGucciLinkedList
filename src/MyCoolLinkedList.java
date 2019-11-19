
public class MyCoolLinkedList<E> {
    
    private Node head; 
    private Node iterator;
    
    public MyCoolLinkedList()
    {
        head = null;
    }
    
    
    //------- Main methods to be used----------\\
    
     public void clear()
    {
        head = null;
    }
    
    private Node lastNode()
    {
        if (head == null)       
        {
            return null;        
        } 
        else
        {
            Node temp = head;
            while (temp.next != null)
            {
                temp = temp.next;
            }
            return temp;
        }
    }
    
     public void append(E x)
    {
        // create new Node with "info" member pointing to x
        Node temp = new Node(x);

        if (head == null)           // if list is empty...
        {
            head = temp;            // ...put new Node at head of list.
        } 
        else                        // if non-empty...
        {
            lastNode().next = temp; // ...append new node to end of list
        }
    }
    
    
     // ------------- submethods ---------------\\
     
     
    /**
     * Defining the Node class
     */
    
    class Node // note: "package" access (no specifier)
    {
        E info;     // each node stores an object of a class to be
                    // determined later...
        Node next;  // ...and a pointer to another node

        // Create a Node object 
        Node(E x) // constructor takes one param of class E
        {
            info = x;       // set info portion to parameter passed
            next = null;    // not necessary, null is default value
        }
    }
}
