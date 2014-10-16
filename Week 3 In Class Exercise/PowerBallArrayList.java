import java.util.*;

public class PowerBallArrayList
{
   private static Random RANDOM = new Random( 1000 );
   
   private static final int WHITE_BALLS = 59;
   private static final int RED_BALLS = 35;
   private static final int WHITE_BALLS_IN_TICKET = 5;
   
   private ArrayList<Integer> whiteBalls;
   private int redBall;
   
   public PowerBallArrayList()
   {
      whiteBalls = new ArrayList<Integer>(WHITE_BALLS_IN_TICKET);
           
      for ( int count = 0; count < WHITE_BALLS_IN_TICKET; count++ )
      {
         int whiteBall;
         do
         {
            whiteBall = RANDOM.nextInt( WHITE_BALLS ) + 1;
         } while ( whiteBalls.contains( whiteBall ) );
         
         whiteBalls.add(whiteBall);
         
      }
            
      redBall = RANDOM.nextInt( RED_BALLS ) + 1;
   }
   
   public PowerBallArrayList( int[] balls )
   {
      whiteBalls = new ArrayList<Integer>(WHITE_BALLS_IN_TICKET);
      
      for ( int index = 0; index < WHITE_BALLS_IN_TICKET; index++ )
      {
         whiteBalls.add( balls[index] );
      }
      
      redBall = balls[5];
   }
   
   public ArrayList<Integer> getWhiteBalls()
   {
      return whiteBalls;
   }
   
   public int getRedBall()
   {
      return redBall;
   }
   
   public boolean equals( Object obj )
   {
      if ( !( obj instanceof PowerBallArrayList) )
      {
         return false;
      }
      
      PowerBallArrayList randomTicket 
         = (PowerBallArrayList)obj;
      
      int matches = 0;
      boolean match = true;
      
      if ( redBall == randomTicket.getRedBall() )
      {
         matches++;
      }
      else
      {
         match = false;
      }
      
      if ( match )
      {
         int whiteBall;
         int index = 0;
         Iterator<Integer> iterator = whiteBalls.iterator();
         while ( iterator.hasNext() && match )
         {
            whiteBall = iterator.next();
            if ( randomTicket.getWhiteBalls().contains(whiteBall) )
            {
               matches++;
            }
            
            if ( ! (matches == index + 2) )
            {
               match = false;
            }
            index++;
         }
      }
      
      return matches == 6;
   }
}