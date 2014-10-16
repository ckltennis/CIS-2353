import java.util.Random;

public class PowerBallSequence
{
   private static Random RANDOM = new Random( 1000 );
   
   private static final int WHITE_BALLS_IN_TICKET = 5;
   private static final int WHITE_BALLS = 59;
   private static final int RED_BALLS = 35;
   
   private Sequence whiteBalls;
   private int redBall;
   
   public PowerBallSequence()
   {
      whiteBalls = new Sequence( WHITE_BALLS_IN_TICKET );
      
      int[] whiteBallsAvailable = new int[ WHITE_BALLS ];
      
      for ( int index = 0; index < whiteBallsAvailable.length; index++ )
      {
         whiteBallsAvailable[index] = index + 1;
      }
      
      for ( int index = 0; index < WHITE_BALLS_IN_TICKET; index++ )
      {
         int whiteBall = 0;
         while ( whiteBall == 0 )
         {
            whiteBall = whiteBallsAvailable[ RANDOM.nextInt(WHITE_BALLS) ];
         }
         
         whiteBalls.append(whiteBall);
         whiteBallsAvailable[whiteBall - 1] = 0;
      }
      
      redBall = RANDOM.nextInt( RED_BALLS ) + 1;
   }
   
   public Sequence getWhiteBalls()
   {
      return whiteBalls;
   }
   
   public int getRedBall()
   {
      return redBall;
   }
   
   public boolean equals( Object obj )
   {
      if ( !( obj instanceof PowerBallSequence) )
      {
         return false;
      }
      
      PowerBallSequence randomTicket = (PowerBallSequence)obj;
      
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
         for ( int index = 0; index < whiteBalls.size() && match; index++ )
         {
            for ( int randomTicketIndex = 0; 
               randomTicketIndex < randomTicket.getWhiteBalls().size();
               randomTicketIndex++ )
            {
               if ( whiteBalls.get(index) == 
                  randomTicket.getWhiteBalls().get(randomTicketIndex) )
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