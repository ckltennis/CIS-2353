public class VeryLongIntDriver
{
   public static void main(String args[])
   {
      VeryLongIntLinkedList veryLongInt = new VeryLongIntLinkedList( 1 );
      
      System.out.println( veryLongInt );

      veryLongInt.fibonacci(100000);
      
      System.out.println( veryLongInt );
   }
}