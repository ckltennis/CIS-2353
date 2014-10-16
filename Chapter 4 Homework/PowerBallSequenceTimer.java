public class PowerBallSequenceTimer
{
   public static void main(String[] args)
   {
       long startTime, finishTime, elapsedTime;
       int totalTickets = 0;
       
       PowerBallSequence winningTicket = new PowerBallSequence();
       
       startTime = System.nanoTime( );
       PowerBallSequence randomTicket;
       do
       {
         totalTickets++;
         randomTicket = new PowerBallSequence();
         
         if ( totalTickets % 1000000 == 0 )
         {
            System.out.println( totalTickets );
         }
         
       } while ( ! ( winningTicket.equals( randomTicket ) ) );
       
       
       finishTime = System.nanoTime( );
       elapsedTime = finishTime - startTime;
       
       
       System.out.println( elapsedTime / 1000000000.0 );
   }
}