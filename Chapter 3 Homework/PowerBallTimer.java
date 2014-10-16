public class PowerBallTimer
{
   public static void main(String[] args)
   {
       long startTime, finishTime, elapsedTime;
       int totalTickets = 0;
       
       PowerBall winningTicket = new PowerBall();
       
       startTime = System.nanoTime( );
       PowerBall randomTicket;
       do
       {
         totalTickets++;
         randomTicket = new PowerBall();
         
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