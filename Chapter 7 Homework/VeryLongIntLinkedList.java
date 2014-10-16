import java.util.*;

public class VeryLongIntLinkedList
{
    protected LinkedList<Integer> digits;
       
    /** 
     *  Initializes this VeryLongInt object from the digit characters in a given String object.  
     *  The worstTime(n) is O(n), where n represents the number of characters in s.  There
     *  are no leading zeroes, except for 0 itself, which has a single '0'.
     *
     *  @param s - the given String object.
     *
     *  @throws NullPointerException - if s is null.
     *  @throws IllegalArgumentException - if s contains no digit characters.
     *
     */  
    public VeryLongIntLinkedList (String s) 
    {
        final char LOWEST_DIGIT_CHAR = '0';

        digits = new LinkedList<Integer> ();

        char c;

        int digit;
        
        boolean atLeastOneDigit = false;

        for (int i = 0; i < s.length(); i++) 
        {
            c = s.charAt (i);
            if (Character.isDigit(c))
            {
                digit = c - LOWEST_DIGIT_CHAR;
                digits.add (digit);   // digit is boxed to an Integer object
                atLeastOneDigit = true;
            } //  if a digit
        } // for
        if (!atLeastOneDigit)
            throw new IllegalArgumentException();            
    } // constructor with string parameter
    
    
    public VeryLongIntLinkedList( int n )
    {
      if ( n <= 0 )
      {
         throw new IllegalArgumentException();
      }
      
      digits = new LinkedList<Integer>();
      
      for ( double factor = 10; factor <= n * 10.0; factor *= 10 )
      {
         digits.addFirst( (int) ( ( n % factor ) / ( factor / 10 ) ) );
      }
    }


    /** Returns a String representation of this VeryLongInt object. The worstTime(n) is 
     *  O(n), where n represents the number of digits in this VeryLongInt object. 
     *
     *  @return a String representation of this VeryLongInt object in the form 
     *  [ followed by the digits, separated by commas and single spaces, followed
     *  by ].
     *
     */ 
    public String toString() 
    {
        return digits.toString();
    } // method toString
 

    /** 
     *  Increments this VeryLongInt object by a specified VeryLongInt object.
     *  The worstTime(n) is O(n), where n is the number of digits in the larger of this 
     *  VeryLongInt object (before the call) and the specified VeryLongInt object.
     *
     *  @param otherVeryLong - the specified VeryLongInt object to be added to
     *                         this VeryLongInt object.
     *
     *  @throws NullPointerException - if otherVeryLong is null.
     *
     */  
    public void add (VeryLongIntLinkedList otherVeryLong) 
    {
        final int BASE = 10;

        int largerSize,
            partialSum,
            carry = 0;
  
        if (digits.size() > otherVeryLong.digits.size())
            largerSize = digits.size();
        else
            largerSize = otherVeryLong.digits.size();

        LinkedList<Integer> sumDigits = new LinkedList<Integer>();
         
        ListIterator<Integer> digitsIterator = digits.listIterator(digits.size());
        ListIterator<Integer> otherVeryLongIterator = otherVeryLong.digits.listIterator(otherVeryLong.size());        
         
        for (int i = 0; i < largerSize; i++) 
        {
            partialSum = least (digitsIterator) + otherVeryLong.least (otherVeryLongIterator) + carry;
            carry  = partialSum / BASE;
            sumDigits.addFirst (partialSum % BASE);
        } // for

        if (carry == 1)
            sumDigits.addFirst (carry);
        digits = sumDigits;        
 } // method add


    /** Returns the ith least significant digit in digits if i is a non-negative int less than
     *  digits.size().  Otherwise, returns 0.
     *
     *  @param i - the number of positions from the right-most digit in digits to the 
     *                 digit sought.
     *
     *  @return the ith least significant digit in digits, or 0 if there is no such digit.
     *
     *  @throws IndexOutOfBoundsException - if i is negative.
     * 
     */
    protected int least (ListIterator<Integer> iterator) 
    {
        if (iterator.hasPrevious() )
            return iterator.previous();
        return 0;
    } // least
    
    protected int size()
    {
      return digits.size();
    }
    
    // protected boolean less( VeryLongIntLinkedList otherVeryLongInt )
//     {
//       if ( otherVeryLongInt == null )
//       {
//          throw new NullPointerException();
//       }
//       boolean isLess = true;
//       
//       if ( size() > otherVeryLongInt.size() )
//       {
//          isLess = false;
//       }
//       else if ( size() == otherVeryLongInt.size() )
//       {
//          for ( int digit = size() - 1; isLess && digit >= 0; digit-- )
//          {
//             if ( least(digit) > otherVeryLongInt.least(digit) )
//             {
//                isLess = false;
//                digit = -1;
//             }
//             else if ( least(digit) < otherVeryLongInt.least(digit) )
//             {
//                digit = -1;
//             }
//             if ( isLess && digit == 0 )
//             {
//                isLess = false;
//             }
//          }
//       }
//       
//       return isLess;
//     }
//     
//     protected boolean greater( VeryLongIntLinkedList otherVeryLongInt )
//     {
//       if ( otherVeryLongInt == null )
//       {
//          throw new NullPointerException();
//       }
//                   
//       return !less(otherVeryLongInt) && !equals(otherVeryLongInt);
//     }


//       public boolean equals( Object obj )
//       {
//          if ( !( obj instanceof VeryLongIntLinkedList) )
//          {
//             return false;
//          }
//       
//          VeryLongIntLinkedList otherVeryLongInt = (VeryLongIntLinkedList)obj;
//       
//          boolean isEqual = true;
//          
//          if ( size() != otherVeryLongInt.size() )
//          {
//             isEqual = false;
//          }
//          else
//          {
//             for ( int digit = size() - 1; isEqual && digit >= 0; digit-- )
//             {
//                if ( least(digit) != otherVeryLongInt.least(digit) )
//                {
//                   isEqual = false;
//                }
//             }
//           }
//           
//           return isEqual;
//       
//       }
      
      public void fibonacci( int n )
      {
         if ( n <= 0 )
         {
            throw new IllegalArgumentException();
         }
         
         VeryLongIntLinkedList previous, current, temp;
        
         if (n <= 2) 
         {
             digits = new VeryLongIntLinkedList(1).digits;
         }
         else
         {
            previous = new VeryLongIntLinkedList(1);
            current =  new VeryLongIntLinkedList(1);
            for (int i = 3; i <= n; i++) 
            {
                temp = new VeryLongIntLinkedList( current.toString() );
                current.add( previous );
                previous = temp;    
            } // for
               
            digits = current.digits;
         }
      }              
} // class VeryLongInt
