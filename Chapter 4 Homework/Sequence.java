import java.util.*;

public class Sequence<E> implements Collection<E>
{
   private static final int DEFAULT_SIZE = 10;
   
   protected E[] data;
   protected int size = 0;
   
   public Sequence()
   {
      data = (E[]) new Object[DEFAULT_SIZE];
   }
   
   public Sequence( int n )
   {
      if ( n < 1 )
      {
         throw new IllegalArgumentException();
      }
      data = (E[]) new Object[n];
   }
   
   public int size()
   {
      return size;
   }
   
   public void append( E element )
   {
      if ( size == data.length )
      {
         E[] newData = (E[]) new Object[ size * 2 ];
         System.arraycopy( data, 0, newData, 0, size );
         data = newData;
      }
      data[size] = element;
      size++;
   }
   
   public E get( int index )
   {
      checkForValidIndexAndThrowExceptionIfInvalid(index);
      
      return data[index];
   }
   
   public void set( int index, E newElement )
   {
      checkForValidIndexAndThrowExceptionIfInvalid(index);
      
      data[index] = newElement;
   }
   
   private void checkForValidIndexAndThrowExceptionIfInvalid( int index )
   {
      if ( index < 0 || index >= size )
      {
         throw new IndexOutOfBoundsException();
      }
   }
}