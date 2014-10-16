import java.util.*;

public class SinglyLinkedListDriver
{
   public static void main(String[] args)
   {
      SinglyLinkedList<String> list = new SinglyLinkedList<String>();
      list.add("Eric");
      list.add("Chris");
      list.add("Demario");
      System.out.println( list.get(0) );
      System.out.println( list.get(1) );
      System.out.println( list.get(2) );
      Iterator<String> itr = list.iterator();
      itr.next();
      itr.next();
      itr.remove();
      System.out.println( list.get(0) );
      System.out.println( list.get(1) );
   }
}