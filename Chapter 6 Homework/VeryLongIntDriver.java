public class VeryLongIntDriver
{
   public static void main(String args[])
   {
      VeryLongInt veryLongInt = new VeryLongInt( 1 );
      veryLongInt.fibonacci( 100000 );
      System.out.println( veryLongInt );

      // System.out.println( veryLongInt.size() );
//       
//       veryLongInt = new VeryLongInt( 100 );
//       System.out.println( veryLongInt );
//       System.out.println( veryLongInt.size() );
//       
//       System.out.println( veryLongInt.less( new VeryLongInt( 101 ) ) );
//       System.out.println( veryLongInt.less( new VeryLongInt( 10 ) ) );
//       System.out.println( veryLongInt.less( new VeryLongInt( 1 ) ) );
//       
//       System.out.println( veryLongInt.greater( new VeryLongInt( 101 ) ) );
//       System.out.println( veryLongInt.greater( new VeryLongInt( 100 ) ) );
//       System.out.println( veryLongInt.greater( new VeryLongInt( 10 ) ) );
//       System.out.println( veryLongInt.greater( new VeryLongInt( 1 ) ) );
//       
//       System.out.println( veryLongInt.equals( new VeryLongInt( 101 ) ) );
//       System.out.println( veryLongInt.equals( new VeryLongInt( 100 ) ) );
//       System.out.println( veryLongInt.equals( new VeryLongInt( 10 ) ) );
//       System.out.println( veryLongInt.equals( new VeryLongInt( 1 ) ) );
      
      //System.out.println( veryLongInt.least( 2 ) );
   }
}