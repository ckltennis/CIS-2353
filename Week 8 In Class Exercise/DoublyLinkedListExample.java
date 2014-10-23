import java.util.*;

public class DoublyLinkedListExample
{
   public static void main(String[] args)
   {
      DoublyLinkedList<String> linkedList = new DoublyLinkedList<String>();
      linkedList.add("Eric");
      linkedList.add("Demario");
      linkedList.add("Heather");
      linkedList.addToFront("Robert");
      
      ListIterator<String> iterator = linkedList.listIterator();
      
      while( iterator.hasNext() )
      {
         System.out.println( iterator.next() );
      }
      
      while( iterator.hasPrevious() )
      {
         System.out.println( iterator.previous() );
      }
      
      iterator.remove();
   }
}