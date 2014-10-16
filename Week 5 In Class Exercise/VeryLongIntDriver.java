public class VeryLongIntDriver
{
   public static void main(String args[])
   {
      VeryLongInt veryLongInt = new VeryLongInt( 1 );
      System.out.println( veryLongInt );
      
      veryLongInt = new VeryLongInt( 0123 );
      System.out.println( veryLongInt );
   
      veryLongInt = new VeryLongInt( 0123 );
      System.out.println( 0123 );
      System.out.println( veryLongInt );
      
      veryLongInt = new VeryLongInt( 1234567890 );
      System.out.println( veryLongInt );
      
      veryLongInt = new VeryLongInt( Integer.MAX_VALUE );
      System.out.println( veryLongInt );
      System.out.println( Integer.MAX_VALUE );
      
      //veryLongInt = new VeryLongInt( -1 );
      //System.out.println( veryLongInt );
   }
}