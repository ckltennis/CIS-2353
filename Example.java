import java.util.*;

public class Example
{
   public static void main(String[] args)
   {
   LinkedList<String> myList = new LinkedList<String>();
   myList.add ("t");
   myList.add ("h");
   myList.add ("i");
   myList.add ("q");
   myList.add ("r");
   myList.add (2, "m");
   myList.remove (4);
   ListIterator<String> itr = myList.listIterator (3);
    itr.previous();
    itr.add ("g");
    itr.next();
    itr.remove();
    itr = myList.listIterator (myList.size());
    while (itr.hasPrevious())
        	    System.out.println (itr.previous());
  


   }
}