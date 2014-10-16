import java.util.Random;

public class PowerBall
{
   private static Random RANDOM = new Random( 1000 );
   
   private static final int WHITE_BALLS = 59;
   private static final int RED_BALLS = 35;
   
   private int[] whiteBalls;
   private int redBall;
   
   public PowerBall()
   {
      whiteBalls = new int[ 5 ];
      
      int[] whiteBallsAvailable = new int[ WHITE_BALLS ];
      
      for ( int index = 0; index < whiteBallsAvailable.length; index++ )
      {
         whiteBallsAvailable[index] = index + 1;
      }
      
      for ( int index = 0; index < whiteBalls.length; index++ )
      {
         int whiteBall = 0;
         while ( whiteBall == 0 )
         {
            whiteBall = whiteBallsAvailable[ RANDOM.nextInt(WHITE_BALLS) ];
         }
         
         whiteBalls[index] = whiteBall;
         whiteBallsAvailable[whiteBall - 1] = 0;
      }
      
      redBall = RANDOM.nextInt( RED_BALLS ) + 1;
   }
   
   public int[] getWhiteBalls()
   {
      return whiteBalls;
   }
   
   public int getRedBall()
   {
      return redBall;
   }
   
   public boolean equals( Object obj )
   {
      if ( !( obj instanceof PowerBall) )
      {
         return false;
      }
      
      PowerBall randomTicket = (PowerBall)obj;
      
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
         for ( int index = 0; index < whiteBalls.length && match; index++ )
         {
            for ( int randomTicketIndex = 0; 
               randomTicketIndex < randomTicket.getWhiteBalls().length;
               randomTicketIndex++ )
            {
               if ( whiteBalls[index] == 
                  randomTicket.getWhiteBalls()[randomTicketIndex] )
               {
                  matches++;
               }
            }
            
            if ( ! (matches == index + 2) )
            {
               match = false;
            }
         }
      }
      
      
      return matches == 6;
   }
}