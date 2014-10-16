public class EightQueensUser
{
   public static void main(String[] args)
   {
      new EightQueensUser().run();
   }
   
   public void run()
   {
      EightQueens eightQueens = new EightQueens();
      Position start = new Position(0,0);
      eightQueens.markAsPossible( start );
      BackTrack backTrack = new BackTrack( eightQueens );
      backTrack.tryToReachGoal( start );
      System.out.println( eightQueens );
      
   }
}