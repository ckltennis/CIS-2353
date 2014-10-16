import java.util.*;

public class Stack<E>
{
   LinkedList<E> data;
   
   public Stack()
   {
      data = new LinkedList<E>();
   }
   
   public E push(E element)
   {
      data.add(element);
      return element;
   }
   
   public E pop()
   {
      checkForEmpty();
      
      return data.removeLast();
   }
   
   public E peek()
   {
      checkForEmpty();
      
      return data.getLast(); 
   }
   
   private void checkForEmpty()
   {
      if ( data.size() == 0 )
      {
         throw new EmptyStackException();
      }
   }
}