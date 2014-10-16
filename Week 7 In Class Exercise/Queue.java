import java.util.*;

public class Queue<E>
{
   LinkedList<E> data;
   
   public Queue()
   {
      data = new LinkedList<E>();
   }
   
   public E remove()
   {
      checkForEmpty();
      
      return data.removeFirst();
   }
   
   public boolean add(E element)
   {
      data.add(element);
      
      return true;
   }
   
   public E element()
   {
      checkForEmpty();
      
      return data.getFirst();
   }
   
   private void checkForEmpty()
   {
      if ( data.size() == 0 )
      {
         throw new NoSuchElementException();
      }
   }
}