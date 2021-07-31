public class MyCoolLinkedList<E> {
    
    private Node head; 
    private Node iterator;
    
    /**
     * create a linked list that is empty.
     */
    public MyCoolLinkedList()
    {
        head = null;
    }
    
    /**
     * clear the linked list for which this is called for.
     */
    public void clear()
    {
        head = null;
    }
    
    /**
     * append the object at the end of the linked list.
     * @param x object to which append
     */
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
            // get to the last node
            while (tracer.next != null)
            {
                tracer = tracer.next;
            }
            // have the next of the last node point to the new node
            tracer.next = temp;    
        }
    }
    
    /**
     * delete the node at a certain key index.
     * @param key key index to which delete the node from.
     */
    public void delete(int key)
    {  
       // if the head is null, the list is empty, no point deleting anything.
       if(head == null)
       {
           return;
       }
       if (key == 1)
       {
           // if the node to delete is the first one, have the head point
           // to the next one.
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
    
    /**
     * add a node at a specific index.
     * @param index index to insert the new object as a node.
     * @param x the Object to which needs to be inserted.
     */
    public void addNode(int index, E x)
    {
        if(head == null)
       {
           // if the list is empty, you're really just appending.
           this.append(x);
       }
        // if the index is one, have the new node point to the what the head
        // is pointing to, and then the head to the new node.
       if (index == 1)
       {
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
    
    /**
     * swap the nodes at two indexes. indexes can be given in any order
     * @param dis the first index.
     * @param dat the second index.
     */
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
        if (dis == dat)
        {
            return; // nothing to do
        }
        // if the head is null, the list is empty, no point swapping anything.
        if(head == null)
        {
            return;
        }
        // we need a four temporary node to traverse the beyond...
        Node swap1 = head;
        Node swap2 = head;
        Node swap1prev = null;
        Node swap2prev = null;
        boolean found = false;
        while(!found)
        {
        // keep going through each iteration until we reach the node
        // before the index -1 of the furthest key passed.
        // Why? you may ask, well it's pretty simple, if the later index
        // exists, than the one before is bound to exist.
        for (int counter = 1; counter < later; counter++ )
        {
           // point the previous one to the node
            swap1prev = swap1;
           // move temp to what ever the next one is pointing to.
           swap1 = swap1.next;
        }
        found = true;
        for (int counter = 1; counter < sooner; counter++ )
          {
           // point the previous one to the node
           swap2prev = swap2;
           // move temp to what ever the next one is pointing to.
           swap2 = swap2.next;
          }
        }
        if(found)
        {
            if (swap1 != null && swap2 != null)
            {
                // if the previous is not null, then use point to it
                if(swap1prev != null)
                    swap1prev.next = swap2;
                else // swap1 is the first element
                    head = swap2;
                // if the second node previous is not null point to it
                if (swap2prev !=null)
                    swap2prev.next = swap1;
                else
                    head = swap1;
                
                // swap
                Node tempNode = swap1.next;
                swap1.next = swap2.next;
                swap2.next = tempNode;
            }
           
        }
     }
    
    /**
     * reverse the list for which this method is called for.
     */
    public void reverse()
    {
        if (head != null)
        {
            // create two start points for the start and end of the LL
            Node start = head.next;
            Node reverse = head;
            // start resetting the head
            reverse.next = null;
            // while there is still nodes
            while(start != null)
            {
                // create a temporary start
                Node temp = start;
                start = start.next; // move to the next
                
                temp.next = reverse; // temp points to reverse
                reverse = temp; // reverse is now the temp.
            }
            head = reverse;
        }
    }
    
    /**
     * Generate a String of all objects in the list for which this is called
     * for.
     * @return String generated.
     */
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
