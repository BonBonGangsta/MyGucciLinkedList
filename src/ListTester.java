/*
    I affirm that this program is entirely my own work and none 
    of it is the work of any other person.
	
        ___________________
	Byron De Paz
        3999061

 */
import java.io.IOException ;
import java.io.File ;
import java.util.Scanner ;

public class ListTester {

   public static void main(String[] args) throws IOException
   {
       // create a linked list called Tomas, after the engine that could
       MyCoolLinkedList thomas = new MyCoolLinkedList();
       
       // Create the scanner file with the input file as the source
       Scanner fileScan = new Scanner(new File(".\\list-ops.txt"));
       
       // let the user know the input has been recieved
       System.out.println("The input file has been accepted");
       
       // start the while loop to read the file until the end of file
       while (fileScan.hasNext())
       {
           //create the instance to hold the action that will take place
           String listAction = fileScan.next();
           // here we start the an if statement to see what action
           // must be completed on the list, such as append, delete, etc.
           if (listAction.equals("APPEND"))
           {
               int input = fileScan.nextInt();
               thomas.append(input);
           }
           // if the action is add
           if(listAction.equals("ADD"))
           {
               int index = fileScan.nextInt(); // index to replace
               int value = fileScan.nextInt(); // value to add
               thomas.addNode(index, value); // pass them to thomas
           }
           // if the action is delete
           if(listAction.equals("DELETE"))
           {
               thomas.delete(fileScan.nextInt()); // pass the index to delete
           }
           // if action is swap
           if(listAction.equals("SWAP"))
           {
               int firstIndex = fileScan.nextInt(); // index1 to swap
               int secondIndex = fileScan.nextInt(); // index2 to swap
               thomas.swapNodes(firstIndex, secondIndex); // pass them along
           }
           if(listAction.equals("REVERSE"))
           {
               thomas.reverse(); // thomas will reverse the list
           }
           if (listAction.equals("CLEAR"))
           {
               thomas.clear(); // clear list
           }
           System.out.println(thomas.toString()); // print the list
       }
       System.out.println("The end of file has been reached.");
   }
}
