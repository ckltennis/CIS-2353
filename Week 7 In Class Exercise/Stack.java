import java.util.*;

public class Stack<E>
{
   ArrayList<E> data;
   
   public Stack()
   {
      data = new ArrayList<E>();
   }
   
   public E push(E element)
   {
      data.add(element);
      return element;
   }
   
   public E pop()
   {
      checkForEmpty();
      
      return data.remove(data.size() - 1);
   }
   
   public E peek()
   {
      checkForEmpty();
      
      return data.get(data.size() - 1); 
   }
   
   private void checkForEmpty()
   {
      if ( data.size() == 0 )
      {
         throw new EmptyStackException();
      }
   }
}