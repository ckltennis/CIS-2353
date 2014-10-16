public class Reverse
{
   public static void main(String[] args)
   {
      char[] test = "Testing".toCharArray();
      
      System.out.println( test );
      reverseIterative( test );
      System.out.println( test );
      reverseRecursive( test );
      System.out.println( test );
   }
   
   public static void reverseIterative( char[] a )
   {
      int last = a.length - 1;
      
      for ( int index = 0; index < last; index++, last-- )
      {
         char temp = a[index];
         a[index] = a[last];
         a[last] = temp;
      }
   }
   
   public static void reverseRecursive( char[] a )
   {
      recursiveReverse( a, 0, a.length - 1 );
   }
   
   public static void recursiveReverse( char[] a, int index, int last )
   {
      if( index < last )
      {
         char temp = a[index];
         a[index] = a[last];
         a[last] = temp;
         recursiveReverse( a, index + 1, last - 1 );
      }
   }
}