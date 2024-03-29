import java.util.*;

public class SinglyLinkedList<E> 
{
  protected Entry<E> head;  // reference to the first entry in the list                     
  protected transient int size;
  
  /**
   * Initializes this SinglyLinkedList object to be empty, with elements to be of 
   * type E.
   */
  public SinglyLinkedList()
  {
    head = null;
    size = 0;
  } // constructor
  
  
  /**
   *  Determines if this SinglyLinkedList object has no elements.
   *
   *  @return true -  if this SinglyLinkedList object has no elements; otherwise,
   *                          false.  
   */
  public boolean isEmpty ()  
  {
    return head == null;
  } // method isEmpty
  
  
  /**
   *  Adds a specified element to the front of this SinglyLinkedList object.
   *
   *  @param element - the element to be appended.   
   *
   */
  public void addToFront (E element) 
  {
    Entry<E> newEntry = new Entry<E>();
    newEntry.element = element;
    newEntry.next = head;
    head = newEntry;  
    size++;   
  } // method addToFront
  
  public void add( E element )
  {
      Entry<E> newEntry = new Entry<E>();
      newEntry.element = element;
      newEntry.next = null;
      
      if ( head == null )
      {
         head = newEntry;
      }
      else
      {
         Entry<E> current = head;
         while ( current.next != null )
         {
            current = current.next;
         }

         current.next = newEntry;
      }
      
      size++;
  }
  
  /**
   *  Returns a SinglyLinkedListIterator object to iterate over this
   *  SinglyLinkedList object.
   *
   */  
  public Iterator<E> iterator()
  {
    return new SinglyLinkedListIterator();
  } // method iterator
  
  
  /**  
   *  Determines the number of elements in this SinglyLinkedList object.
   *  The worstTime(n) is O(n).
   *
   *  @return the number of elements.
   */
  public int size() 
  {
    return size;
  } // method size
  
  
  /** 
   *  Determines if this SinglyLinkedList object contains a specified element.
   *  The worstTime(n) is O(n).
   *
   *  @param obj - the specified element being sought.
   *
   *  @return true - if this SinglyLinkedList object contains element; otherwise,
   *                false. 
   *
   */
  public boolean contains (Object obj) 
  {
    if (obj == null)
    {
      for (Entry<E> current = head; current != null; current = current.next)
        if (obj == current.element)
          return true;
    } // if obj == null
    else   
      for (Entry<E> current = head; current != null; current = current.next)
        if (obj.equals (current.element))
          return true;
    return false;
  } // method contains    

  public E get(int index)
  {
    if ( index < 0 || index >= size() )
    {
      throw new NoSuchElementException();
    }
    
    Entry<E> current = head;
    for ( int count = 0; count < index; count++ )
    {
      current = current.next;
    }
    
    return current.element;
  }
  
  public String toString()
  {
   String result = "";
   
   Iterator<E> iterator = iterator();
   
   while ( iterator.hasNext() )
   {
      result += iterator.next().toString();
   }
   return result;
  }

  protected class SinglyLinkedListIterator implements Iterator<E> 
  {
    protected Entry<E> previous, lastReturned, next;
    
    /**
     *  The iterator has been initialized.
     */
    protected SinglyLinkedListIterator() 
    {
      next = head;
    } // constructor
    
    
    /** 
     *  Returns the element this Iterator object was (before this call) 
     *  positioned at, and advances this Iterator object.
     *                    
     *  @return - the element this Iterator object was positioned at.
     *
     *  @throws NoSuchElementException � if this Iterator object was
     *                 not postioned at an element before this call.
     */                            
    public E next() 
    {
      if ( lastReturned != null )
      {
         previous = lastReturned;
      }
      lastReturned = next;
      next = next.next;
      
      return lastReturned.element;
      
    } // method next
    
    
    /**
     *  Determines if this Iterator object is positioned at an element in this
     *  Collection.
     *
     *  @return true - if this Iterator object is positioned at an element; 
     *                otherwise, false.                        
     */                   
    public boolean hasNext() 
    {       
      return next != null;
    } // method hasNext
    
    /**
     *  Removes the element returned by the most recent call to next().
     *  The behavior of this Iterator object is unspecified if the underlying 
     *  collection is modified ( while this iteration is in progress) other than 
     *   by calling this remove() method.
     *
     *  @throws IllegalStateException - if next() had not been called before
     *                 this call to remove(), or if there had been an intervening call 
     *                 to remove() between the most recent call to next() and this 
     *                 call.
     **/
    public void remove() 
    { 
      if ( lastReturned == null )
      {
         throw new IllegalStateException();
      }
      
      if ( previous == null )
      {
         head = next;
      }
      else
      {
         previous.next = next;
      }
      
      lastReturned = null;
      size--;
    }
    
  } // class SinglyLinkedListIterator
  
  
  protected class Entry<E>
  {
    protected E element;
    protected Entry<E> next;
    
  } // class Entry
  
} // class SinglyLinkedList
