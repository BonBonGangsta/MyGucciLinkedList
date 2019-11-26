/*
    I affirm that this program is entirely my own work and none 
    of it is the work of any other person.
	
        ___________________
	Byron De Paz
        3999061

 */
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
            Node tracer = head;
            while (tracer.next != null)
            {
                tracer = tracer.next;
            }
            tracer.next = temp;    
        }
    }
     
    public void delete(int key)
    {  
       // if the head is null, the list is empty, no point deleting anything.
       if(head == null)
       {
           return;
       }
       if (key == 1)
       {
           head = head.next;
       }
       else
       {
           // we need a temporary node to traverse the beyond...
           Node temp = head;
           // keep going through each iteration until we reach the node
           // before the index -1
           for (int counter = 2; counter < key; counter++ )
           {
              // move temp to what ever the next one is pointing to.
              temp = temp.next;
    
           }
            //by now the temp node will have gotten in position of the node
            // right before the node we need to delete, so we pull it off in one 
            // line
            // we assign the next pointer to the same pointer to the 
            // the pointer the next Node was pointing to in its next.
            temp.next = temp.next.next; // super risky though
       }
    }
    
    public void addNode(int index, E x)
    {
        if(head == null)
       {
           this.append(x);
       }
       if (index == 1)
       {
           Node temp = head;
           Node newN = new Node(x);
           newN.next = head;
           head = newN;
       }
       else
       {
        // to add an node after an index, use a for loop to get to the
        // node before the index given.
        Node temp = head;
        for (int counter = 2; counter < index; counter++ )
        {
            temp = temp.next; // keep going through the list
        }
        // create the node of x
        Node newN = new Node(x);
        // assign the next pointer of the new node to the node
        // temp is pointing to
        newN.next = temp.next;
        // now have temp point to the new node.
        temp.next = newN;
       }
    }
    
    public void swapNodes(int dis, int dat)
     {  
        int later = 0;
        int sooner = 0;
        // check which one is later in the LL and which one comes sooner
        if (dis < dat)
        {
            sooner = dis;
            later = dat;
        }
        if (dis > dat)
        {
            sooner = dat;
            later = dis;
        }
        // if the head is null, the list is empty, no point swapping anything.
        if(head == null)
        {
            return;
        }
        // we need a Two temporary node to traverse the beyond...
        Node swap1 = head;
        Node swap2 = head;
        boolean found = false;
        while(!found)
        {
        // keep going through each iteration until we reach the node
        // before the index -1 of the furthest key passed.
        // Why? you may ask, well it's pretty simple, if the later index
        // exists, than the one before is bound to exist.
        for (int counter = 1; counter < later; counter++ )
        {
           // move temp to what ever the next one is pointing to.
           swap1 = swap1.next;
           // check to see if the node is pointing to anything after
           if (swap1 == null || swap1.next == null)
           {
            // if temp is now null, that means we reached the end, and they
            // gave a key index greater than the size of the of the LL
            return;
           }
        }
        found = true;
        for (int counter = 1; counter < sooner; counter++ )
          {
           // move temp to what ever the next one is pointing to.
           swap2 = swap2.next;
          }
        }
        if(found)
        {
            Node swapTemp = swap1;
            swap1.next = swap2.next;
            swap2.next = swapTemp.next;
        }  
     }
    
    public void reverse()
    {
        if (head != null)
        {
            // we are going to a few notes to traverse the LL
            Node current = head.next;
            Node previous = null;
            Node next = null;
            while (current != null)
            {
                next = current.next;
                current.next = previous;
                current = next;
            }
            this.head = previous;
        }
    }
    
    public String toString()
    {
        String out = "";
        Node temp = head; 		// start at head of list 
        while (temp != null)            // while more nodes on list...
        {
            out += temp.info + " ";	// ...append current obj
            temp = temp.next;		// ...and move to next node
        }
        return out;
    }
     // ------------- submethods ---------------\\
       public boolean more()
    {
        return iterator.next != null;
    }
     
        public E next()
    {
        iterator = iterator.next;	// move to next node...	
        return iterator.info;		// ...return object stored there
    }
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
