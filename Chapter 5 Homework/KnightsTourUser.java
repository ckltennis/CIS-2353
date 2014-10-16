public class KnightsTourUser
{
   public static void main(String[] args)
   {
      new KnightsTourUser().run();
   }
   
   public void run()
   {
      KnightsTour knightsTour = new KnightsTour();
      Position start = new Position(0,1);
      knightsTour.markAsPossible( start );
      BackTrack backTrack = new BackTrack( knightsTour );
      backTrack.tryToReachGoal( start );
      System.out.println( knightsTour );
      
   }
}