import java.util.*;

public class ArrayCollection<E> implements Collection<E>
{  
  // Note: null elements are not allowed in an ArrayCollection  
  
  protected E[] myStorage; // an array to hold the elements
  
  protected int mySize;    // the number of elements currently stored
    
  
  /**
   *  Creates an empty ArrayCollection, with room for 10 elements.
   */
  public ArrayCollection()
  {
    
    myStorage = (E[]) new Object [10];
    mySize = 0;
  } // constructor
  

  /**
   *  Returns a String representation of this ArrayCollection object.
   *
   *  @return - a String representation of this ArrayCollection object.
   *
   */
  public String toString()
  {
      String result = "";

      for (int i = 0; i < mySize; i++)
          result += myStorage [i] + "\n";
      return result;
  } // method toString

  
  /**
   *  Checks if this ArrayCollection object is empty.
   * 
   *  @return a boolean indicating whether this ArrayCollection object is empty or not.
   */
  public boolean isEmpty() 
  {
    return mySize == 0;
  } // method isEmpty
  
  
  /**
   *  Checks if this ArrayCollection object contains a certain element.
   * 
   *  @param obj an Object that will be checked for.
   * 
   *  @return a boolean indicating whether this ArrayCollection object contains 
   *          obj.
   */
  public boolean contains (Object obj) 
  {
    for (int i = 0; i < mySize; i++)
        if (obj.equals (myStorage [i]))
            return true;
    return false;
  } // method contains
  
  
  /**
   *  Adds an element to this ArrayCollection object.
   * 
   *  @param element -  a reference of type E that will be added  
   *         to this ArrayCollection object.
   * 
   *  @return true 
   */
  public boolean add (E element) 
  {    
    if (mySize == myStorage.length) 
    {
        E[] temp = (E[]) new Object [2 * mySize]; // allow room for growth
        System.arraycopy (myStorage, 0, temp, 0, mySize);      
        myStorage = temp;
    } // if ArrayCollection occupies all of myStorage
    myStorage [mySize++] = element;
    return true;
  } // method add
  
  
  /**
   *  Empties this ArrayCollection object of all elements.
   */
  public void clear() 
  {
    myStorage = (E[]) new Object [10];
    mySize = 0;
  } // method clear
  
  
  /**
   *  Returns the size of this ArrayCollection object.
   * 
   *  @return an int containg the size of the ArrayCollection.
   */
  public int size() 
  {
    return mySize;
  } // method size
  
  
  public Iterator<E> iterator() 
  {
    throw new UnsupportedOperationException();    
  }
  
  public Object[] toArray() 
  { 
    throw new UnsupportedOperationException();
  }  
  
  
  public <T> T[] toArray(T[] a) 
  {   
    throw new UnsupportedOperationException();    
  }  
  
  
  public boolean remove(Object obj) 
  {   
    throw new UnsupportedOperationException();    
  }  
  
  
  public boolean containsAll(Collection<?> c) 
  {     
    throw new UnsupportedOperationException();    
  }  
  
  
  public boolean addAll(Collection<? extends E> c) 
  {     
    throw new UnsupportedOperationException();    
  }  
  
  
  public boolean removeAll(Collection<?> c) 
  {    
    throw new UnsupportedOperationException();    
  }  
  
  
  public boolean retainAll(Collection<?> c) 
  {     
    throw new UnsupportedOperationException();    
  }  
  
  public boolean equals(Object obj) 
  {     
    throw new UnsupportedOperationException();    
  } // method equals
  
  
  public int hashCode() 
  {     
    throw new UnsupportedOperationException();    
  }  
  
} // class ArrayCollection