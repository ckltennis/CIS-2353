import java.util.Random;

public class RandomTimer
{
   private final int MAX_RANDOM = 20001;
   private final int RANDOM_SEED = 100;
   private int randomNumber;
   private long startTime, finishTime, elapsedTime;
   public static void main(String[] args)
   {  
       new RandomTimer();    
   }
   
   public RandomTimer()
   {
      int runIterations = 10000;
      long currentRun; 
      long longestRun = 0;
      long shortestRun = (long)1000000000.0;
      long averageRun;
      long totalRun = 0;
      
      for ( int i = 0; i < runIterations; i++ )
      {
         currentRun = calculateTimeToGetRandom();
         if ( currentRun > longestRun )
         {
            longestRun = currentRun;
         }
         if ( currentRun < shortestRun )
         {
            shortestRun = currentRun;
         }
         
         totalRun += currentRun;
      }
      
      averageRun = totalRun / (long)runIterations;
      
      System.out.println("Shortest: " + shortestRun );
      System.out.println("Longest: " + longestRun );
      System.out.println("Average: " + averageRun );
      
   }
   
   public long calculateTimeToGetRandom()
   {
      startTime = System.nanoTime( );
      Random random = new Random( RANDOM_SEED );      
      do
      {
         randomNumber = random.nextInt( MAX_RANDOM );
      } while ( randomNumber != 11111 );
      
      finishTime = System.nanoTime( );
      elapsedTime = finishTime - startTime;
      return elapsedTime;
   }
}