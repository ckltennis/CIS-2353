public class PowerBallTimerArrayList
{
   public static void main(String[] args)
   {
       long startTime, finishTime, elapsedTime;
       int totalTickets = 0;
       int[] balls = { 1,2,3,4,5,6 };
       
       PowerBallArrayList winningTicket = new PowerBallArrayList();
       
       startTime = System.nanoTime( );
       PowerBallArrayList randomTicket;
       do
       {
         totalTickets++;
         randomTicket = new PowerBallArrayList();
         
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